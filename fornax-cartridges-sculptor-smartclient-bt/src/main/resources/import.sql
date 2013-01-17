INSERT INTO users (ID,USERNAME,PASSWORD,ENABLED,EXPIREAT,CREATEDDATE,CREATEDBY,LASTUPDATED,LASTUPDATEDBY,VERSION,SELECTEDLANGUAGE) VALUES (1,'admin','a4a88c0872bf652bb9ed803ece5fd6e82354838a9bf59ab4babb1dab322154e1','1','2012-01-01', '2009-01-01 01:01:01','system', '2009-01-01 01:01:01','system',0,'en');
INSERT INTO users (ID,USERNAME,PASSWORD,ENABLED,EXPIREAT,CREATEDDATE,CREATEDBY,LASTUPDATED,LASTUPDATEDBY,VERSION,SELECTEDLANGUAGE) VALUES (2,'user','a5700387a0b64f00ff5fe28ee22eb088c2f684a7ad9645d231bdac76b9456c7f','1','2012-01-01', '2009-01-01 01:01:01','system', '2009-01-01 01:01:01','system',0,'en');

INSERT INTO ROLES (ID,ROLENAME,CREATEDDATE,CREATEDBY,LASTUPDATED,LASTUPDATEDBY,VERSION) VALUES (1,'ROLE_ADMIN', '2009-01-01 01:01:01','system', '2009-01-01 01:01:01','system',0);
INSERT INTO ROLES (ID,ROLENAME,CREATEDDATE,CREATEDBY,LASTUPDATED,LASTUPDATEDBY,VERSION) VALUES (2,'ROLE_USER', '2009-01-01 01:01:01','system', '2009-01-01 01:01:01','system',0);


INSERT INTO role_users (USERS,ROLE) VALUES (1,1);
INSERT INTO role_users (USERS,ROLE) VALUES (1,2);
INSERT INTO role_users (USERS,ROLE) VALUES (2,2);