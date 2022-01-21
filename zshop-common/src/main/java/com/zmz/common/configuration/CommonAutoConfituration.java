package com.zmz.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {CommonStartConfiguration.class,MybatisPlusConfiguration.class,
        RedissonConfiguration.class})
public class CommonAutoConfituration {
}
