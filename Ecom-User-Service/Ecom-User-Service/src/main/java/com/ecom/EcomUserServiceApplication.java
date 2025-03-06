package com.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EcomUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomUserServiceApplication.class, args);
	}

}
