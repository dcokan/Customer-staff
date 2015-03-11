


/*Klucz glowny dla tabeli*/
ALTER TABLE PRODUKTY ADD (CONSTRAINT PRODUKTY_PK PRIMARY KEY(ID_PRODUKTU)); 

/*Automatycznie inkrementowany indeks*/
CREATE SEQUENCE produkty_seq;

CREATE OR REPLACE TRIGGER produkty_bir 
BEFORE INSERT ON produkty 
FOR EACH ROW
BEGIN
  SELECT produkty_seq.NEXTVAL
  INTO   :new.id_produktu
  FROM   dual;
END;

/*testowe dane */
insert into produkty (OPIS, CENA, TYP) values ('ABC',1.1,'b');
insert into produkty (OPIS, CENA, TYP) values ('EFG',22.12,'c');

/*****************************************************************************/


/*Klucz glowny dla tabeli ZAMOWIENIA*/
ALTER TABLE ZAMOWIENIA ADD (CONSTRAINT ZAMOWIENIA_PK PRIMARY KEY(ID_ZAMOWIENIA)); 

/*Autoinkrementacja id Zamowienia*/  
CREATE SEQUENCE zamowienia_seq;

CREATE OR REPLACE TRIGGER zamowienia_bir 
BEFORE INSERT ON zamowienia 
FOR EACH ROW
BEGIN
  SELECT zamowienia_seq.NEXTVAL
  INTO   :new.ID_ZAMOWIENIA
  FROM   dual;
END; 


/*testowe dane */
insert into zamowienia (STAN, CENA) values ('do realizacji',111.22);
insert into zamowienia (STAN, CENA) values ('zakonczone',2212.22);

/*****************************************************************************/

/*TABELA MAPUJACA PRODUKT Z ZAMOWIENIEM*/


/*Klucz glowny*/
ALTER TABLE zamowienia_produkty_map ADD (CONSTRAINT zamowienia_produkty_map_PK PRIMARY KEY(ID_ZAMOWIENIE_PRODUKT)); 

/*Klucz obcy dla tabeli PRODUKTY*/
ALTER TABLE zamowienia_produkty_map
ADD CONSTRAINT PRODUKTY_FK
  FOREIGN KEY (ID_PRODUKTU)
  REFERENCES produkty(ID_PRODUKTU);
  
  /*Klucz obcy dla tabeli ZAMOWIENIA*/
ALTER TABLE zamowienia_produkty_map
ADD CONSTRAINT ZAMOWIENIA_FK
  FOREIGN KEY (ID_ZAMOWIENIA)
  REFERENCES zamowienia(ID_zamowienia);
  
  /*Autoinkrementacja id Zamowienia_produkty*/  
CREATE SEQUENCE zamowienia_produkty_map_seq;

CREATE OR REPLACE TRIGGER zamowienia_produkty_map_bir 
BEFORE INSERT ON zamowienia_produkty_map 
FOR EACH ROW
BEGIN
  SELECT zamowienia_produkty_map_seq.NEXTVAL
  INTO   :new.ID_ZAMOWIENIe_PRODUKT
  FROM   dual;
END; 

/*testowe dane */
insert into zamowienia_produkty_map (ID_PRODUKTU, ID_ZAMOWIENIA) values (1,2);
insert into zamowienia_produkty_map (ID_PRODUKTU, ID_ZAMOWIENIA) values (1,1);
insert into zamowienia_produkty_map (ID_PRODUKTU, ID_ZAMOWIENIA) values (2,2);

/*****************************************************************************/

/*TABELA SKLADNIKI*/

/*Klucz glowny*/
ALTER TABLE SKLADNIKI ADD (CONSTRAINT SKLADNIKI_PK PRIMARY KEY(ID_SKLADNIKA)); 

/*Klucz obcy dla tabeli PRODUKTY*/
ALTER TABLE SKLADNIKI
ADD CONSTRAINT PRODUKT_FK
  FOREIGN KEY (ID_PRODUKTU)
  REFERENCES produkty(ID_PRODUKTU);
  
/*Klucz obcy dla tabeli ZASOBY*/
ALTER TABLE SKLADNIKI
ADD CONSTRAINT ZASOBY_FK
  FOREIGN KEY (ID_ZASOBU)
  REFERENCES zasoby(ID_ZASOBU);
  
/*Autoinkrementacja id skladnika*/  
CREATE SEQUENCE skladniki_seq;

CREATE OR REPLACE TRIGGER WYLICZ_CENE_TRIG
AFTER INSERT OR DELETE OR UPDATE ON SKLADNIKI
FOR EACH ROW
BEGIN
WYLICZ_CENE(:new.ID_produktu);
END;

