package com.cashe_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CasheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasheDemoApplication.class, args);
	}

}
