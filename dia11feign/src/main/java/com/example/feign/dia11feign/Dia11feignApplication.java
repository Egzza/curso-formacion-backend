package com.example.feign.dia11feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Dia11feignApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dia11feignApplication.class, args);
	}

}
