package com.zmz.shop.coupon.provider;

import com.zmz.common.utils.R;
import com.zmz.shop.coupon.entity.CouponEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@FeignClient("zshop-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/test-feign")
    public R membercoupons();


}
