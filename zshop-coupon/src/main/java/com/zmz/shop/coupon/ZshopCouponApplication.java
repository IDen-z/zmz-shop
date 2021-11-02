package com.zmz.shop.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
public class ZshopCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZshopCouponApplication.class, args);
    }

}
