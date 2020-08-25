package com.mari.sample01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mari.sample01.common.token.JwtInterceptor;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	private static final String[] EXCLUDE_PATHS = {
	        "/api/login",
			"/sample",
			"/v2/api-docs",
			"/swagger-ui.html",
			"/swagger-resources/**",
            "/webjars/springfox-swagger-ui/**",
            "/swagger/**",
            "/error"
	};
	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/"); 
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/"); 
	}

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns(EXCLUDE_PATHS);
	}
	
}
