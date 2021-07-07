insert into tb_user(login, password, created_at) values ('luffy@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2021-07-03T20:30:00.12345Z');
insert into tb_user(login, password, created_at) values ('nami@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2021-07-03T20:30:00.12345Z');
insert into tb_user(login, password, created_at) values ('zoro@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2021-07-03T20:30:00.12345Z');
insert into tb_user(login, password, created_at) values ('chopper@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2021-07-03T20:30:00.12345Z');

insert into tb_category(name, mother_category_id) values('Games', null);
insert into tb_category(name, mother_category_id) values('Consoles', 1);
insert into tb_category(name, mother_category_id) values('Jogos', 2);

insert into tb_product(name, value, available_quantity, description, created_at, category_id, owner_id) values ('Xbox Series X', 4500, 12, 'Descrição do console', TIMESTAMP WITH TIME ZONE '2021-07-06 23:02:16.091822', 2, 1);

insert into tb_characteristics(id, name, description, product_id) values(1, 'Marca', 'Microsoft', 1);
insert into tb_characteristics(id, name, description, product_id) values(2, 'Modelo', 'Xbox Series X', 1);
insert into tb_characteristics(id, name, description, product_id) values(3, 'Ano', '2020', 1);

insert into tb_image (id, url, product_id) values (1, 'https://ondeseraarmazenada.io/nomedaimagem1.png', 1);
insert into tb_image (id, url, product_id) values (2, 'https://ondeseraarmazenada.io/nomedaimagem2.png', 1);
insert into tb_image (id, url, product_id) values (3, 'https://ondeseraarmazenada.io/nomedaimagem3.png', 1);