package com.sandy.example.BootDemo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
		@GetMapping("/test")
		public String helloWorld(){
			return "hello charlie";
		}
		
		@GetMapping("/test_i18n")
		public String helloWorldI18n(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
//			return messageSource.getMessage("good.morning.message", null, locale);
			return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());

		}
}
