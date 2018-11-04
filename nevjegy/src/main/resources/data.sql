-- INSERT INTO USER --

-- Attributes:
--	ID					- BIGINT
--  VERSION				- BIGINT
--	FULL_NAME 		 	- VARCHAR
--	USER_NAME		  	- VARCHAR
--	PASSWORD 			- VARCHAR (rejtett)
--	ROLE				- VARCHAR
--	EMAIL [kulcs]       - VARCHAR

INSERT INTO USER (ID, VERSION, FULL_NAME, USER_NAME, PASSWORD, ROLE, EMAIL) VALUES (1, 1, 'Super User', 'superuser', '$2a$10$sorhq3rUu30gP.gxIGpvS.V5jeSTe.kZuV0uz7XQoW8d8vanz.lvq','ROLE_SUPERUSER', 'superuser@bcc.com');

INSERT INTO USER (ID, VERSION, FULL_NAME, USER_NAME, PASSWORD, ROLE, EMAIL) VALUES (2, 1, 'Admin1', 'admin1', '$2a$10$sorhq3rUu30gP.gxIGpvS.V5jeSTe.kZuV0uz7XQoW8d8vanz.lvq','ROLE_ADMIN', 'admin1@bcc.com');

INSERT INTO USER (ID, VERSION, FULL_NAME, USER_NAME, PASSWORD, ROLE, EMAIL) VALUES (3, 1, 'Dummy User1', 'usr1', '$2a$10$sorhq3rUu30gP.gxIGpvS.V5jeSTe.kZuV0uz7XQoW8d8vanz.lvq','ROLE_USER', 'usr1@bcc.com');
INSERT INTO USER (ID, VERSION, FULL_NAME, USER_NAME, PASSWORD, ROLE, EMAIL) VALUES (4, 1, 'Dummy User2', 'usr2', '123456','ROLE_USER', 'usr2@bcc.com');
INSERT INTO USER (ID, VERSION, FULL_NAME, USER_NAME, PASSWORD, ROLE, EMAIL) VALUES (5, 1, 'Dummy User3', 'usr3', '123456','ROLE_USER', 'usr3@bcc.com');

------------------------------------------------------

-- INSERT INTO CATEGORY --

-- Attributes:
--	ID					- BIGINT
--  VERSION				- BIGINT
--	NAME				- VARCHAR

INSERT INTO CATEGORY (ID, VERSION, NAME) VALUES (1, 1, 'REPAIRMAN');
INSERT INTO CATEGORY (ID, VERSION, NAME) VALUES (2, 1, 'BAKER');
INSERT INTO CATEGORY (ID, VERSION, NAME) VALUES (3, 1, 'SALES');
INSERT INTO CATEGORY (ID, VERSION, NAME) VALUES (4, 1, 'TEACHER');

------------------------------------------------------

-- INSERT INTO BUSINESS_CARD --

-- Attributes:
--  ID						- BIGINT
--  VERSION					- BIGINT
--  ADDRESS 				- VARCHAR
--  NAME		 			- VARCHAR
--  PHONE	 				- VARCHAR
--  CATEGORY_ID				- BIGINT

INSERT INTO BUSINESS_CARD (ID, VERSION, ADDRESS, NAME, PHONE, CATEGORY_ID, OWNER_ID) VALUES (1, 1, 'New York', 'R-MAN FOR RENT', '+3351231452', 1, 1);
INSERT INTO BUSINESS_CARD (ID, VERSION, ADDRESS, NAME, PHONE, CATEGORY_ID, OWNER_ID) VALUES (2, 1, 'Budapest', 'Mr. Bread', '+3351231453', 2, 1);
INSERT INTO BUSINESS_CARD (ID, VERSION, ADDRESS, NAME, PHONE, CATEGORY_ID, OWNER_ID) VALUES (3, 1, 'Torino', 'Buy a new vacuum', '+3351231455', 3, 1);
INSERT INTO BUSINESS_CARD (ID, VERSION, ADDRESS, NAME, PHONE, CATEGORY_ID, OWNER_ID) VALUES (4, 1, 'London', 'Do you want to be a math genius?', '+3351231458', 4, 1);
INSERT INTO BUSINESS_CARD (ID, VERSION, ADDRESS, NAME, PHONE, CATEGORY_ID, OWNER_ID) VALUES (5, 1, 'Brussels', 'Do you want to be a IT genius?', '+3351231913', 4, 1);


------------------------------------------------------

-- INSERT INTO USER_BUSINESS_CARD --

-- Attributes:
--  USER_ID						- BIGINT
--	BUSINESS_CARDS_ID			- BIGINT

INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (1, 1);
INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (1, 2);
INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (1, 3);
INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (1, 4);

INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (2, 1);
INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (2, 2);
INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (2, 3);

INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (3, 1);
INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (3, 2);

INSERT INTO USER_BUSINESS_CARD(USER_ID, BUSINESS_CARD_ID) VALUES (4, 1);

------------------------------------------------------

-- INSERT INTO FEEDBACK --

-- Attributes:
--  USER_ID						- BIGINT
--  VERSION						- BIGINT
--	RATE_VALUE					- INTEGER
--	TEXT						- VARCHAR(255)
--	BUSINESS_CARD_ID			- BIGINT
--	USER_ID						- BIGINT

INSERT INTO FEEDBACK (ID, VERSION, RATE_VALUE, TEXT, BUSINESS_CARD_ID, USER_ID) VALUES (1,1,3,'He is repaired my washing machine, I can offer it.',2, 1);
INSERT INTO FEEDBACK (ID, VERSION, RATE_VALUE, TEXT, BUSINESS_CARD_ID, USER_ID) VALUES (2,1,3,'Tasty bread. Its okay.',3, 2);
INSERT INTO FEEDBACK (ID, VERSION, RATE_VALUE, TEXT, BUSINESS_CARD_ID, USER_ID) VALUES (3,1,3,'Average math teacher.',4, 3);
INSERT INTO FEEDBACK (ID, VERSION, RATE_VALUE, TEXT, BUSINESS_CARD_ID, USER_ID) VALUES (4,1,1,'It is a worst IT teacher ever...',5, 4);
INSERT INTO FEEDBACK (ID, VERSION, RATE_VALUE, TEXT, BUSINESS_CARD_ID, USER_ID) VALUES (5,1,5,'It is a quite enough good teacher!',5, 5);