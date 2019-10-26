INSERT INTO units(name) VALUES ('gram');
INSERT INTO units(name) VALUES ('kilogram');
INSERT INTO units(name) VALUES ('tona');
INSERT INTO units(name) VALUES ('komad');
INSERT INTO units(name) VALUES ('litar');
INSERT INTO units(name) VALUES ('metar');

INSERT INTO place(name) VALUES ('Kragujevac');
INSERT INTO place(name) VALUES ('Novi Sad');
INSERT INTO place(name) VALUES ('Loznica');
INSERT INTO place(name) VALUES ('Beograd');
INSERT INTO place(name) VALUES ('Subotica');

INSERT INTO company(pib, address, name, place_id) values ('12345235', 'Macvanska 31', 'Kragujevac DOO', 1);
INSERT INTO company(pib, address, name, place_id) values ('543215786', 'Futoska 12', 'Google', 2);
INSERT INTO company(pib, address, name, place_id) values ('543215783', 'Ive Andrica 27', 'Facebook', 3);
INSERT INTO company(pib, address, name, place_id) values ('543215782', 'Ivana Sarica 35', 'Comtrade', 4);
INSERT INTO company(pib, address, name, place_id) values ('543215781', 'Jevrejska 76', 'FTN', 5);
INSERT INTO company(pib, address, name, place_id) values ('85479658', 'Radnicka 28', 'Continental', 3);

INSERT INTO product_group(name, group_product_company) VALUES ('procesori', 1);
INSERT INTO product_group(name, group_product_company) VALUES ('memorije', 1);
INSERT INTO product_group(name, group_product_company) VALUES ('hrana', 1);
INSERT INTO product_group(name, group_product_company) VALUES ('telefoni', 1);
INSERT INTO product_group(name, group_product_company) VALUES ('alat', 1);
INSERT INTO product_group(name, group_product_company) VALUES ('jakne', 1);

INSERT INTO product(name, product_group_id, unit_id) VALUES ('Intel i9-9900X', 1, 4);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Dell 22" LED FullHD Monitor', 3, 4);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Samsung 16GB DDR4', 2, 4);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Brasno', 4, 2);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Mleko', 4, 5);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Kakao', 4, 2);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('LG G5', 5, 4);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Iphone X', 5, 4);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Samsung galaxy s10', 5, 4);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Lenjir', 6, 6);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Crevo za vodu', 6, 6);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Ethernet kabl', 6, 6);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Samsung 16GB DDR4', 2, 4);
INSERT INTO product(name, product_group_id, unit_id) VALUES ('Lenovo 32GB DDR4', 1, 4);


INSERT INTO business_year(year, close, company_id) VALUES (2015, true, 1);
INSERT INTO business_year(year, close, company_id) VALUES (2016, true, 2);
INSERT INTO business_year(year, close, company_id) VALUES (2017, true, 1);
INSERT INTO business_year(year, close, company_id) VALUES (2018, false, 1);
INSERT INTO business_year(year, close, company_id) VALUES (2019, false, 3);

INSERT INTO warehouse(name, company_id) VALUES ('Magacin 1', 2);
INSERT INTO warehouse(name, company_id) VALUES ('Magacin 2', 2);
INSERT INTO warehouse(name, company_id) VALUES ('Magacin 3', 1);
INSERT INTO warehouse(name, company_id) VALUES ('Magacin 4', 5);

INSERT INTO product_card(price, init_state_of_quantity, init_state_of_value, traffic_exit_quantity, traffic_exit_value, traffic_entry_quantity, traffic_entry_value, total_amount, total_value, year_id, warehouse_id, product_id) VALUES (134990,1,134990, 0,0,0,0,1,134990,2,1,1);
INSERT INTO product_card(price, init_state_of_quantity, init_state_of_value, traffic_exit_quantity, traffic_exit_value, traffic_entry_quantity, traffic_entry_value, total_amount, total_value, year_id, warehouse_id, product_id) VALUES (150000,2,150000, 0,0,0,0,2,150000,3,2,2);
INSERT INTO product_card(price, init_state_of_quantity, init_state_of_value, traffic_exit_quantity, traffic_exit_value, traffic_entry_quantity, traffic_entry_value, total_amount, total_value, year_id, warehouse_id, product_id) VALUES (100,3,8000, 0,0,0,0,3,8000,5,3,3);
INSERT INTO product_card(price, init_state_of_quantity, init_state_of_value, traffic_exit_quantity, traffic_exit_value, traffic_entry_quantity, traffic_entry_value, total_amount, total_value, year_id, warehouse_id, product_id) VALUES (50,5,100, 0,0,0,0,5,100, 1,4,4);
INSERT INTO product_card(price, init_state_of_quantity, init_state_of_value, traffic_exit_quantity, traffic_exit_value, traffic_entry_quantity, traffic_entry_value, total_amount, total_value, year_id, warehouse_id, product_id) VALUES (80,10,35, 0,0,0,0,10,35, 2,2,5);


INSERT INTO partner(name, pib, address, company_id, place_id) VALUES ('Instagram', '123456789124', 'Tolstojeva 89', 1, 2);
INSERT INTO partner(name, pib, address, company_id, place_id) VALUES ('Samsung', '987654321547', 'Bulevar Oslobodjenja 56', 2, 3);
INSERT INTO partner(name, pib, address, company_id, place_id) VALUES ('Amazon', '852369014892', 'Sutjeska 8', 3, 1);

INSERT INTO traffic_document(type_of_document, number, format_date, datum_knjizenja, status, bussiness_partner_id, year_id, warehouse_id) VALUES ('Primka', 100, '2018-05-08', '2018-05-09', 'Format', 1, 1, 1);
INSERT INTO traffic_document(type_of_document, number, format_date, datum_knjizenja, status, bussiness_partner_id, year_id, warehouse_id) VALUES ('Primka', 150, '2019-01-02', '2019-01-03', 'Format', 2,2,2);

INSERT INTO document_item(quantity, price, value, document_id, product_id) VALUES (850, 150, 10, 1,1);
INSERT INTO document_item(quantity, price, value, document_id, product_id) VALUES (100, 50, 150, 2,2);
INSERT INTO document_item(quantity, price, value, document_id, product_id) VALUES (20, 10, 100, 1,2);

INSERT INTO analytics(price, quantity, serial_number, smer, value, vrsta_prometa, product_card_id, document_item_id) VALUES (1400, 2, 1, 'U', 120, 'PR', 1, 1 )

INSERT INTO user(name, username, password, role) VALUES ('pera', 'a', '$2a$10$uAJxjAToe7LUtqZMEXrZsOB5bgjisBcMBztDSaQ1kzj/A2xnpg41y', 0);
INSERT INTO user(name, username, password, role) VALUES ('mika', 'b', '$2a$10$uAJxjAToe7LUtqZMEXrZsOB5bgjisBcMBztDSaQ1kzj/A2xnpg41y', 1);

INSERT INTO shopping_cart(id) VALUES (1);

INSERT INTO shopping_cart_item(product_id, shopping_cart_id, user_id, quantity) VALUES (1,1,1,10);