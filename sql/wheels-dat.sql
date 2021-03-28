
insert into vehicletype values ('Toyota','Yaris', '4', 'Hatchback', 'standard');
insert into vehicletype values ('Toyata','Camry', '4', 'Coupe', 'sport');
insert into vehicletype values ('Toyata', 'Corolla', '4', 'Sedan', 'luxury');

insert into dailytariff values ('01', 'super economy');
insert into dailytariff values ('02', 'high');
insert into dailytariff values ('03', 'medium');


insert into records values ('Toyota', 'Yaris', '01', '24.00');
insert into records values ('Toyota', 'Camry', '02', '72.75');
insert into records values ('Toyota', 'Corolla', '03', '100.00');

insert into vehicle values ('123 ABC', '000', 'white', '2019-04-04', '20000','Toyota','Yaris','02', '03' );
insert into vehicle values ('006 XYZ', '003', 'black', '2019-12-26', '50000','Toyata','Camry', '02', '03');
insert into vehicle values ('999 MV', '006', 'blue', '2019-08-04', '70000', 'Toyata', 'Corolla', '04', '06');

insert into client values ('000-021', 'George', '5000');
insert into client values ('000-058', 'William', '5002');
insert into client values ('000-001', 'Elizabeth', '5042');

insert into phonenum values ('000-021', '0411827940');
insert into phonenum values ('000-058', '0467768987');
insert into phonenum values ('000-001', '0491977906');

insert into personclient values ('000-021', 'Sara', 'Williams', 'Mrs','6611827');
insert into personclient values ('000-058', 'John', 'Bailey', 'Mr', '2215195');
insert into personclient values ('000-001', 'Avery', 'Goodwood', 'Miss', '9387461');

insert into companyclient values ('222-010', 'John Brown PTY LTD', '000-021');
insert into companyclient values ('222-018', 'Tillbrook Rasheed', '000-058');
insert into companyclient values ('222-024', 'Huges PTY LTD','000-001');

insert into depot values ('08', 'High Street', '5002', '323 555 1234');
insert into depot values ('12', 'Curry Street', '5051', '144 777 2341');
insert into depot values ('02', 'Abattoir Street', '5033', '555 982 8140');

insert into telephonenum values ('08', '0555 246 280');
insert into telephonenum values ('12', '0222 341 132');
insert into telephonenum values ('02', '0999 082 231');

insert into insurance values ('12414', 'Comprehensive insurance', '128.99');
insert into insurance values ('09773', 'Collision insurance', '189.95');
insert into insurance values ('01931', 'Liability Coverage', '299.99');

insert into hiredvehicle values ('2019-02-16', 'MasterCard', '4336 8712 3456 7890', '10000', '04', '123 ABC', '01', '08', '02', '000-021', '12414', '123-000-12');
insert into hiredvehicle values ('2019-05-27', 'Visa', '4502 3345 4523 3123', '12000', '02', '006 XYZ', '02', '12', '12', '000-058', '09773', '432-120-002');
insert into hiredvehicle values ('2019-03-19', 'MasterCard', '4000 1234 5678 9010', '12900', '01', '999 MV', '03', '02', '04', '000-001', '01931', '999-000-219');

insert into servicehistory values ('2018-02-23', '849.85', 'full-body', '123 ABC', '08');
insert into servicehistory values ('2017-09-30', '1200.90', 'tires only', '006 XYZ', '12');
insert into servicehistory values ('2018-01-01', '2201.55', 'interior,body,tires', '999 MV', '02');

insert into booking values ('2019-02-14', '02', 'white', 'Toyota','Yaris', '08', '000-021');
insert into booking values ('2019-08-02', '04', 'black', 'Toyata','Camry', '12','000-058');
insert into booking values ('2019-03-27', '01', 'blue','Toyata', 'Corolla', '02','000-001');

insert into invoice values ('092', 'Yes', '2019-02-02','2019-02-16', '123 ABC');
insert into invoice values ('201', 'Yes', '2019-01-29','2019-05-27','006 XYZ' );
insert into invoice values ('209', 'Yes', '2019-09-27','2019-03-19', '999 MV');

insert into nominate values ('2019-02-16', '123 ABC', '000-021');
insert into nominate values ('2019-05-27','006 XYZ','000-058' );
insert into nominate values ('2019-03-19', '999 MV','000-001');


.headers on
.mode columns
.echo on
