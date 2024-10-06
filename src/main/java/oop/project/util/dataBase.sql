drop database if exists studentForm;

create databse if not exists studentForm;

use studentForm;

create table student_details(
    name varchar(50) not null primary key,
    email varchar(50) not null,
    contact varchar(20) not null,
    description text
);