CREATE TABLE pet_procedure (
pet_id integer NOT NULL,
procedure_id integer NOT NULL,
date timestamp NOT NULL,
CONSTRAINT fk_pet_procedure_pet_id FOREIGN KEY (pet_id) REFERENCES pet(pet_id),
CONSTRAINT fk_pet_procedure_procedure_id FOREIGN KEY (procedure_id) REFERENCES procedure(procedure_id)
);

CREATE TABLE procedure (
procedure_id integer NOT NULL,
name varchar(64) NOT NULL,
price float NOT NULL,
CONSTRAINT pk_procedure_procedure_id PRIMARY KEY (procedure_id)
);

CREATE TABLE pet (
pet_id serial NOT NULL,
name varchar(64) NOT NULL,
age integer NOT NULL,
type varchar(64) NOT NULL,
breed varchar(64) NOT NULL,
CONSTRAINT pk_pet_pet_id PRIMARY KEY (pet_id)
);

CREATE TABLE email (
email_id serial NOT NULL,
type varchar(8) NOT NULL,
address varchar(64) NOT NULL,
CONSTRAINT pk_email_email_id PRIMARY KEY (email_id)
);

CREATE TABLE phone (
phone_id serial NOT NULL,
type varchar(8) NOT NULL,
number varchar(16) NOT NULL,
CONSTRAINT pk_phone_phone_id PRIMARY KEY (phone_id)
);

CREATE TABLE address (
address_id serial NOT NULL,
line_one varchar(150) NOT NULL,
line_two varchar(150),
city varchar(64) NOT NULL,
state varchar(64) NOT NULL,
postal_code varchar(15) NOT NULL,
type varchar(8),
description varchar(255),
CONSTRAINT pk_address_address_id PRIMARY KEY (address_id)
);

CREATE TABLE owner (
person_id serial NOT NULL,
first_name varchar(64) NOT NULL,
last_name varchar(64) NOT NULL,
salutation varchar(8),
pet_id integer NOT NULL,
address_id integer NOT NULL,
email_id integer NOT NULL,
phone_id integer NOT NULL,
CONSTRAINT pk_owner_person_id PRIMARY KEY (person_id),
CONSTRAINT fk_owner_pet_id FOREIGN KEY (pet_id) REFERENCES pet(pet_id),
CONSTRAINT fk_owner_address_id FOREIGN KEY (address_id) REFERENCES address(address_id),
CONSTRAINT fk_owner_email_id FOREIGN KEY (email_id) REFERENCES email(email_id),
CONSTRAINT fk_owner_phone_id FOREIGN KEY (phone_id) REFERENCES phone(phone_id)
);
