package com.ayushi.policymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Shivranjan Kumar
 *
 */

@SpringBootApplication
@EnableFeignClients
public class PolicyMicroservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(PolicyMicroservice2Application.class, args);
	}

}
