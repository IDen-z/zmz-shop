package com.zmz.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.product.entity.CategoryEntity;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:49:44
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

