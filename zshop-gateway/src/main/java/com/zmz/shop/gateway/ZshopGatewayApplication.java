package com.zmz.shop.gateway;

import com.zmz.common.configuration.RedisConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 使用exclude时的注意事项
 *
 * 对于非本spring boot项目的第三方jar包
 * 如果希望spring 对其进行包扫描将其注册至spring容器中时，可以采用两种方式
 *
 *  1、 利用第三方jar包中的 META-INF 中spring.factories文件，配置为EnableAutoConfiguration
 *      如果是此种扫描方案，那么在exclude时需要利用 @EnableAutoConfiguration 注解中的exclude，将不希望扫描的类文件排除
 *  2、 利用@ComponentScan注解 指定第三方jar包的希望被扫描的路径
 *      如果是此种方案，那么在exclude时需要利用 此注解中的 excludeFilter 将不希望被扫描到的类排除出去。
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.zmz.common"},excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {RedisConfiguration.class})})
public class ZshopGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZshopGatewayApplication.class, args);
    }

}
