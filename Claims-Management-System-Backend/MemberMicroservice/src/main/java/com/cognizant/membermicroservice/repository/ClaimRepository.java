package com.ayushi.membermicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.membermicroservice.model.MemberClaim;

/**
 * 
 * This interface communicates with database to fetch the claim details.
 *
 */

@Repository
public interface ClaimRepository extends JpaRepository<MemberClaim, Integer> {

	/**
	 * 
	 * @param memberId
	 * @return List<MemberClaim>
	 */

	public List<MemberClaim> findBymemberId(Integer memberId);

	/**
	 * 
	 * @param policyId
	 * @return List<MemberClaim>
	 */

	public List<MemberClaim> findBypolicyId(Integer policyId);

	/**
	 * 
	 * @param claimId
	 * @return List<MemberClaim>
	 */

	public List<MemberClaim> findByclaimId(Integer claimId);

	/**
	 * 
	 * @param claims
	 * @return
	 */

	MemberClaim save(MemberClaim claims);

}
