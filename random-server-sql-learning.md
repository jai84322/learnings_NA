1- server

hostname -i = will tell you private ip of server
curl ifconfig.me = will tell you public ip of server
systemctl list-units --type=service -all = will list all services active/inactive




2- sql

create database testingdb;  // will create db
use testingdb; // incase you have multiple db then to set default db - won't working in postgres
drop database testingdb; // will delete db 
creare schema testschema; // will create new schema
select current_database(); // will tell you current database name



3- to create a table 

CREATE TABLE testschema.testtable (
    id int,
    name text,
    country text
);

it will run on default selected schema and if you want to explicitly tell then mention in query itself like = schema.tableName

- SHOW search_path; // this will tell you what schema is selected currently
- DROP SCHEMA schema_name CASCADE; // CASCADE is used to automatically drop all objects (tables, views, etc.) inside the schema. Without it, the schema won't be dropped if it contains any objects.
- DROP TABLE schema_name.table_name;



what have i learned ? 
- server cmd to find private ip 
- server cmd to find public ip 
- get private ip by pinging the domain
- get the list of services active/inactive on server 
- create db
- delete db
- current selected db
- create schema 
- delete schema 
- current selected schema
- create table (text and int data type only)
- drop table 