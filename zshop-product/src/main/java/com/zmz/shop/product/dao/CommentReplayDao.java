package com.zmz.shop.product.dao;

import com.zmz.shop.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 14:18:11
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
