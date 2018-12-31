-- this block creates an appuser and a bussiness, then assigns the business to the owner and adds 4 employees
insert into appuser (id, first_name, last_name, password, reset_token, username) values ('9997b365-7f14-4110-b37a-789c3fa99579', 'Rona', 'Arnfield', 'XbTpm973b', '4KhvSr2', 'rarnfield0@jalbum.net');
insert into business(id, about, alt_phone, city, email, name, primary_phone, state, street, zip, owner_id) values('d97e2a1a-59g7-4dc4-a3dd-017b60e263f8', 'about section.', '6615874152', 'Bakersfield', 'company@gmail.com', 'Some Company Inc.', '6615238758', 'CA', '9600 Zeus Dr.', '93308', '9997b365-7f14-4110-b37a-789c3fa99579');

insert into appuser (id, first_name, last_name, password, reset_token, username, employed_by_id) values ('d97e2a1a-56e7-4dc4-a3dd-017b60e2c4ce', 'Amitie', 'Bazeley', '8fOGqTaCY9PI', 'goRQY3E6aMHz', 'abazeley1@mysql.com', 'd97e2a1a-59g7-4dc4-a3dd-017b60e263f8');
insert into appuser (id, first_name, last_name, password, reset_token, username, employed_by_id) values ('ef66796f-8bd6-4676-88cb-c89af79eb5b5', 'Mohandas', 'Ciotti', 'yjxYFPH23X', 'JmaKc0GQIf6', 'mciotti2@edublogs.org', 'd97e2a1a-59g7-4dc4-a3dd-017b60e263f8');
insert into appuser (id, first_name, last_name, password, reset_token, username, employed_by_id) values ('92cf4536-9217-48de-9fbc-d54d4f770d23', 'Frasco', 'Panks', 'sBgAcAG6zS', '3mKKKQVOq', 'fpanks3@nyu.edu', 'd97e2a1a-59g7-4dc4-a3dd-017b60e263f8');
insert into appuser (id, first_name, last_name, password, reset_token, username, employed_by_id) values ('c0db6110-9bed-42e8-b42a-c6f4d81f9479', 'Emmett', 'Kliemke', 'IfUUEloEy', 'saLKVjuc4nPH', 'ekliemke4@dedecms.com', 'd97e2a1a-59g7-4dc4-a3dd-017b60e263f8');

insert into business_employees (business_id, employees_id) values ('d97e2a1a-59g7-4dc4-a3dd-017b60e263f8', 'd97e2a1a-56e7-4dc4-a3dd-017b60e2c4ce');
insert into business_employees (business_id, employees_id) values ('d97e2a1a-59g7-4dc4-a3dd-017b60e263f8', 'ef66796f-8bd6-4676-88cb-c89af79eb5b5');
insert into business_employees (business_id, employees_id) values ('d97e2a1a-59g7-4dc4-a3dd-017b60e263f8', '92cf4536-9217-48de-9fbc-d54d4f770d23');
insert into business_employees (business_id, employees_id) values ('d97e2a1a-59g7-4dc4-a3dd-017b60e263f8', 'c0db6110-9bed-42e8-b42a-c6f4d81f9479');
-- end block