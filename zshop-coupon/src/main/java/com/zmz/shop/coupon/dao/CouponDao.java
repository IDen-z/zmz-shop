package com.zmz.shop.coupon.dao;

import com.zmz.shop.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zmz
 * @email *****@gmail.com
 * @date 2021-10-25 19:47:45
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