CREATE OR REPLACE TRIGGER skladniki_bir 
BEFORE INSERT ON SKLADNIKI 
FOR EACH ROW
BEGIN
  SELECT skladniki_seq.NEXTVAL
  INTO   :new.ID_SKLADNIKA
  FROM   dual;
END; 

/*testowe dane */
insert into SKLADNIKI (ID_PRODUKTU, ID_ZASOBU, ILOSC) values (23,21,0.2);
insert into SKLADNIKI (ID_PRODUKTU, ID_ZASOBU, ILOSC) values (23,22,0.4);

/*****************************************************************************/

/*TABELA ZASOBY*/

/*Klucz glówny*/
ALTER TABLE ZASOBY ADD (CONSTRAINT ZASOBY_PK PRIMARY KEY(ID_ZASOBU)); 

 /*Autoinkrementacja id zasobu*/  
CREATE SEQUENCE ZASOBY_seq;


create or replace procedure INSERT_RESOURCE_GETID(
 v_name in ZASOBY.NAZWA%TYPE,
 v_meas in ZASOBY.MIARA%TYPE,
 v_count in ZASOBY.ILOSC%TYPE,
 v_price in ZASOBY.CENA%TYPE,
 v_new_id out ZASOBY.ID_ZASOBU%TYPE)
as
begin
  insert into zasoby(NAZWA, MIARA, ILOSC, CENA)
  values(v_name, v_meas, v_count, v_price)
  returning ID_ZASOBU into v_new_id;
end;

CREATE OR REPLACE TRIGGER ZASOBY_bir 
BEFORE INSERT ON ZASOBY 
FOR EACH ROW
BEGIN
  SELECT ZASOBY_seq.NEXTVAL
  INTO   :new.ID_ZASOBU
  FROM   dual;
END; 

/*testowe dane*/
insert into ZASOBY (NAZWA, MIARA, ILOSC, CENA) values ('Martini', 'l.', 111, 8);
insert into ZASOBY (NAZWA, MIARA, ILOSC, CENA) values ('Mleko', 'l.', 34, 4);

/*************************************************************************************/
/*TABELA RAPORTY*/


/*Klucz glowny dla tabeli ZAMOWIENIA*/
ALTER TABLE RAPORTY ADD (CONSTRAINT RAPORTY_PK PRIMARY KEY(ID_RAPORTU)); 

/*Klucz obcy do produktu*/
ALTER TABLE RAPORTY
ADD CONSTRAINT PRODUKT_RAPORTY_FK
  FOREIGN KEY (ID_PRODUKTU)
  REFERENCES produkty(ID_PRODUKTU);

/*Autoinkrementacja id Zamowienia*/  
CREATE SEQUENCE raporty_seq;

CREATE OR REPLACE TRIGGER raporty_bir 
BEFORE INSERT ON raporty 
FOR EACH ROW
BEGIN
  SELECT raporty_seq.NEXTVAL
  INTO   :new.ID_RAPORTU
  FROM   dual;
END; 

/*testowe dane */
insert into raporty (ID_PRODUKTU, DATA_ZAMOWIENIA, CENA, ILOSC) values (1, TO_DATE('2003/05/03', 'yyyy/mm/dd'),111.22, 3);

/*********************************************************************************************/
/* To dodał Szanowny Pan Cokan !
 * Metoda dodaje nowe zamowienie i zwraca id nowego zamowienia
 * Jak sie dobrze w javeie wywola to nawet dziala ! :O
 */
create or replace procedure insert_Order_GetId(
    v_order_state in ZAMOWIENIA.STAN%TYPE,
    v_cena in ZAMOWIENIA.CENA%TYPE,
    v_new_id out ZAMOWIENIA.ID_ZAMOWIENIA%TYPE)
as
begin
    insert into ZAMOWIENIA(STAN, CENA)
    values(v_order_state, v_cena)
    returning ID_ZAMOWIENIA into v_new_id;
end;

/*Procedure wyliczajaca cene produktu na podstawie tabeli SKLADNIKI i ZASOBY*/
CREATE OR REPLACE PROCEDURE WYLICZ_CENE 
(
  PRODID IN NUMBER,
  NEW_PRICE OUT PRODUKTY.CENA%TYPE
) AS
cena_produktu NUMBER(7,2);
cena_zasobu NUMBER(7,2);
BEGIN
   cena_produktu := 0;
   FOR r IN (SELECT ID_ZASOBU, ILOSC FROM SKLADNIKI WHERE ID_PRODUKTU = prodID) LOOP
     select cena into cena_zasobu from ZASOBY where ID_ZASOBU = r.ID_ZASOBU;
     cena_produktu := cena_produktu + cena_zasobu * r.ILOSC;
   END LOOP;
   UPDATE PRODUKTY SET CENA = cena_produktu WHERE ID_PRODUKTU = prodID
  returning cena_produktu into NEW_PRICE;
