package com.ayushi.policymicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ayushi.policymicroservice.model.MemberPolicy;

@Repository
public interface MemberPolicyRepo extends JpaRepository<MemberPolicy , Integer>{

	List<MemberPolicy> findAllByPolicyIdAndMemberId(int policyId, int memberId);
	
	@Query("from MemberPolicy mp where mp.policyId=?1 and mp.memberId=?2 and mp.benefitId=?3")
	MemberPolicy findCapAmount(int policyId, int memberId, int benefitId);
	
}