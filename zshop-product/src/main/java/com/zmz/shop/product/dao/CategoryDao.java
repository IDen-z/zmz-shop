package com.zmz.shop.product.dao;

import com.zmz.shop.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:49:44
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
