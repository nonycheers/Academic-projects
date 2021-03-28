DROP TABLE nominate;
DROP TABLE companyclient;
DROP TABLE personclient;
DROP TABLE client;
DROP TABLE phonenum;
DROP TABLE insurance;
DROP TABLE invoice;
DROP TABLE booking;
DROP TABLE servicehistory;
DROP TABLE hiredvehicle;
DROP TABLE vehicle;
DROP TABLE telephonenum;
DROP TABLE depot;
DROP TABLE records;
DROP TABLE dailytariff;
DROP TABLE vehicletype;

CREATE TABLE vehicletype (
make      	CHAR(8) NOT NULL,
model  	    CHAR(8) NOT NULL,
doors     	INT NOT NULL,
body        INT NOT NULL,
trim        INT NOT NULL,
primary key (make, model),
foreign key (make) references vehicletype(make) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (model) references vehicletype(model) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE dailytariff (
tariff_id		CHAR(2)	NOT NULL,
conditions 	CHAR(50) NOT NULL,
primary key (tariff_id),
foreign key (tariff_id) references dailytariff(tariff_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE records (
make        CHAR(8) NOT NULL,
model	      CHAR(8) NOT NULL,
tariff_id   CHAR(2)	NOT NULL,
rentalPrice DECIMAL(5,2) NOT NULL,
primary key (make, model, tariff_id),
foreign key (make) references vehicletype(make) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (model) references vehicletype(model) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (tariff_id) references dailytariff(tariff_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE vehicle (
regNum	   	        CHAR(7) NOT NULL,
fleetNum            INT(3) NOT NULL,
colour		          CHAR(20) NOT NULL,
scheduleDate        DATE NOT NULL,
kilometrage         INT(5) NOT NULL,
make      	        CHAR(8) NOT NULL,
model  	            CHAR(8) NOT NULL,
scheduledepot_id    INT(2) NOT NULL,
availabledepot_id   INT(2) NOT NULL,
primary key (regNum),
foreign key (make) references vehicletype(make) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (model) references vehicletype(model) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (scheduledepot_id) references depot(depot_id) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (availabledepot_id) references depot(depot_id)  ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE client (
client_id	    	INT(8) NOT NULL,
street	    	  CHAR(45) NOT NULL,
postcode  	    CHAR(4) NOT NULL,
primary key (client_id)
);

CREATE TABLE phonenum (
client_id         INT(8) NOT NULL,
phonenum   	      CHAR(14) NOT NULL,
primary key (client_id, phonenum),
foreign key (client_id) references client(client_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE personclient (
personclient_id		INT(8) NOT NULL,
fname	            CHAR(20) NOT NULL,
lname		          CHAR(20) NOT NULL,
title 		        CHAR(4) NOT NULL,
driverNum 	      CHAR(12) NOT NULL,
primary key (personclient_id),
foreign key (personclient_id) references client(client_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE companyclient (
companyclient_id    INT(8)  NOT NULL,
cname		            CHAR(20) NOT NULL,
personclient_id		  INT(8) NOT NULL,
primary key (companyclient_id),
foreign key (companyclient_id) references client(client_id) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (personclient_id) references client(client_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE depot (
depot_id	   	INT(2) NOT NULL,
street      	CHAR(45) NOT NULL,
postcode		  CHAR(4) NOT NULL,
fax  	        CHAR(14) NULL,
primary key (depot_id)
);

CREATE TABLE telephonenum (
depot_id	          INT(2) NOT NULL,
telephonenum    	  CHAR(14) NOT NULL,
primary key (depot_id, telephonenum),
foreign key (depot_id) references depot(depot_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE insurance (
insurance_id	    	INT(5) NOT NULL,
policyType	    	  TEXT NOT NULL,
cost                DECIMAL(3,2) NOT NULL,
primary key (insurance_id)
);

CREATE TABLE hiredvehicle (
regDate	    	      DATE NOT NULL,
cardType    	      CHAR(20) NOT NULL,
cardNo    	        CHAR(20) NOT NULL,
kilometrage   	    INT(5) NOT NULL,
days    	          INT(2) NOT NULL,
regNum    	        CHAR(7) NOT NULL,
tariff_id           CHAR(2)	NOT NULL,
returndepot_id      INT(2) NOT NULL,
pickupdepot_id      INT(2) NOT NULL,
client_id           INT(8) NOT NULL,
insurance_id	      INT(5) NOT NULL,
policyNum           CHAR(12) NOT NULL,
primary key (regDate, regNum),
foreign key (regNum) references vehicle(regNum) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (tariff_id) references dailytariff(tariff_id)ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (returndepot_id) references depot(depot_id) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (pickupdepot_id) references depot(depot_id) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (client_id) references client(client_id) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (insurance_id) references insurance(insurance_id) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE servicehistory (
regNumDate	    DATE NOT NULL,
cost	    	    DECIMAL(4,2) NOT NULL,
description     CHAR(50) NULL,
regNum    	    CHAR(7) NOT NULL,
depot_id	   	  INT(2) NOT NULL,
primary key (regNumDate)
foreign key (regNum) references vehicle(regNum) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (depot_id) references depot(depot_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE booking (
startDate	    	CHAR(3) NOT NULL,
hireDays	      CHAR(3) NOT NULL,
colour    	    CHAR(3) NOT NULL,
make   	        CHAR(3) NOT NULL,
model    	      CHAR(3) NOT NULL,
depot_id    	  CHAR(3) NOT NULL,
client_id    	  CHAR(3) NOT NULL,
primary key (startDate, client_id),
foreign key (make) references vehicletype(make) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (model) references vehicletype(model) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (depot_id) references depot(depot_id) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (client_id) references client(client_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE invoice (
invoice_id	    	CHAR(3) NOT NULL,
qualityCheck   	  CHAR(3) NOT NULL,
datePaid    	    DATE NULL,
regDate	    	    DATE NOT NULL,
regNum    	      CHAR(7) NOT NULL,
primary key (invoice_id),
foreign Key (regDate) references hiredvehicle(regDate) ON UPDATE CASCADE ON DELETE NO ACTION
foreign Key (regNum) references hiredvehicle(regNum) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE nominate (
regDate	    	    DATE NOT NULL,
regNum    	      CHAR(7) NOT NULL,
personclient_id   CHAR(3) NOT NULL,
primary key (regDate, regNum, personclient_id),
foreign key (regDate) references hiredvehicle(regDate) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (regNum) references hiredvehicle(regNum) ON UPDATE CASCADE ON DELETE NO ACTION
foreign key (personclient_id) references client(client_id) ON UPDATE CASCADE ON DELETE NO ACTION
);
