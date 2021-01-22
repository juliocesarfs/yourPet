-- DDL -- Data Definition Language
CREATE TABLE public.pet
(
	id serial NOT NULL,
	name character varying(40) NOT NULL,
	race character varying(40),
	specie character varying(40) NOT NULL,
	birth date NOT NULL,
	gender character varying(1) NOT NULL
	PRIMARY KEY (id)
)
