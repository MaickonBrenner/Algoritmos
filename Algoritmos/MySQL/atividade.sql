USE controle_financeiro;

SELECT * FROM usuario;

SELECT * FROM conta;

SELECT * FROM tipo_conta;

SELECT * FROM movimentacao;

SELECT nome, data_de_nascimento FROM usuario;

SELECT descricao, saldo FROM conta WHERE codigo_tipo_conta = 1;

SELECT * FROM movimentacao;

#Exercicios de DML e Outros

INSERT INTO usuario (nome, rua, numero, bairro, cep, cidade, UF, data_de_nascimento) VALUES
('José Ivaldo', 'Bleasby Freire', '050', 'Henrique Jorge', '62590000', 'Fortaleza', 'CE', '2000-01-01 00:00:00');

UPDATE usuario SET data_de_nascimento = '1977-09-29 00:00:00' WHERE codigo = 4;

INSERT INTO usuario (nome, rua, numero, bairro, cep, cidade, UF, data_de_nascimento) VALUES
('Maria Marlene', 'Marques Araujo', '050', 'Conjunto Ceará', '62590000', 'Fortaleza', 'CE', '1959-08-27 00:00:00');

INSERT INTO tipo_conta (codigo, descricao) VALUES 
(3, 'Conta investimento');

INSERT INTO movimentacao (descricao, tipo_movimentacao, valor, codigo_conta, data_movimentacao) VALUES 
('Pagamento Loja', 'CREDITO', 1500, 4, '2024-07-15 00:00:00');

UPDATE usuario SET cep = '60115170' WHERE codigo = 2;

DELETE FROM movimentacao WHERE codigo_conta = 3;

SELECT * FROM usuario WHERE EXTRACT(MONTH FROM data_de_nascimento) = 8;
#MySQL considera os dias da semana como um inteiro de 0 - 6 começando por segunda feira e indo até domingo.

INSERT INTO usuario (nome, rua, numero, bairro, cep, cidade, UF, data_de_nascimento) VALUES
('Chico Science', 'Riacho do Navio', '050', 'Jangurussu', '66790000', 'Fortaleza', 'CE', '2003-06-20 00:00:00');

SELECT * FROM usuario WHERE DAYOFWEEK(data_de_nascimento) = 4;

ALTER TABLE usuario ADD COLUMN idade INT;
ALTER TABLE usuario DROP COLUMN idade;

SELECT codigo, nome, FLOOR(DATEDIFF(CURDATE(), data_de_nascimento) / 365.25) AS idade FROM usuario;

SELECT * FROM movimentacao WHERE data_movimentacao ORDER BY data_movimentacao ASC;

SELECT * FROM movimentacao WHERE data_movimentacao ORDER BY data_movimentacao DESC;

SELECT * FROM movimentacao WHERE data_movimentacao ORDER BY data_movimentacao ASC LIMIT 1;

SELECT * FROM usuario WHERE cep IS NULL;

#Funções de Agregação

SELECT MAX(saldo) FROM conta WHERE codigo_tipo_conta = 3;

SELECT * FROM movimentacao WHERE descricao LIKE "%Alimentacao%";
SELECT AVG(valor) FROM movimentacao WHERE descricao LIKE "%Alimentação%";

SELECT * FROM movimentacao WHERE data_movimentacao BETWEEN CONVERT("2023-04-15", DATE) AND CONVERT("2023-05-12", DATE);
SELECT * FROM movimentacao WHERE data_movimentacao BETWEEN "2023-04-15" AND "2023-05-12";

SELECT * FROM usuario WHERE cep IS NOT NULL;

SELECT MAX(valor) FROM movimentacao WHERE valor < 50; #10
SELECT MIN(valor) FROM movimentacao WHERE valor < 50; #10
SELECT FLOOR(AVG(valor)) FROM movimentacao WHERE valor < 50; #FLOOR = Função Piso e CEILING = Função Teto

SELECT SUM(valor) FROM movimentacao WHERE data_movimentacao BETWEEN CONVERT("2021-11-01", DATE) AND CONVERT("2021-12-31", DATE);
SELECT SUM(valor) FROM movimentacao WHERE data_movimentacao BETWEEN "2021-11-01" AND "2021-12-31";

SELECT SUM(saldo) AS Soma FROM conta;

SELECT FLOOR(AVG(valor)) AS Media FROM movimentacao;

SELECT codigo_conta, AVG(valor) AS Media FROM movimentacao GROUP BY codigo_conta;

SELECT codigo_conta, COUNT(valor) AS Quantidade FROM movimentacao GROUP BY codigo_conta;

#Extra
ALTER TABLE usuario ADD COLUMN data_admicao DATETIME;
ALTER TABLE usuario ADD COLUMN data_demicao DATETIME;
SELECT * FROM usuario WHERE data_demicao BETWEEN CONVERT("2023-04-01", DATE) AND CONVERT("2023-05-31", DATE);

#Tabelas de Junção (JOIN)

SELECT u.codigo, u.nome, c.saldo FROM usuario u INNER JOIN conta c ON u.codigo = c.codigo_usuario;

SELECT u.codigo, u.nome, IFNULL(c.saldo, 0) AS saldo FROM usuario u LEFT JOIN conta c ON u.codigo = c.codigo_usuario;

SELECT u.codigo, u.nome, COUNT(c.codigo) AS quantidade FROM usuario u INNER JOIN conta c ON u.codigo = c.codigo_usuario GROUP BY u.codigo, u.nome;

SELECT DISTINCT u.codigo, u.nome FROM usuario u INNER JOIN conta c ON u.codigo = c.codigo_usuario;

SELECT u.codigo, u.nome, c.saldo, m.* FROM usuario u 
INNER JOIN conta c ON c.codigo_usuario = u.codigo 
LEFT JOIN movimentacao m ON m.codigo_conta = c.codigo;

SELECT u.codigo, u.nome, c.saldo, tp.descricao, COUNT(m.codigo) FROM usuario u 
INNER JOIN conta c ON c.codigo_usuario = u.codigo 
INNER JOIN tipo_conta tp ON tp.codigo = c.codigo_tipo_conta
LEFT JOIN movimentacao m ON m.codigo_conta = c.codigo
GROUP BY u.codigo, u.nome, c.saldo, tp.descricao;
