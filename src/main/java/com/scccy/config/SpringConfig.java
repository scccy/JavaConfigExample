package com.scccy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("com.scccy")
@Configuration
@EnableAspectJAutoProxy
public class SpringConfig implements WebMvcConfigurer {
}
