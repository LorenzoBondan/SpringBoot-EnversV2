package com.metaway.AuditoriaV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AuditoriaV2Application {

	public static void main(String[] args) {
		SpringApplication.run(AuditoriaV2Application.class, args);
	}

}
