package com.rofamex.springbootcrudsqlv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootCrudSqlV2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudSqlV2Application.class, args);
	}

}
