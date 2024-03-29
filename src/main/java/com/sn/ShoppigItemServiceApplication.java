package com.sn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
//@EnableHystrix
@SpringBootApplication
@EnableCircuitBreaker
public class ShoppigItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppigItemServiceApplication.class, args);
	}

}
