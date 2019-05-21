package com.liuyibo.me.config;

import com.liuyibo.me.interceptor.LogIdInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Resource
    RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate(){
        return restTemplateBuilder.build();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogIdInterceptor()).addPathPatterns("/**");
    }

}
