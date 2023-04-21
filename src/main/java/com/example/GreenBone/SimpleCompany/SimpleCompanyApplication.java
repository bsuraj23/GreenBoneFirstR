package com.example.GreenBone.SimpleCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SimpleCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCompanyApplication.class, args);
	}

}
