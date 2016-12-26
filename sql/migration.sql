CREATE DATABASE IF NOT EXISTS restaurant_service;

alter table users_to_authorities
  drop
  foreign key FKqoamscde6sl6tyi1nqbevinhy;

alter table users_to_authorities
  drop
  foreign key FK2qwgxdjf7ueefmfkxkg9u0d6k;

drop table if exists Authority;
drop table if exists hibernate_sequences;
drop table if exists Product;
drop table if exists User;
drop table if exists users_to_authorities;

create table hibernate_sequences (
  sequence_name varchar(255) not null,
  next_val bigint,
  primary key (sequence_name)
);

create table Authority (
  id integer not null,
  authority varchar(255),
  primary key (id)
);

create table Product (
  id bigint not null,
  name varchar(255),
  imageUrl varchar(255),
  description varchar(1023),
  primary key (id)
);

create table User (
  id bigint not null,
  email varchar(255),
  password varchar(255),
  username varchar(255),
  primary key (id)
);

create table Receipt (
  id bigint not null,
  timestamp datetime,
  user_id bigint,
  primary key (id)
);

create table users_to_authorities (
  User_id bigint not null,
  authorities_id integer not null,
  primary key (User_id, authorities_id)
);

create table receipt_to_products (
  Receipt_id bigint not null,
  products_id bigint not null
);

alter table Receipt
  add constraint FKn4c65opqoblujl007pjhyd1fn
  foreign key (user_id)
  references User (id);

alter table receipt_to_products
  add constraint FKdan6gjlsfga1oecpyvietskdn
  foreign key (products_id)
  references Product (id);

alter table receipt_to_products
  add constraint FKagx46pn4i3us4wic3j3iev4pn
  foreign key (Receipt_id)
  references Receipt (id);

alter table users_to_authorities
  add constraint FKqoamscde6sl6tyi1nqbevinhy
  foreign key (authorities_id)
  references Authority (id);

alter table users_to_authorities
  add constraint FK2qwgxdjf7ueefmfkxkg9u0d6k
  foreign key (User_id)
  references User (id);

INSERT INTO Product VALUES
  (1, "Pizza", "resources/images/products/pizza1.jpg", "dfsdf sdf sdfsdfsdf sf"),
  (2, "Pizza1", "resources/images/products/pizza2.jpg", "dfsdf sdf sdfsdfsdf sf"),
  (3, "Pizza2", "resources/images/products/pizza3.jpg", "dfsdf sdf sdfsdfsdf sf"),
  (4, "Pizza3", "resources/images/products/pizza4.jpg", "dfsdf sdf sdfsdfsdf sf"),
  (5, "Pizza4", "resources/images/products/pizza5.jpg", "dfsdf sdf sdfsdfsdf sf"),
  (6, "Pizza5", "resources/images/products/pizza6.jpg", "dfsdf sdf sdfsdfsdf sf");