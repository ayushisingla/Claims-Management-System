/* Policy Table*/
create table policy(policy_id int,policy_number int,benefit_id int,premium double,tenure int);

/* Benefits Table*/
create table benefits(benefit_id int, benefit_name varchar(50));

/* Member-Policy Table*/
create table member_policy(member_id int,policy_id int,policy_number int,benefit_id int,subscription_date date,tenure int,cap_amount_benefits double);

/* Provider-Policy Table*/
create table provider_policy(provider_id int,provider_name varchar(20),provider_address varchar(50),policy_id int,location varchar(20));

/* member_premium table */
create table member_premium(member_id int,policy_id int,paid_date date,due_date date,premium double,late_payment boolean,late_payment_charges double);

/* member_claim table */
create table member_claim(policy_id int,member_id int,claim_id int,provider_id int,benefit_id int,total_billed_amount double,total_claimed_amount double,claim_status varchar(20),claim_description varchar(30),primary key(claim_id));