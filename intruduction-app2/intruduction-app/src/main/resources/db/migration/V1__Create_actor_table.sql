create table actor (
id integer not null auto_increment
, created datetime
, zadanie varchar(255)
, modified datetime not null
, termin datetime not null
, primary key (id)
) engine=InnoDB