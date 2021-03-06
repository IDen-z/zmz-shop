package com.zmz.shop.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zmz.common.utils.PageUtils;
import com.zmz.common.utils.Query;

import com.zmz.shop.product.dao.SkuInfoDao;
import com.zmz.shop.product.entity.SkuInfoEntity;
import com.zmz.shop.product.service.SkuInfoService;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SkuInfoEntity> getSkusBySpuId(Long spuId) {
        // 根据spuid查询所有的sku信息
        SkuInfoEntity skuInfoEntity = new SkuInfoEntity();
        skuInfoEntity.setSpuId(spuId);
        List<SkuInfoEntity> skuInfoEntityList = baseMapper.selectList(new QueryWrapper<>(skuInfoEntity));
        return skuInfoEntityList;
    }

}