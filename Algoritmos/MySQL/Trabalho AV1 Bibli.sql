create database biblioteca;
use biblioteca;

create table usuarios (
	id_usuarios int not null auto_increment,
    nome varchar(255) not null,
    tipo_usuario varchar(50) not null,
    tempo_emprestimo int(8) not null,
    primary key(id_usuarios)
);

create table telefones (
	id_telefone int not null auto_increment,
    id_usuario_telefone int not null,
    telefone varchar(50),
    primary key(id_telefone),
    constraint 'fk_id_usuario_telefone_usuario_id' foreign key (id_usuario_telefone) references usuarios (id_usuarios) on delete cascade
);

create table endereco (
	id_endereco int not null auto_increment,
    id_usuario_endereco int not null,
    rua varchar(50),
    numero varchar(50),
    cep varchar(50),
    bairro varchar(50),
    primary key(id_endereco),
    constraint 'fk_id_usuario_endereco_usuario_id' foreign key (id_usuario_endereco) references usuarios (id_usuarios) on delete cascade
);

create table livros (
	id_livros int not null auto_increment,
    titulo varchar(100) not null,
    ano date,
    autores varchar(255),
    edicao int(11),
    isbn int(11),
    quantidade_disponivel int(50),
    primary key(id_livros)
);

create table exemplar (
	id_exemplar int not null auto_increment,
    id_livro_exemplar int not null,
    status_livro varchar(10) not null,
    primary key(id_exemplar),
    constraint 'fk_id_livros_exemplar_livro_id' foreign key (id_livros_exemplar) references livros (id_livros) on delete cascade
);

create table emprestimos (
	id_emprestimo int not null auto_increment,
    id_livro_emprestimo int not null,
    id_usuario_emprestimo int not null,
    data_emprestimo date,
    primary key(id_emprestimo),
    constraint 'fk_id_livro_emprestimo_livros_id' foreign key (id_livro_emprestimo) references livros (id_livros) on delete cascade,
    constraint 'fk_id_usuario_emprestimo_usuario_id' foreign key (id_usuario_emprestimo) references usuarios (id_usuarios) on delete cascade,
);

create table reservas (
	id_reserva int not null auto_increment,
    id_livro_reserva int not null,
    id_usuario_reserva int not null,
    data_reserva date,
    primary key(id_reserva),
    constraint 'fk_id_livro_reserva_livros_id' foreign key (id_livro_reserva) references livros (id_livros) on delete cascade,
    constraint 'fk_id_usuario_reserva_usuario_id' foreign key (id_usuario_reserva) references usuarios (id_usuarios) on delete cascade,
);

create table devolucao (
	id_devolucao int not null auto_increment,
    id_livro_devolucao int not null,
    id_usuario_devolucao int not null,
    data_devolucao date,
    primary key(id_devolucao),
    constraint 'fk_id_livro_devolucao_livros_id' foreign key (id_livro_devolucao) references livros (id_livros) on delete cascade,
    constraint 'fk_id_usuario_devolucao_usuario_id' foreign key (id_usuario_devolucao) references usuarios (id_usuarios) on delete cascade,
);

create table multa (
	id_multa int not null auto_increment,
    id_livro_multa int not null,
    id_usuario_multa int not null,
    data_multa date,
    primary key(multa),
    constraint 'fk_id_livro_multa_livros_id' foreign key (id_livro_multa) references livros (id_livros) on delete cascade,
    constraint 'fk_id_usuario_multa_usuario_id' foreign key (id_usuario_multa) references usuarios (id_usuarios) on delete cascade,
);