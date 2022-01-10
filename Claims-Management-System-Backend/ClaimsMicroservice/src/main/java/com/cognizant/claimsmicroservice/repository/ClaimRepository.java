package com.ayushi.claimsmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.claimsmicroservice.model.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {


}