package com.ayushi.claimsmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.claimsmicroservice.model.ProviderPolicy;

@Repository
public interface ProviderPolicyRepo extends JpaRepository<ProviderPolicy, Integer>{


	//ProviderPolicy save(ProviderPolicy providers);

	
	List<ProviderPolicy> findAllByPolicyIdOrderByLocation(int PolicyId);

	
	

}