CREATE DATABASE cadastro;
USE cadastro;

CREATE TABLE pessoas (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    nascimento DATE,
    sexo ENUM('M', 'F'),
    peso DECIMAL(5,2),
    altura DECIMAL(3,2),
    nacionalidade VARCHAR(20) DEFAULT 'Brasil',
    PRIMARY KEY(id)
);

INSERT INTO pessoas (id, nome, nascimento, sexo, peso, altura, nacionalidade) VALUES
	(DEFAULT, 'Ana', '1975-12-22', 'F', '52.3', '1.45', 'EUA'),
	(DEFAULT, 'Pedro', '2000-07-15', 'M', '62.4', '1.61', 'Brasil'),
    (DEFAULT, 'Maria', '1999-05-30', 'F', '75.9', '1.70', 'Portugal');
    
SELECT * FROM pessoas;
#Result Set

DESC pessoas;

#A palavra reservado COLUMN, não é obrigatória.
ALTER TABLE pessoas ADD COLUMN profissao VARCHAR(10);
#A nova coluna criada, por padrão, é inserida no final.

ALTER TABLE pessoas DROP COLUMN profissao;

ALTER TABLE pessoas ADD COLUMN profissao VARCHAR(10) AFTER nome;
#Cria uma coluna depois da coluna nome.

ALTER TABLE pessoas ADD COLUMN codigo INT FIRST;
#Cria uma nova coluna no início.

ALTER TABLE pessoas MODIFY COLUMN profissao VARCHAR(20) NOT NULL DEFAULT '';

ALTER TABLE pessoas CHANGE COLUMN profissao prof VARCHAR(20);

ALTER TABLE pessoas RENAME TO gafanhotos;
#Altera o nome da tabela "pessoas", para "gafanhotos".

CREATE TABLE IF NOT EXISTS cursos (
	nome VARCHAR(30) NOT NULL UNIQUE, #UNIQUE informa que é único, porém, não é uma PRIMARY KEY!
    descricao TEXT, #TEXT é para textos longos.
    carga INT UNSIGNED, #UNSIGNED informa que o valor não pode ser negativo.
    totalaulas INT UNSIGNED,
    ano YEAR DEFAULT '2024'
);

DESC cursos; #DESCRIBE

ALTER TABLE cursos ADD COLUMN idcurso INT FIRST;

ALTER TABLE cursos ADD PRIMARY KEY (idcurso);

DROP TABLE cursos;
#Apaga os dados e própria tabela.

INSERT INTO cursos VALUES
	('1', 'HMLT4', 'Curso de HTML5', '40', '37', '2014'),
    ('2', 'Algoritmos', 'Lógica de Programação', '20', '15', '2014'),
    ('3', 'Photoshop', 'Dicas de Photoshop CC', '10', '8', '2014'),
    ('4', 'PGP', 'Curso de PHP para Iniciantes', '40', '20', '2010'),
    ('5', 'Jarva', 'Introdução à Linguagem Java', '10', '29', '2000'),
    ('6', 'MySQL', 'Banco de Dados MySQL', '30', '15', '2016'),
    ('7', 'Word', 'Curso completo de Word', '40', '30', '2016'),
    ('8', 'Sapateado', 'Danças Rítmicas', '40', '30', '2018'),
    ('9', 'Cozinha Árabe', 'Aprenda a fazer Kibe', '40', '30', '2018'),
    ('10', 'YouTuber', 'Gerar polêmica e ganhar inscritos', '5', '2', '2018');

SELECT * FROM cursos;

#Deleta todos os registros, sem apagar a tabela, somente as linhas.
DELETE FROM cursos;
#Desativa o SAFE MODE que impede deletar ou atualizar dados em massa.
SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;

UPDATE cursos SET nome = 'HTML5' WHERE idcurso = 1;
UPDATE cursos SET nome = 'PHP', ano = '2015' WHERE idcurso = 4;
UPDATE cursos SET nome = 'Java', carga = '40', ano = '2015' WHERE idcurso = 5 LIMIT 1;
DELETE FROM cursos WHERE ano = '2018' LIMIT 3;
#Apaga os dados, mas mantém a estrutura da tabela.
TRUNCATE TABLE cursos;