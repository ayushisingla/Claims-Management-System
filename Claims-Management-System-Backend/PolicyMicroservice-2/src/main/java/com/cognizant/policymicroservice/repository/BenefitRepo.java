package com.ayushi.policymicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayushi.policymicroservice.model.Benefits;

public interface BenefitRepo extends JpaRepository<Benefits, Integer> {

	public Benefits findByBenefitId(int benefitId);

}