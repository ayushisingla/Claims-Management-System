package com.ayushi.claimsmicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.ayushi.claimsmicroservice.model.Claim;
import com.ayushi.claimsmicroservice.repository.ClaimRepository;


/**
 * @author Ayushi Singla
 * Claims - Microservice
 */

@SpringBootApplication
@EnableFeignClients
public class ClaimsMicroserviceApplication implements CommandLineRunner {

	private ClaimRepository claimRepository;

	public ClaimsMicroserviceApplication(ClaimRepository claimRepository) {
		super();
		this.claimRepository = claimRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClaimsMicroserviceApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
	claimRepository.save(new Claim(1, "Pending Action","Claim has been submitted! Please check after few days for confirmation", 1, 1, 201, 1, 100000.0, 80000.0));
	claimRepository.save(new Claim(2, "Pending Action","Claim has been submitted! Please check after few days for confirmation", 2, 2, 202, 2, 100000.0, 60000.0));
	claimRepository.save(new Claim(3, "Pending Action","Claim has been submitted! Please check after few days for confirmation", 3, 3, 203, 3, 80000.0, 60000.0));
	}

}
