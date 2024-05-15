package com.scccy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("com.scccy")
@Configuration
//aop开启
@EnableAspectJAutoProxy
// 开启事务
@EnableTransactionManagement
public class SpringConfig implements WebMvcConfigurer {
}
