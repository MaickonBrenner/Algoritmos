create database spotify;

use spotify;

create table usuarios(
	codigo int not null,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    data_nascimento date null,
    primary key (codigo)
);

create table playlist(
	codigo int not null,
    nome varchar(255) not null,
    codigo_usuario_criador int not null,
    primary key (codigo),
    constraint 'fk_codigo_usuario_criador_usuario_codigo' foreign key (codigo_usuario_criador) references usuarios (codigo) on delete cascade
    #on delete restrige
);