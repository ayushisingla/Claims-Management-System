package com.ayushi.membermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Riteesh Kumar Kanamarlapudi
 *
 */
@SpringBootApplication
@EnableFeignClients
public class MemberMicroserviceApplication {


	public static void main(String[] args) {
		SpringApplication.run(MemberMicroserviceApplication.class, args);
	}

}
