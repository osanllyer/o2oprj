package com.lfb.web.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(value="com.lfb.web")
public class WebConfig extends WebMvcConfigurerAdapter {

	public WebConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public ViewResolver getViewResolver(){
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/views/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	}

}
