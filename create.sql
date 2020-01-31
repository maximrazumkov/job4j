--drop database job4j;
create database job4j 
with owner = postgres
encoding = 'UTF8'
TABLESPACE=pg_default;

create table usr (
	id serial primary key,
	first_name varchar(50),
	last_name varchar(50),
	middle_name varchar(50)
);

insert into usr(first_name, last_name) values('maxim', 'razumkov');

create table roles (
	id serial primary key,
	description varchar(250)
);

insert into roles(description) values('admin');

create table usr_roles (
	user_id int references usr(id),
	role_id int references roles(id)
);

insert into usr_roles(user_id, role_id) values(1, 1);

create table rules (
	id serial primary key,
	description varchar(250)
);

insert into rules(description) values('owner');

create table roles_rules (
	role_id int references roles(id),
	rules_id int references rules(id)
);

insert into roles_rules(role_id, rules_id) values(1, 1);

create table states (
	id serial primary key,
	description varchar(50)
);

insert into states(description) values('created');
insert into states(description) values('working');
insert into states(description) values('closed');

create table category (
	id serial primary key,
	description varchar(50)
);

insert into category(description) values('bug');
insert into category(description) values('dev');
insert into category(description) values('test');

create table item (
	id serial primary key,
	description varchar(250),
	state_id int references states(id),
	category_id int references category(id),
	user_id int references usr(id)
);

insert into item(description, state_id, category_id, user_id) values('First item', 1, 3, 1);

create table commentss (
	id serial primary key,
	description varchar(1024),
	item_id int references item(id)
);

insert into commentss(description, item_id) values('must have', 1);

create table attachs (
	id serial primary key,
	description varchar(1024),
	content bytea,
	item_id int references item(id)
);

insert into commentss(description, item_id) values('must have', 1);