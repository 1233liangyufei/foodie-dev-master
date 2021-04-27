package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    public CorsConfig(){

    }
    @Bean
    public CorsFilter corsFilter(){
        // 1 添加cors配置信息
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8080");

        // 2设置是否发送cookie信息
        configuration.setAllowCredentials(true);

        //3 设置允许的请求方式
        configuration.addAllowedMethod("*");

        //4 设置允许的header
        configuration.addAllowedMethod("*");

        //5.为url添加映射路径
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**", configuration);
        //6 重新定义好的corsSource
        return new CorsFilter(corsSource);
    }
}
