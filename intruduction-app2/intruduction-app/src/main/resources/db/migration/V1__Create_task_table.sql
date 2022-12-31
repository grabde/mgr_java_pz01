create table task (
id integer not null auto_increment
, created datetime
, zadanie varchar(255)
, modified datetime not null
, termin varchar(10)
, primary key (id)
) engine=InnoDB