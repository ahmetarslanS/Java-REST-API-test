package com.beginsecure.messenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@ComponentScan(basePackages = "com.beginsecure.messenger") // Add this line
public class MessengerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerAppApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("http://34.141.115.209"); // Replace "*" with the specific origin of your website
		config.addAllowedMethod("http://34.141.115.209");
		config.addAllowedHeader("http://34.141.115.209");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
