create database AulaJava
go
use AulaJava
go
create table tbcargos
(
	cod_cargo int IDENTITY PRIMARY KEY not null,
	ds_cargo varchar(30),
)
go
create table tbfuncs
(
	cod_func int IDENTITY PRIMARY KEY NOT NULL,
	nome_func varchar(30),
	sal_func money,
	cod_cargo INT,
	CONSTRAINT FK_FUNC FOREIGN KEY(cod_cargo) REFERENCES tbcargos(cod_cargo)
)
go

INSERT INTO tbcargos(ds_cargo) VALUES('Administrador'),
('Presidente'),
('Diretor'),
('Supervisor'),
('Encarregado'),
('Operador')
go

INSERT INTO tbfuncs(nome_func, sal_func, cod_cargo) VALUES('Yago', 3500.00, 1),
('Adalberto', 50000.00, 2),
('Mateus', 25000, 3),
('Dudu', 5500.00, 4),
('Virgulino', 2500.00, 5),
('Esmeralda', 1500.00, 6)
go

use model
drop database aulajava

select * from tbfuncs

