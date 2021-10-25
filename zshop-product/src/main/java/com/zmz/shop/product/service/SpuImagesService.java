package com.zmz.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.product.entity.SpuImagesEntity;

import java.util.Map;

/**
 * spu图片
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:49:44
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

