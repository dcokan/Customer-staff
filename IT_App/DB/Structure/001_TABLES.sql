
CREATE TABLE PRODUCTS(
	ID NUMBER(5) NOT NULL,
	NAME VARCHAR2(50) NOT NULL, 
	PRICE DECIMAL(7,2) NOT NULL, 
	TYPE VARCHAR2(1) CHECK ( TYPE IN ('A' , 'C', 'H', 'M', 'S', 'F', 'D', 'E' )),
	DELETED VARCHAR2(1) DEFAULT 'N' CHECK (DELETED IN ('N', 'Y')),
	ADULT_ONLY VARCHAR2(1)
	);
	
CREATE TABLE PRODUCTS_ORDERS_MAP(
	PRODUCT_ID NUMBER(5) NOT NULL,
	ORDER_ID NUMBER(5) NOT NULL
);

CREATE TABLE ORDERS(
	ID NUMBER(5) NOT NULL, 
	STATE VARCHAR2(1) CHECK (STATE IN ('I', 'P', 'R', 'S', 'C', 'E')),
	PRICE DECIMAL(7,2),
	TABLE_ID NUMBER(5)
);

CREATE TABLE TABLES(
	ID NUMBER(5) NOT NULL,
	NAME VARCHAR2(15) NOT NULL,
	LIMIT NUMBER(2) NOT NULL,
	RESTAURANT_ID NUMBER(5) NOT NULL,
	RESERVATION_DATE DATE,
	VIP VARCHAR2(1) CHECK (VIP IN ('N', 'Y')),
	DELETED VARCHAR2(1) NOT NULL
);


CREATE TABLE RESOURCES(
	ID NUMBER(5) NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	MEAS_UNIT VARCHAR2(2) CHECK (MEAS_UNIT IN ('ML', 'L', 'G', 'KG', 'PC')),
	AMOUNT DECIMAL(7,2) NOT NULL,
	PRICE DECIMAL(7,2) NOT NULL
);

CREATE TABLE PRODUCT_RESOURCES_MAP(
	ID NUMBER(5) NOT NULL,
	PRODUCT_ID NUMBER(5) NOT NULL,
	RESOURCE_ID NUMBER(5) NOT NULL,
	AMOUNT DECIMAL(7,2) NOT NULL
);

CREATE TABLE PRODUCT_RESTAURANT_MAP(
	PRODUCT_ID NUMBER(5) NOT NULL,
	RESTAURANT_ID NUMBER(5) NOT NULL
);

 CREATE TABLE USERS(
	ID NUMBER(5) NOT NULL,
	LOGIN VARCHAR2(20) NOT NULL,
	FIRSTNAME VARCHAR2(15) NOT NULL,
	LASTNAME VARCHAR2(25) NOT NULL,
	MAIL VARCHAR2(30) NOT NULL,
	TEL VARCHAR2(20) NOT NULL,
	USER_PASS_HASH VARCHAR(100) NOT NULL,
	LAST_LOGIN DATE,
	DELETED VARCHAR2(1) CHECK (DELETED IN ('N', 'Y')),
	EMPL_TYPE VARCHAR2(1) CHECK (EMPL_TYPE IN ('O', 'W', 'B', 'C', 'R')),
	CREATOR_ID NUMBER(5)
 );
 
 CREATE TABLE RESTAURANTS(
 	ID NUMBER(5) NOT NULL,
 	NAME VARCHAR2(40) NOT NULL,
 	STREET VARCHAR2(20) NOT NULL,
 	CITY VARCHAR2(20) NOT NULL,
 	POSTCODE VARCHAR2(20),
 	TEL1 VARCHAR2(20),
 	TEL2 VARCHAR2(20),
 	MAIL VARCHAR2(30),
 	OWNER_ID NUMBER(5) NOT NULL,
 	DELETED VARCHAR2(1) NOT NULL,
 	DESCRIPTION VARCHAR2(100)
 );
 
 CREATE TABLE RESTAURANT_TAGS(
 	RESTAURANT_ID NUMBER(5) NOT NULL,
 	TAG_VALUE VARCHAR2(15) NOT NULL
 );
 
 -- Primary keys
ALTER TABLE PRODUCT_RESOURCES_MAP ADD (CONSTRAINT PRODUCT_RESOURCES_MAP_PK PRIMARY KEY(ID));
ALTER TABLE PRODUCTS ADD (CONSTRAINT PRODUCT_PK PRIMARY KEY(ID)); 
ALTER TABLE ORDERS ADD (CONSTRAINT ORDER_PK PRIMARY KEY(ID)); 
ALTER TABLE TABLES ADD (CONSTRAINT TABLE_PK PRIMARY KEY(ID)); 
ALTER TABLE RESOURCES ADD (CONSTRAINT RESOURCE_PK PRIMARY KEY(ID)); 
ALTER TABLE USERS ADD (CONSTRAINT USER_PK PRIMARY KEY(ID)); 
ALTER TABLE RESTAURANTS ADD (CONSTRAINT RESTAURANT_PK PRIMARY KEY(ID)); 

 -- Foreign keys

ALTER TABLE PRODUCTS_ORDERS_MAP ADD CONSTRAINT PRODUCT_ORDER_FK FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(ID);
ALTER TABLE PRODUCTS_ORDERS_MAP ADD CONSTRAINT ORDER_FK FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ID);
ALTER TABLE ORDERS ADD CONSTRAINT TABLE_FK FOREIGN KEY (TABLE_ID) REFERENCES TABLES(ID);
ALTER TABLE TABLES ADD CONSTRAINT RESTAURANT_FK FOREIGN KEY (RESTAURANT_ID) REFERENCES RESTAURANTS(ID);
ALTER TABLE PRODUCT_RESOURCES_MAP ADD CONSTRAINT PRODUCT_RES_FK FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(ID);
ALTER TABLE PRODUCT_RESOURCES_MAP ADD CONSTRAINT RESOURCE_FK FOREIGN KEY (RESOURCE_ID) REFERENCES RESOURCES(ID);
ALTER TABLE PRODUCT_RESTAURANT_MAP ADD CONSTRAINT PROD_RESTAURANT_FK FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(ID);
ALTER TABLE PRODUCT_RESTAURANT_MAP ADD CONSTRAINT REST_PRODUCT_FK FOREIGN KEY (RESTAURANT_ID) REFERENCES RESTAURANTS(ID);
ALTER TABLE USERS ADD CONSTRAINT CREATOR_PERSON_FK FOREIGN KEY (CREATOR_ID) REFERENCES USERS(ID);
ALTER TABLE RESTAURANTS ADD CONSTRAINT OWNER_REST_FK FOREIGN KEY (OWNER_ID) REFERENCES USERS(ID);
ALTER TABLE RESTAURANT_TAGS ADD CONSTRAINT TAG_RESTAURANT_FK FOREIGN KEY (RESTAURANT_ID) REFERENCES RESTAURANTS(ID);

--Sequences
CREATE SEQUENCE SEQ_USERS START WITH 1;