package com.zmz.shop.ware.service.impl;

import com.zmz.shop.ware.vo.SkuHasStockVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zmz.common.utils.PageUtils;
import com.zmz.common.utils.Query;

import com.zmz.shop.ware.dao.WareSkuDao;
import com.zmz.shop.ware.entity.WareSkuEntity;
import com.zmz.shop.ware.service.WareSkuService;


@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WareSkuEntity> page = this.page(
                new Query<WareSkuEntity>().getPage(params),
                new QueryWrapper<WareSkuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds) {
        List<SkuHasStockVo> res = skuIds.stream().map(skuId -> {
            SkuHasStockVo skuHasStockVo = new SkuHasStockVo();
            skuHasStockVo.setSkuId(skuId);
            Long count = baseMapper.getSkuStock(skuId);
            if (Objects.nonNull(count)) {
                skuHasStockVo.setHasStock(count > 0);
            } else {
                skuHasStockVo.setHasStock(false);
            }
            return skuHasStockVo;
        }).collect(Collectors.toList());
        return res;
    }

}