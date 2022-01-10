/* Policy Table*/
create table policy(policy_id int ,policy_number int,benefit_id int,premium double,tenure int,cap_amount_benefits double);
/* Benefits Table*/
create table benefits(benefit_id int, benefit_name varchar(50));
/* Member-Policy Table*/
create table member_policy(member_id int,policy_id int,policy_number int,benefit_id int,subscription_date date,tenure int,cap_amount_benefits double);
/* Provider-Policy Table*/
create table provider_policy(provider_id int,provider_name varchar(20),provider_address varchar(50),policy_id int,location varchar(20));