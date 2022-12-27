create table director (
id integer not null auto_increment,
created datetime,
modified datetime not null,
first_name varchar(255),
last_name varchar(255),
deleted datetime,
primary key (id)
) engine=InnoDB;

alter table movie add column director_id integer;

alter table movie add constraint movie_fk0 foreign key (director_id) references
director (id);

insert into director (created, modified, first_name, last_name)
values (now(), now(), 'Pierwszy', 'Reżyser');
insert into director (created, modified, first_name, last_name)
values (now(), now(), 'Drugi', 'Reżyser');
insert into director (created, modified, first_name, last_name)
values (now(), now(), 'Trzeci', 'Reżyser');