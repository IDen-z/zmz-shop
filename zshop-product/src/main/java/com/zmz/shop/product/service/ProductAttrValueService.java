package com.zmz.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:18:11
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

