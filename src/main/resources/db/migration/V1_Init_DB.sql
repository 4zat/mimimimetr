create sequence hibernate_sequence start 1 increment 1;
create table cat_table (
    cat_id int4 not null,
    cat_name varchar(255),
    cat_point int4 not null,
    filename varchar(255),
    primary key (cat_id));

create table user_role (
    user_id int8 not null,
    roles varchar(255));

create table usr (
    user_id int8 not null,
    active boolean not null,
    choice boolean not null,
    password varchar(255),
    user_name varchar(255),
    primary key (user_id));

alter table if exists user_role
    add constraint FKfpm8swft53ulq2hl11yplpr5 foreign key
    (user_id) references usr