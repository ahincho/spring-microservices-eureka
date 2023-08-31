package com.cjava.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SalesBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesBackupApplication.class, args);
	}

}
