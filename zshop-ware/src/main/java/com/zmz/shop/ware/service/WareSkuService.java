package com.zmz.shop.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.ware.entity.WareSkuEntity;
import com.zmz.shop.ware.vo.SkuHasStockVo;

import java.util.List;
import java.util.Map;

/**
 * εεεΊε­
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-11-02 15:37:30
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);
}

