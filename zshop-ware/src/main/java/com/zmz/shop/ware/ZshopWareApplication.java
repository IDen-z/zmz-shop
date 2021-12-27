package com.zmz.shop.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan(basePackages = "com.zmz.shop.ware.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class ZshopWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZshopWareApplication.class, args);
    }

}
