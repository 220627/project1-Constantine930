CREATE TABLE Ers_reim(
reim_ID serial PRIMARY KEY,
reim_Amount decimal(18,2),
reim_Sub Timestamp,
reim_Desc TEXT,
reim_auth int REFERENCES ers_users(ers_user_ID),
reim_res  int REFERENCES ers_users(ers_user_ID),
reim_status_ID int REFERENCES ers_reim_status(reim_status_ID),
reim_type_ID int REFERENCES ers_reim_type(reim_type_ID)
);

INSERT INTO Ers_reim(reim_Amount, reim_Sub, reim_Desc, reim_auth, reim_res, reim_status_id, reim_type_ID)
VALUES (1000.50,now(),'My cat got stuck in the freezer and I used my microwave to thaw him out, now he has developed a taste for expensive tuna. I need more money for my cat.',2,1,2,3);

DROP TABLE Ers_reim;

CREATE TABLE ers_users(
ers_user_ID serial PRIMARY KEY,
ers_username TEXT Unique,
ers_password TEXT,
user_fname TEXT	,
user_lname TEXT	,
user_email TEXT Unique,
user_role_id int REFERENCES ers_users_role(ers_user_role_ID)
);

DROP TABLE ers_users;

CREATE TABLE ers_users_role(
ers_user_role_ID serial PRIMARY KEY,
user_role TEXT 
);

CREATE TABLE ers_reim_type(
reim_type_ID serial PRIMARY KEY,
reim_type TEXT 
);

CREATE TABLE ers_reim_status(
reim_status_ID serial PRIMARY KEY,
reim_status Text
);

INSERT INTO ers_reim_status(reim_status)
Values('Accepted'),('Denied'),('Pending');

SELECT*FROM ers_reim_status;

INSERT INTO ers_reim_type(reim_type)
VALUES ('LODGING'),('TRAVEL'),(' FOOD'),('OTHER');

SELECT*FROM ers_reim_type;

INSERT INTO	ers_users_role(user_role)
VALUES ('Manager'),('Employee');

SELECT*FROM ers_users_role;

INSERT INTO ers_users(ers_username,ers_password,user_fname,user_lname,user_email,user_role_id)
VALUES ('Gemlin','ILikeSableye345','Gemlin','Bobington','Bob@fake.com',1),('BobSimpleton','password','Bob','Bobington','Bobby@fake.com',2);

DROP TABLE ers_users;

SELECT * FROM ers_users;
SELECT*FROM ers_reim;
