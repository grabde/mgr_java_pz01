create table movie (
id integer not null auto_increment,
created datetime,
modified datetime not null,
title varchar(255),
release_year varchar(80),
deleted datetime,
primary key (id)
) engine=InnoDB;