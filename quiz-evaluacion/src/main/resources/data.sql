insert into USER (ADMIN, USERNAME, NAME, PASSWORD,LOCKED) values (true,'admin','Admin','A+98FnMIylJGjl2jhHcUYQ==',false);
insert into USER (ADMIN, USERNAME, NAME, PASSWORD,LOCKED) values (false,'user','User','A+98FnMIylJGjl2jhHcUYQ==',false);

insert into category(name) values ('POLITICS');
insert into category(name) values ('GAMING');
insert into category(name) values ('COMPUTER');
insert into category(name) values ('NATURE');
insert into category(name) values ('ANIMALS');
insert into category(name) values ('BIRDS');
insert into category(name) values ('CARS');
insert into category(name) values ('BIKES');
insert into category(name) values ('SCIENCE');
insert into category(name) values ('PHYSICS');

insert into question(category_id,options,text) values (2,'{"1":{"text":"CS","correct":false},"2":{"text":"DOTA","correct":true},"3":{"text":"Call Of Duty","correct":false},"4":{"text":"NFS","correct":false}}','Game with highest prize money pool ?');
insert into question(category_id,options,text) values (2,'{"1":{"text":"NFS","correct":true},"2":{"text":"CS","correct":false},"3":{"text":"LOL","correct":false},"4":{"text":"DOTA","correct":false}}','Which among the following is not a multiplayer team game ?');
insert into question(category_id,options,text) values (2,'{"1":{"text":"Leage of Legends","correct":false},"2":{"text":"Candy Crush","correct":true},"3":{"text":"Call of Duty: Modern Warfare","correct":false},"4":{"text":"Hitman - 4","correct":false}}','Which of the following is a mobile based game ?');

insert into question(category_id,options,text) values (1,'{"1":{"text":"Dr. Abdul Kalam","correct":false},"2":{"text":"Dr. Pratibha Patil","correct":false},"3":{"text":"Dr. Rajendra Lad","correct":false},"4":{"text":"Dr. Rajendra Prasad","correct":true}}','Who was first president of India ?');
insert into question(category_id,options,text) values (1,'{"1":{"text":"Narendra Modi","correct":true},"2":{"text":"Rahul Gandhi","correct":false},"3":{"text":"Arwind Kejriwal","correct":false},"4":{"text":"Udhav Thackrey","correct":false}}','Who is current prime minister of India?');
