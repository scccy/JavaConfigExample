package com.scccy.config;

import com.scccy.handlerInterceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

@Configuration
//开启MVC注解驱动
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("login") // 指定拦截器的URL路径匹配模式
//                .excludePathPatterns("/login", "/register") // 指定不拦截的路径，如登录或注册页面
        ;
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        // 创建一个StringHttpMessageConverter，并设置其字符编码为UTF-8
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

}

