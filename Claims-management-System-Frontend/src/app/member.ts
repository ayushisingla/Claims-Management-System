/**
*Member Model class
*/
export class Member {
    memberId! : number;
    policyId! : number;
	paidDate! : Date;
	dueDate! : Date;
	premium! : DoubleRange;
	latePayment! : boolean;
	latePaymentCharges! : number;
}
