INSERT INTO  tb_cliente (nome, endereco)
VALUE 
("Gabriel Nogueira","Rua Theodorico Moreira de Souza"),
("Caique Matheus","Rua dos Bobos num 101");

SELECT * FROM tb_cliente;

drop database cliente;

INSERT INTO cliente 
value (1, "Gabriel Nogueira da Silva","Rua theodorico Moreira de Souza"),
(2,"Luan Nascimento","Riberao pires"),
(3,"Giovanna Motta","ABC do judas"),
(4,"Caique santos","Rua Vitoria ou rebeca");

ALTER TABLE cliente ADD data_nascimento DATE NOT NULL;
INSERT INTO cliente VALUE (5,"Igao do lol", "Summoner Rift", "15/10/2001");

ALTER TABLE cliente DROP data_nascimento;
SELECT * FROM cliente;

UPDATE cliente SET data_nascimento = "1995-10-10" WHERE idcliente 4;

DESC cliente;
ALTER TABLE cliente drop idcliente;

ALTER TABLE cliente ADD id_cliente INTEGER primary KEY NOT NULL;

DROP TABLE cliente;

CREATE TABLE CLIENTE (
id_cliente integer auto_increment not null,
nome varchar(255) not null,
endereco varchar(255) not null,
data_nascimento date not null,
primary key (id_cliente)
);

insert into cliente (nome, endereco, data_nascimento) values ("Vaisimporra", "Funcionar mermo", 9999-22-11);
select * from cliente;

update cliente set data_nascimento = "2001-01-05" where data_nascimento is null;
set 


