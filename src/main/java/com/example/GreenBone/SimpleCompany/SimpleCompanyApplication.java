package com.example.GreenBone.SimpleCompany;

import com.example.GreenBone.SimpleCompany.respository.ComputerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SimpleCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCompanyApplication.class, args);
	}

}
//@Configuration
//public class AppConfig {
//
//	// ... other bean definitions
//
//	@Bean
//	public ComputerRepository computerRepository() {
//		return new ComputerRepositoryImpl();
//	}
//}
