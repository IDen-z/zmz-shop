package com.zmz.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:18:10
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

