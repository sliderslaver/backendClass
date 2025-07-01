package com.example.Simone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SimoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimoneApplication.class, args);
	}
}
