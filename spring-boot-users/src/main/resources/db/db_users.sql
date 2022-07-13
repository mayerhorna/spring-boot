--CREATE DATABASE IF NOT EXISTS db_users;
 

 
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user (
  code integer NOT NULL PRIMARY KEY,
  name varchar(45) default NULL,
  password varchar(45) default NULL,
  gender varchar(45) default NULL,
  country varchar(45) default NULL,
  aboutYou varchar(45) default NULL,
  community varchar(100) default NULL,
  mailingList boolean default NULL
);
 
DROP SEQUENCE IF EXISTS seq_user;
CREATE SEQUENCE seq_user INCREMENT 1 MINVALUE 1 MAXVALUE 9999999999 START 1 CACHE 1;
ALTER TABLE  tb_user ALTER COLUMN  code SET DEFAULT nextval('seq_user'::regclass);
 
--
-- Dumping data for table `tb_user`
--
INSERT INTO tb_user (code,name,password,gender,country,aboutYou,community,mailingList) VALUES 
 (3,'Evelyn Cautin','','F','3','Student','Struts','1'),
 (4,'Carlos Cubas','ccubas','M','1','soccer player','Hibernate','0'),
 (5,'Jonathan Lara','','M','2','Worker','Spring,Hibernate,Struts','0'),
 (6,'Nadia Leyva','1234','F','0','Traveler','Spring','1');
 
 

 
