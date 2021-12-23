package com.zmz.shop.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 1、 导入依赖
 * 2、 编写配置 主要是给容器中注入一个 RestHighLevelClient 对象
 */
@Configuration
public class ZshopEsConfiguration {


    @Bean
    RestHighLevelClient client() {
        RestClientBuilder builder = RestClient.builder(new HttpHost("192.168.80.130", 9200,
                "http"));
        return new RestHighLevelClient(builder);
    }


}
