insert into tb_user(login, password, created_at) values ('luffy@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2021-07-03T20:30:00.12345Z');
insert into tb_user(login, password, created_at) values ('nami@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2021-07-03T20:30:00.12345Z');
insert into tb_user(login, password, created_at) values ('zoro@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2021-07-03T20:30:00.12345Z');
insert into tb_user(login, password, created_at) values ('chopper@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2021-07-03T20:30:00.12345Z');

insert into tb_category(name, mother_category_id) values('Games', null);
insert into tb_category(name, mother_category_id) values('Consoles', 1);
insert into tb_category(name, mother_category_id) values('Jogos', 2);