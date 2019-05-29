package com.cultswitch.ews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages="com.cultswitch.ews")
@EntityScan(basePackages="com.cultswitch.ews.jpa.model")
@EnableJpaRepositories(basePackages={"com.cultswitch.ews.jpa.repository"})
@EnableScheduling
public class EwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwsApplication.class, args);
	}

}
