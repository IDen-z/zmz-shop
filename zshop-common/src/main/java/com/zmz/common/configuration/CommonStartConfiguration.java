package com.zmz.common.configuration;

import com.zmz.common.exception.ZshopGlobalException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonStartConfiguration {

    /**
     *  全局异常处理类
     */
    @Bean
    public ZshopGlobalException globalException(){
        return new ZshopGlobalException();
    }





}
