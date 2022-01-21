package com.zmz.common.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class RedissonConfiguration {

    @Bean(destroyMethod="shutdown")
    RedissonClient redisson() throws IOException {
        /**
         * 集群模式
         */
//        Config config = new Config();
//        config.useClusterServers()
//                .addNodeAddress("127.0.0.1:7004", "127.0.0.1:7001");

        /**
         * 单节点模式
         */
        Config config = new Config();
        // 必须加上redis:// 才能进行连接  如果是SSL安全连接需要加上rediss://
        config.useSingleServer().setAddress("redis://192.168.80.130:6379");
        return Redisson.create(config);
    }

}
