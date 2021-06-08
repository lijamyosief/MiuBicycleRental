INSERT INTO addresses (address_id, city, country, state, street, zip_code) VALUES (1, 'Philadelphia', 'USA', 'PA', '7518 blueRd', 19151);

INSERT INTO addresses (address_id, city, country, state, street, zip_code) VALUES (2, 'fairfield', 'USA', 'IA', '2000 N court', 52556);
-- INSERT INTO  payments (payment_id, card_cvv, card_number, payment_date, payment_type, total_price, address_id) VALUES (1, 698, 3434545445, '2020-04-03', 'credit card', 40.0, 1);

INSERT INTO  catagories(category_id,  vehicle_type, rate_per_day) VALUES (1,  'MOUNTAIN1', 5.00);
INSERT INTO  catagories (category_id, vehicle_type, rate_per_day) VALUES (2,  'MOUNTAIN2', 3.00);
INSERT INTO  catagories(category_id, vehicle_type, rate_per_day) VALUES (3,  'MOUNTAIN3', 4.00);
-- INSERT INTO  catagories (category_id,  vehicle_type, rate_per_day) VALUES (4,  'MOUNTAIN4', 3.0);
-- INSERT INTO  catagories(category_id,  vehicle_type, rate_per_day) VALUES (5,  'MOUNTAIN5', 6.0);
-- INSERT INTO  catagories (category_id,  vehicle_type, rate_per_day) VALUES (6,  'MOUNTAIN6', 2.0);



INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (1, 'Conago', 'Conago', '53654', 'VHL1', 2009,1);
INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (2, 'Pinarello', 'Pinarello', '89731', 'VHL2', 2011,2);
INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (3, 'Ventiseyi', 'Ventiseyi', '89733', 'VHL3', 2021,3);
-- -- INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (4, 'Marchedis', 'Marchedis', '89765', 'VHL4', 2019,4);
-- INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (5, 'Korea', 'Korea', '86565', 'VHL4', 2013,5);
-- INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (6, 'BMX', 'RBMX', '897978978', 'VHL6', 2014,6);
-- INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (7, 'Avanti', 'Avanti', '1254545', 'VHL7', 2011,2);
-- INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (8, 'Trek', 'Trek', '89735', 'VHL8', 2016,1);
-- INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (9, 'Super', 'Super', '89735', 'VHL9', 2014,3);
-- INSERT INTO  vehicles (vehicle_id, make, model, plate_number, vehicle_number, year,category_id) VALUES (10, 'Jegante', 'Jegante', '89735', 'VHL10', 2018,6);

INSERT INTO  credentials (credential_id, password, user_name) VALUES (10, '$2y$10$.MU0VSB8Z.Qmgg2bz6pZLO4cwjAF/iKTH7QjWEaayV0YztsRYgcha', 'admin');
INSERT INTO  credentials (credential_id, password, user_name) VALUES (20, '$2y$10$.MU0VSB8Z.Qmgg2bz6pZLO4cwjAF/iKTH7QjWEaayV0YztsRYgcha', 'staff');
INSERT INTO  credentials (credential_id, password, user_name) VALUES (30, '$2y$10$.MU0VSB8Z.Qmgg2bz6pZLO4cwjAF/iKTH7QjWEaayV0YztsRYgcha', 'customer');


INSERT INTO  users (user_id, date_of_birth, first_name, last_name, license_number, middle_name, credential_id) VALUES (10, '1994-09-09', 'Essey', 'Tezare', '98765432', 'Abraham',10);
INSERT INTO  users (user_id, date_of_birth, first_name, last_name, license_number, middle_name, credential_id) VALUES (20, '1993-09-09', 'Dawit', 'Hailu', '98756765', 'Tesfahannes',20);
INSERT INTO  users (user_id, date_of_birth, first_name, last_name, license_number, middle_name, credential_id) VALUES (30, '1993-01-09', 'Biniam', 'Arefaine', '98765376', 'Tsehaye',30);

-- INSERT INTO  bookings (booking_id, booking_date, date_of_birth, email, end_date, first_name, last_name, license_number, reference_number, start_date, total_price, payment_id, user_id, vehicle_id) VALUES ('1', '2009-09-09', '1993-09-11', 'binireyes@gmail.com', '2009-09-12', 'Biniam', 'Arefaine', '123456789', '100', '2009-09-09', '320.00', '1', '1', '1');

INSERT INTO role(role_id, role_name) VALUES (10, 'ROLE_ADMIN');
INSERT INTO role(role_id, role_name) VALUES (20, 'ROLE_STAFF');
INSERT INTO role(role_id, role_name) VALUES (30, 'ROLE_CUSTOMER');

INSERT INTO user_roles (user_id, role_id) VALUES (10, 10);
INSERT INTO user_roles (user_id, role_id) VALUES (20, 20);
INSERT INTO user_roles (user_id, role_id) VALUES (30, 30);

