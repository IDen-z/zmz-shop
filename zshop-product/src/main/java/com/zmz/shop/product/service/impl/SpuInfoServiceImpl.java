package com.zmz.shop.product.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.zmz.common.model.SkuEsModel;
import com.zmz.common.utils.R;
import com.zmz.shop.product.entity.*;
import com.zmz.shop.product.provider.EsFeignService;
import com.zmz.shop.product.provider.WareFeignService;
import com.zmz.shop.product.service.*;
import com.zmz.shop.product.vo.SkuHasStockVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zmz.common.utils.PageUtils;
import com.zmz.common.utils.Query;

import com.zmz.shop.product.dao.SpuInfoDao;

import javax.annotation.Resource;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Autowired
    private SkuInfoService skuInfoService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductAttrValueService attrValueService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private WareFeignService wareFeignService;

    @Autowired
    private EsFeignService esFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 商品上下架  刷新es
     */
    @Override
    public void up(Long spuId) {
        List<SkuEsModel> upProducts = new ArrayList<>();

        // 1、根据spu查出所有的sku
        List<SkuInfoEntity> skuInfoEntities = skuInfoService.getSkusBySpuId(spuId);

        // 由于规格属性根据spu决定 在外面查一遍即可shoud
        List<ProductAttrValueEntity> productAttrValues = attrValueService.baseAttrListforspu(spuId);
        List<Long> attrIds = productAttrValues.stream().map(ProductAttrValueEntity::getAttrId).collect(Collectors.toList());
        List<Long> searchAbleIds = attrService.selectSearchAttrs(attrIds);

        // 批量查询库存信息
        R<List<SkuHasStockVo>> R = wareFeignService.getSkuHasStock(skuInfoEntities.stream().map(SkuInfoEntity::getSkuId).collect(Collectors.toList()));
        TypeReference<List<SkuHasStockVo>> typeReference = new TypeReference<List<SkuHasStockVo>>() {
        };
        List<SkuHasStockVo> hasStockVos = R.getData(typeReference);
        Map<Long, Boolean> skuStock = hasStockVos.stream().collect(Collectors.toMap(SkuHasStockVo::getSkuId, SkuHasStockVo::getHasStock));

        List<SkuEsModel.Attrs> attrsEsModelLists = productAttrValues.stream().filter(item -> searchAbleIds.contains(item.getAttrId()))
                .map(item -> {
                    SkuEsModel.Attrs attrs = new SkuEsModel.Attrs();
                    BeanUtils.copyProperties(item, attrs);
                    return attrs;
                }).collect(Collectors.toList());
        // 2、封装需要的信息
        List<SkuEsModel> esModelList = skuInfoEntities.stream().map(sku -> {
            // 组装需要的数据
            SkuEsModel esModel = new SkuEsModel();
            BeanUtils.copyProperties(sku, esModel);
            // 处理额外信息
            esModel.setSkuPrice(sku.getPrice());
            esModel.setSkuImg(sku.getSkuDefaultImg());
            // 封装品牌信息 未判空
            BrandEntity brandEntity = brandService.getById(sku.getBrandId());
            esModel.setBrandName(brandEntity.getName());
            esModel.setBrandImg(brandEntity.getLogo());
            // 封装分类信息 未判空
            CategoryEntity categoryEntity = categoryService.getById(sku.getCatalogId());
            esModel.setCatalogName(categoryEntity.getName());
            // 封装每组spu商品一致的attr信息
            esModel.setAttrs(attrsEsModelLists);
            // 热度信息
            esModel.setHotScore(0L);
            // 封装库存信息  循环中避免微服务调用
            esModel.setHasStock(skuStock.get(sku.getSkuId()));
            return esModel;
        }).collect(Collectors.toList());
        // 测试
//        esModelList.forEach(System.err::println);
        // 存入es
        esFeignService.productUp(esModelList);

        // TODO 修改当前商品的上下架状态
        // TODO 如果成功 修改当前spu状态
        // TODO 如果失败 重复调用？ 考虑接口幂等性？

    }

}