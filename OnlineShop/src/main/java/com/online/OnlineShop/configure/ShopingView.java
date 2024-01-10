package com.online.OnlineShop.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@SuppressWarnings("deprecation")
@Configuration
@ComponentScan(basePackages = "com.online")
@EnableWebMvc
public class ShopingView extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
	}
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver ver=new InternalResourceViewResolver();
		ver.setViewClass(JstlView.class);
		ver.setPrefix("/WEB-INF/view/");
		ver.setSuffix(".jsp");
		return ver;
	}
	
}
