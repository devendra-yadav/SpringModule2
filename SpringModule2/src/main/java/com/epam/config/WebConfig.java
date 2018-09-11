package com.epam.config;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.epam")
@PropertySource("classpath:view-resolver-order.properties")
@MultipartConfig
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver beanNameViewResolver() {
		BeanNameViewResolver viewResolver=new BeanNameViewResolver();
		viewResolver.setOrder(Integer.parseInt(env.getProperty("bean-resolver")));
		return viewResolver;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		
		viewResolver.setOrder(Integer.parseInt(env.getProperty("internal_resource")));
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public FreeMarkerViewResolver freeMarkerViewResolver() {
		
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setOrder(Integer.parseInt(env.getProperty("freemarker")));
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".ftl");
		
		return viewResolver;
	}
	
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		
		FreeMarkerConfigurer configurer=new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");
		
		return configurer;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource resourceBundle=new ResourceBundleMessageSource();
		resourceBundle.addBasenames("validation-messages");
		
		return resourceBundle;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10*1024*1024);
		
		return multipartResolver;
	}
	

}
