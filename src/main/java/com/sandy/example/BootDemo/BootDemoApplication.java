package com.sandy.example.BootDemo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootDemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@Bean
	public AcceptHeaderLocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver sessionLocaleResolver = new AcceptHeaderLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	@Bean 
	public ResourceBundleMessageSource messageSource(){
		
		ResourceBundleMessageSource reMessageSource = new ResourceBundleMessageSource();
		
		reMessageSource.setBasename("messages");
		
		return reMessageSource;
	}
}
