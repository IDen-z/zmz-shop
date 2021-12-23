package com.zmz.common.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 这里是 无主启动类 的项目
 * 如果希望这个bean能够被对应的服务在启动时加载
 * 必须配置META-INF 文件夹中的configuration的包名
 *
 */
@Configuration
@EnableTransactionManagement // 开启事务功能
public class MybatisPlusConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}
