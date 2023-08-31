package com.cjava.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "cjava-sales")
@EnableFeignClients
@SpringBootApplication
public class ClientRibbonBalancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRibbonBalancedApplication.class, args);
	}

}
