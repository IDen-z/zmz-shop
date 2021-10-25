package com.zmz.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:18:11
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

