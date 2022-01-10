package com.ayushi.policymicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.policymicroservice.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Integer> {

}
