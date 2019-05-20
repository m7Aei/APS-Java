-- Usar a database da APS
use dados_aps;

-- Criando a tabela que contém as informações dos usuários 
create table if not exists `cadastro` (
	`id_cadastro` integer primary key auto_increment,
	`nome` varchar(255) not null,
	`email` varchar(350) not null,
	`endereco` varchar(350) not null,
	`cpf` varchar(12) not null,
	`senha` varchar(20) not null
) Engine = innodb;

-- Criando a tabela que tem as informações dos carros
create table if not exists `informacoes_carro` (
	`ID_Carro` integer primary key auto_increment,
	`modelo` varchar(15) not null,
	`dono` varchar(255) not null,
	`cor` varchar(15) not null,
	`anoDoCarro` smallint not null,
	`placa` varchar(6) not null,
	`ID_Imagem` integer,
	`ID_Multa` integer
) Engine = innodb;

-- Criando a tabela de imagens 
create table if not exists `tabela_imagens` (
	`codigoImg` integer primary key auto_increment,
	`imagem` longblob not null,
	`ID_Carro`integer,
	`ID_Multa` integer 
) Engine = innodb;

-- Criando a tabela de multas 
create table if not exists `multas` (
	`ID_Multa` integer primary key auto_increment,
	`valorMulta` float not null,
	`nome` varchar(255) not null,
	`cpf` varchar(12) not null,
	`tipoMulta` varchar(50) not null,
	`placaVeiculo` varchar(6) not null,
	`ID_Carro` integer,
	`ID_Imagem` integer
) Engine = innodb;

-- Adicionando as chaves estrangeiras na tabela de informações dos carros 
alter table `informacoes_carro` add constraint fk_CarroImagem foreign key (`ID_Imagem`) references `tabela_imagens` (`codigoImg`);
alter table `informacoes_carro` add constraint fk_CarroMulta foreign key (`ID_Multa`) references `multas` (`ID_Multa`);

-- Adicionando as chaves estrangeiras na tabela de multas 
alter table `multas` add constraint fk_MultaImagem foreign key (`ID_Imagem`) references `tabela_imagens` (`codigoImg`);
alter table `multas` add constraint fk_MultaCarro foreign key (`ID_Carro`) references `informacoes_carro` (`ID_Carro`);

-- Adicionando as chaves estrangeiras na tabela de imagens 
alter table `tabela_imagens` add constraint fk_ImagemCarro foreign key (`ID_Carro`) references `informacoes_carro` (`ID_Carro`);
alter table `tabela_imagens` add constraint fk_ImagemMulta foreign key (`ID_Multa`) references `multas` (`ID_Multa`);

