package com.zmz.shop.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.zmz.shop.product.dao")
@SpringBootApplication
public class ZshopProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZshopProductApplication.class, args);
    }

}