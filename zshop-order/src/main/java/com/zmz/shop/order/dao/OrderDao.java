package com.zmz.shop.order.dao;

import com.zmz.shop.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-11-02 15:31:52
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
