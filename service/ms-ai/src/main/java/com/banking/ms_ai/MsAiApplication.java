package com.banking.ms_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAiApplication.class, args);
	}

}
