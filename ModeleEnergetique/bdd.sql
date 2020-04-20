-- Create table
create table ME_USER
(
  USER_ID           BIGINT not null,
  userName         VARCHAR(36) not null,
  ENCRYTED_PASSWORD VARCHAR(128) not null,
  ENABLED           BIT not null 
) ;
 
alter table ME_USER
  add constraint ME_USER_PK primary key (USER_ID);
 
alter table ME_USER
  add constraint ME_USER_UK unique (userName);
 
 
-- Create table
create table ME_ROLE
(
  ROLE_ID   BIGINT not null,
  ROLE_NAME VARCHAR(30) not null
) ;

alter table ME_ROLE
  add constraint ME_ROLE_PK primary key (ROLE_ID);
 
alter table ME_ROLE
  add constraint ME_ROLE_UK unique (ROLE_NAME);
 
 
-- Create table
create table ME_USER_ROLE
(
  ID      BIGINT not null,
  USER_ID BIGINT not null,
  ROLE_ID BIGINT not null
);
 
alter table ME_USER_ROLE
  add constraint ME_USER_ROLE_PK primary key (ID);
 
alter table ME_USER_ROLE
  add constraint ME_USER_ROLE_UK unique (USER_ID, ROLE_ID);
 
alter table ME_USER_ROLE
  add constraint ME_USER_ROLE_FK1 foreign key (USER_ID)
  references ME_USER (USER_ID);
 
alter table ME_USER_ROLE
  add constraint ME_USER_ROLE_FK2 foreign key (ROLE_ID)
  references ME_ROLE (ROLE_ID);
 
 
-- Used by Spring Remember Me API.  
CREATE TABLE ME_PERSISTENT_LOGINS (
 
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
     
);
 

 
insert into ME_USER (USER_ID, userName, ENCRYTED_PASSWORD, ENABLED)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into ME_USER (USER_ID, userName, ENCRYTED_PASSWORD, ENABLED)
values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 

 
insert into ME_ROLE (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');
 
insert into ME_ROLE (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER');
 

 
insert into ME_USER_ROLE (ID, USER_ID, ROLE_ID)
values (1, 1, 1);
 
insert into ME_USER_ROLE (ID, USER_ID, ROLE_ID)
values (2, 1, 2);
 
insert into ME_USER_ROLE (ID, USER_ID, ROLE_ID)
values (3, 2, 2);
