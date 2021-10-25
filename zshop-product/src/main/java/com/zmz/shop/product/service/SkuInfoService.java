package com.zmz.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:49:45
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

