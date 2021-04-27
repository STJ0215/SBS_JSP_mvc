CREATE DATABASE board;

CREATE TABLE board (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(32) NOT NULL,
  content TEXT NOT NULL,
  primary key (id)
);

CREATE TABLE MEMBER(
	id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	userid varchar(50) NOT NULL,
	userpw varchar(50) NOT NULL,
	name varchar(32) NOT NULL,
	mail varchar(50) NOT NULL,
  	content TEXT NOT NULL,
  	primary key (id)
);