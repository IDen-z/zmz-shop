package com.zmz.shop.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmz.common.utils.PageUtils;
import com.zmz.shop.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-11-02 15:31:52
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

