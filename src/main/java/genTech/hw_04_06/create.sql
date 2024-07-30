-- Создать новую базу данных webstore

CREATE DATABASE webstore;

--  Создать таблицу products (поля - на ваше усмотрение)

CREATE TABLE products(
                         id int primary key auto_increment,
                         created_at timestamp default current_timestamp,
                         price double not null check(price > 0),
                         name varchar(128) not null
)