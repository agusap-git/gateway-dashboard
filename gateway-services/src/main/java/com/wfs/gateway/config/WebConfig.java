package com.wfs.gateway.config;

import com.wfs.gateway.config.resolver.UserDetailsArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by aaltamir on 8/21/16.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(createUserDetailsResolver());
    }

    /**
     *
     * @return
     */
    @Bean
    public UserDetailsArgumentResolver createUserDetailsResolver() {
        return new UserDetailsArgumentResolver();
    }
}
