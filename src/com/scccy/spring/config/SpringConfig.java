package com.scccy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("com.scccy")
@Configuration
public class SpringConfig implements WebMvcConfigurer {
}
