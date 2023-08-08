package com.english.ua.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@EnableWebMvc
@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final Environment env;

    @Override
    public void addResourceHandlers(@NonNull final ResourceHandlerRegistry registry) {
        if (Arrays.stream(env.getActiveProfiles()).anyMatch(profile -> profile.equals("localDocker") || profile.equals("prod"))) {
            registry
                    .addResourceHandler("/images/articles/**")
                    .addResourceLocations("file:/static/images/articles/");
        } else {
            registry
                    .addResourceHandler("/images/articles/**")
                    .addResourceLocations("classpath:/static/images/articles/");
        }
    }
}
