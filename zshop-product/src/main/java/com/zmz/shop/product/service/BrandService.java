package com.zmz.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:49:44
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

