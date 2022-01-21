package com.zmz.shop.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "com.zmz.shop.product.dao")
@SpringBootApplication(scanBasePackages = {"com.zmz"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.zmz.shop.product.provider"})
public class ZshopProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZshopProductApplication.class, args);
    }

}
