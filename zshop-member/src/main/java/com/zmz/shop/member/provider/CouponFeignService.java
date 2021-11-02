package com.zmz.shop.member.provider;

import com.zmz.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("zshop-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/test-feign")
    public R membercoupons();


}
