package com.project.iacontent.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
@Configuration
@EnableWebMvc
*/
public class WebConfig implements WebMvcConfigurer {
    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // WebMvcConfigurer.super.addViewControllers(registry);
        // registry.addRedirectViewController("/list", "/list-employee");
        registry.addViewController("/product/{id}").setViewName("redirect:/product-details/{id}");
        registry.addViewController("/person").setViewName("Person");
    }*/
}
