INSERT INTO empresa (nome, endereco_sede, url_imagem) VALUES
('Nintendo', 'Quioto, Japão', 'https://cdn-icons-png.flaticon.com/512/871/871380.png'),
('Microsoft', 'Redmond, Estados Unidos', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpdlZ1xNCeBi94HdWrAlTWcV1ampL9lFG4tQ&usqp=CAU'),
('Sony', 'Tóquio, Japão', 'https://logospng.org/download/sony/logo-sony-512.png'),
('Valve', 'Bellevue, Estados Unidos', 'https://logowik.com/content/uploads/images/valve3396.jpg'),
('Ubisoft', 'Paris, França', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShbyzLRn7unx-ugQl1Jf87HukD_IFTSY33_w&usqp=CAU');

INSERT INTO jogo (nome, data_lancamento, custo, faturamento, empresa_id, downloads, url_imagem) VALUES
('The Legend of Zelda: Breath of the Wild', NOW(), 45000000, 2400000000, 1, 400000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9DpFNv1Zw3ygPEMOeZJ7fs_knRhH0R3vDSQ&usqp=CAU'),
('Halo Infinite', NOW(), 50000000, 400000000, 2, 2530000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSx8s1PaPviJ52Lz_NV2rwbA4ENNMKYVW1yEg&usqp=CAU'),
('Horizon Zero Dawn', NOW(), 45000000, 700000000, 3, 2000000, 'https://cdn.akamai.steamstatic.com/steam/apps/1151640/capsule_616x353.jpg?t=1667297464'),
('Half-Life 2', NOW(), 40000000, 700000000, 4, 976000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0Z9hMY4qyDwchUVVxz9fmlN21AMpQAsS4mQ&usqp=CAU'),
('Assassins Creed Valhalla', NOW(), 80000000, 1250000000, 5, 456000, 'https://m.media-amazon.com/images/I/91lmTAVXgHL.jpg');