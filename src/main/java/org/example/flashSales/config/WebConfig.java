package org.example.flashSales.config;

import org.example.flashSales.interceptor.AccessInterceptor;
import org.example.flashSales.resolver.UserArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @description: Spring MVC的相关配置
 * @see: https://songjin.io/2018/07/01/springboot-webmvcconfigurer/
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Autowired
    private UserArgumentResolver userArgumentResolver;
    @Autowired
    private AccessInterceptor accessInterceptor;

    /**
     * Spring MVC的参数解析器，用于添加自定义参数解析器
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }

    /**
     * Spring MVC的拦截器，用于添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor);
    }
}