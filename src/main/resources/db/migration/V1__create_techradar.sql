create table tech_group(
   id int primary key auto_increment not null,
   name varchar(50) not null,
   description varchar(10000)
);

create table category(
   id int primary key auto_increment not null,
   name varchar(50) not null
);

create table technology(
   id int primary key auto_increment not null,
   name varchar(50) not null,
   description varchar(5000) not null,
   tech_group_id int  not null,
   category_id int not null,
   foreign key(tech_group_id) references tech_group(id),
   foreign key(category_id) references category(id)
);
