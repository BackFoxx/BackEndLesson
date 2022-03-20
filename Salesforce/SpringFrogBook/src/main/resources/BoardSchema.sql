create table BOARD (
    seq int generated always as identity primary key ,
    title varchar(255) not null ,
    content varchar(1000) not null ,
    writer varchar(10) not null ,
    password int not null ,
    regDate timestamp not null ,
    cnt int not null
);