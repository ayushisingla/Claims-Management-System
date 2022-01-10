
export class Claim {
    claimId! : number;
	policyId! : number;
	memberId! : number;
	providerId! : number;
	benefitId! : number;
	totalBilledAmount! : DoubleRange;
	totalClaimedAmount! : DoubleRange;
	claimStatus! : string;
	claimDescription! : string;
}
