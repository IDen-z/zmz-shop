package com.zmz.shop.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.zmz.shop.member.provider"})
public class ZshopMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZshopMemberApplication.class, args);
    }

}
