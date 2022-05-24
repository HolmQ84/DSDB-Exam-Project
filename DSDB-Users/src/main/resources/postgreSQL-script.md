CREATE SCHEMA IF NOT EXISTS music;

CREATE USER test1234 WITH ENCRYPTED PASSWORD 'test1234';
GRANT ALL PRIVILEGES ON SCHEMA music to test1234;

CREATE TABLE music.city (
city_id				INT				GENERATED ALWAYS AS IDENTITY		UNIQUE,
city_name			VARCHAR(100)	NOT NULL,
postal_code 		INT 			NOT NULL,
PRIMARY KEY(city_id)
);

CREATE TABLE music.street (
street_id			INT				GENERATED ALWAYS AS IDENTITY		UNIQUE,
street_name			VARCHAR(100)	NOT NULL,
PRIMARY KEY(street_id)
);

CREATE TABLE music.address (
address_id			INT				GENERATED ALWAYS AS IDENTITY		UNIQUE,
street_id			INT,
street_number		VARCHAR(10)		NOT NULL,
city_id				INT,
country				VARCHAR(50),
PRIMARY KEY(address_id),
CONSTRAINT fk_city
FOREIGN KEY(city_id)
REFERENCES music.city(city_id),
CONSTRAINT fk_street
FOREIGN KEY(street_id)
REFERENCES music.street(street_id)
);

CREATE TABLE music.person (
person_id			INT				GENERATED ALWAYS AS IDENTITY		UNIQUE,
first_name			VARCHAR(100)	NOT NULL,
last_name 			VARCHAR(100) 	NOT NULL,
birthdate			DATE			NULL,
address_id			INT				NOT NULL,
PRIMARY KEY(person_id),
CONSTRAINT fk_address
FOREIGN KEY(address_id)
REFERENCES music.address(address_id)
);

CREATE TABLE music.users (
user_id				INT				GENERATED ALWAYS AS IDENTITY		UNIQUE,
username			VARCHAR(100)	NOT NULL,
password			VARCHAR(100)	NOT NULL,
email				VARCHAR(100)	NOT NULL,
user_level			VARCHAR(10) 	NOT NULL,
person_id			INT,
PRIMARY KEY(user_id),
CONSTRAINT fk_person
FOREIGN KEY(person_id)
REFERENCES music.person(person_id)
);