END WYLICZ_CENE;



/* To dodał Szanowny Pan Cokan !
 * Metoda dodaje nowy produkt i zwraca id nowego produktu
 * 
 * ATTENTION !!
 * 
 * DODANE W PRACY NIE WIADOMO CZY DZIAŁA !!!
 * 
 */
create or replace procedure insert_product_GetId(
    v_descr in PRODUKTY.OPIS%TYPE,
    v_cena in PRODUKTY.CENA%TYPE,
    v_typ in PRODUKTY.TYP%TYPE,
    v_usuniety in PRODUKTY.CZY_USUNIETY%TYPE,
    v_cena_zm in PRODUKTY.CZY_CENA_ZMIENIONA%TYPE,
    v_new_id out PRODUKTY.ID_PRODUKTU%TYPE)
as
begin
    insert into PRODUKTY(OPIS, CENA, TYP, CZY_USUNIETY, CZY_CENA_ZMIENIONA)
    values(v_descr, v_cena, v_typ, v_usuniety, v_cena_zm)
    returning ID_PRODUKTU into v_new_id;
end; 

create or replace trigger ZMNIEJSZ_ILOSC_ZASOBOW
after insert on zamowienia_produkty_map
for each row
begin
  for s in (select ID_ZASOBU, ILOSC from SKLADNIKI where ID_PRODUKTU = :new.ID_PRODUKTU) LOOP
    UPDATE ZASOBY SET ILOSC = (ILOSC - s.ILOSC) WHERE ID_ZASOBU = s.ID_ZASOBU;
  END LOOP;
END;
      
/*Trigger wyzwalajacy sie, gdy cena zasobu sie zmieni*/
CREATE OR REPLACE TRIGGER ZMIEN_CENE_PRODUKTU 
AFTER UPDATE OF CENA ON ZASOBY 
FOR EACH ROW
DECLARE
  stara_cena_skladnika NUMBER(7,2);
  nowa_cena_skladnika NUMBER(7,2);
  cena_zmieniona VARCHAR2(1);
BEGIN
  FOR r IN (SELECT ID_PRODUKTU, ILOSC FROM SKLADNIKI WHERE ID_ZASOBU = :old.ID_ZASOBU) LOOP
    SELECT czy_cena_zmieniona into cena_zmieniona from produkty where ID_PRODUKTU = r.ID_PRODUKTU;
    IF (cena_zmieniona = 'N') THEN 
    stara_cena_skladnika := :old.CENA * r.ILOSC;
    nowa_cena_skladnika := :new.CENA * r.ILOSC;
    UPDATE PRODUKTY SET CENA = (CENA - stara_cena_skladnika + nowa_cena_skladnika) where ID_PRODUKTU = r.ID_PRODUKTU; 
    END IF;
  END LOOP;
END;

/*********************************************************************************************/
/*Procedura uswajaca produkt i zwiazane z nim skladniki*/
/*CREATE OR REPLACE PROCEDURE USUN_PRODUKT
(
  nazwa_produktu IN VARCHAR2 
) AS
prodID NUMBER(3);
BEGIN
   select id_produktu into prodID from PRODUKTY where OPIS = nazwa_produktu;
   UPDATE PRODUKTY SET CZY_USUNIETY = 'Y' where OPIS = nazwa_produktu;
   DELETE FROM SKLADNIKI where ID_PRODUKTU = prodID; 
END USUN_PRODUKT;*/

select * from produkty;
select * from skladniki;
select * from zasoby;
select * from zamowienia;
select * from zamowienia where stan != 'zakonczone';
UPDATE PRODUKTY SET CZY_USUNIETY = 'N' where OPIS = 'ABC';
UPDATE ZAMOWIENIA SET STAN = 'do realizacji' where stan = 'zakonczone';
select * from zamowienia_produkty_map;
Begin
usun_produkt('ABC');
end;
CALL usun_produkt('EFG');
CALL wylicz_cene(23);
delete from skladniki where id_skladnika = 21;
select id_produktu, opis, cena, typ, czy_cena_zmieniona, czy_usuniety from produkty JOIN zamowienia_produkty_map zp using(id_produktu) where zp.id_zamowienia = 1;