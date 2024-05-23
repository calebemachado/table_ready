create table app_user (id uuid not null, phone_id uuid unique, name varchar(255), surname varchar(255), primary key (id));
create table phone (area_code integer, number integer, id uuid not null, primary key (id));
alter table if exists app_user add constraint FKnbfvr7h3mo19knh1d4j9ryfke foreign key (phone_id) references phone;
create table app_user (id uuid not null, phone_id uuid unique, name varchar(255), surname varchar(255), primary key (id));
create table phone (area_code integer, number integer, id uuid not null, primary key (id));
alter table if exists app_user add constraint FKnbfvr7h3mo19knh1d4j9ryfke foreign key (phone_id) references phone;
create table app_user (id uuid not null, phone_id uuid unique, name varchar(255), surname varchar(255), primary key (id));
create table phone (area_code integer, number integer, id uuid not null, primary key (id));
alter table if exists app_user add constraint FKnbfvr7h3mo19knh1d4j9ryfke foreign key (phone_id) references phone;
