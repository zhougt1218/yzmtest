package com.sdyy.springboot.cs.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sdyy.springboot.cs.filter.CharSetFilter;

@Configuration
public class MyConfig {

	@Bean
	public FilterRegistrationBean myFilter(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new CharSetFilter());
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}
}
