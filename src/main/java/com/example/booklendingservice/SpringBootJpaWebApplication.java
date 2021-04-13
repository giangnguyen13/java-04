package com.example.booklendingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootJpaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaWebApplication.class, args);
		System.setProperty("spring.config.name", "customer-book-lending");
	    System.out.println("Spring Boot JPA Information Service started");
	}

}
