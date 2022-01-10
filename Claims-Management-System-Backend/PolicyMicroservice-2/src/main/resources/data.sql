/*Inserting data in policy table*/
insert into policy (policy_id,policy_number,benefit_id,premium,tenure,cap_amount_benefits) values(1,101,201,5000.0,25,5000.0);
insert into policy (policy_id,policy_number,benefit_id,premium,tenure,cap_amount_benefits ) values(2,102,203,8000.0,21,8000.0);
insert into policy (policy_id,policy_number,benefit_id,premium,tenure,cap_amount_benefits ) values(3,103,203,15000.0,14,15000.0);

/*Inserting data in benefits table*/
insert into benefits (benefit_id,benefit_name) values(201,'Free Monthly Health Checkup');
insert into benefits (benefit_id,benefit_name) values(202,'Cashless Medical Treatment');
insert into benefits (benefit_id,benefit_name) values(203,'Coverage For Covid-19 Treatment');
insert into benefits (benefit_id,benefit_name) values(204,'Daily Hospital Cash Benefit');
insert into benefits (benefit_id,benefit_name) values(205,'Tax Benefits On The Health Insurance Premium');

/*Inserting data in member_policy table*/
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(1,1,101,202,'2021-06-24',21,100000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(2,1,101,201,'2020-03-07',21,120000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(3,2,102,203,'2019-01-09',14,80000.00);

/*Inserting data in provider_policy table*/
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(1,'MG Road','City Hospital',1,'Chennai');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(2,'Chitnis Nagar','LIC',1,'Nagpur');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(3,'Chandni Chowk','Bajaj',2,'Delhi');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(4,'Dhayari','Apollo Hospital',3,'Pune');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(5,'Boriwali','HDFC',2,'Mumbai');
