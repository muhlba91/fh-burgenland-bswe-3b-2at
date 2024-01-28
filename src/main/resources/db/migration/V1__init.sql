-- person
CREATE TABLE PERSON (
	id varchar(255) PRIMARY KEY,
	first_name varchar(255) not null,
	last_name varchar(255) not null
);

insert into PERSON (id, first_name, last_name) values ('81150016-8501-4b97-9168-01113e21d8a5', 'John', 'Doe');
insert into PERSON (id, first_name, last_name) values ('d891323f-a3ad-4a95-b340-2e1c8aa8d1bd', 'Jane', 'Doe');

-- note
CREATE TABLE NOTE (
	id varchar(255) PRIMARY KEY,
	person_id varchar(255) not null,
	content varchar(255) not null
);

insert into NOTE (id, person_id, content) values ('c5b38625-7eed-4705-858d-c685f18ed47d', '81150016-8501-4b97-9168-01113e21d8a5', 'Note 1');
