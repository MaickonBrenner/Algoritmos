USE cadastro_usuarios;

SELECT * FROM cursos;

SELECT * FROM gafanhotos;

SELECT * FROM gafanhotos WHERE sexo = "F";

SELECT * FROM cursos ORDER BY nome;

SELECT * FROM cursos ORDER BY nome DESC;

SELECT nome, carga, ano FROM cursos ORDER BY nome;

SELECT ano, nome, carga FROM cursos ORDER BY ano, nome;
#Query = Consulta, solicitação
SELECT nome, descricao FROM cursos WHERE ano = "2016" ORDER BY ano, nome;

SELECT nome, descricao, ano FROM cursos WHERE ano <= "2015" ORDER BY ano, nome;

#BETWEEN: SELECIONA INTERVALOS
SELECT * FROM cursos WHERE ano BETWEEN "2014" AND "2016" ORDER BY ano DESC, nome ASC;

#IN: SELECIONANDO VALORES
SELECT nome, descricao, ano FROM cursos WHERE ano IN ("2014", "2016") ORDER BY ano;

SELECT nome, carga, totaulas FROM cursos WHERE carga > 35 AND totaulas < 30;

SELECT nome, carga, totaulas FROM cursos WHERE carga > 35 OR totaulas < 30;

#LIKE: "parecido" e o % substitui "Nenhum" ou "Vários" caracteres.
SELECT * FROM cursos WHERE nome LIKE "P%";

SELECT * FROM cursos WHERE nome LIKE "%a";

SELECT * FROM cursos WHERE nome LIKE "%a%";

SELECT * FROM cursos WHERE nome NOT LIKE "%a%";

#SUBLINHADO: obriga ter pelo menos um caractere
SELECT * FROM cursos WHERE nome LIKE "%ph%p_";

SELECT * FROM cursos WHERE nome LIKE "%p_p%";

SELECT * FROM cursos WHERE nome LIKE "%ph%p_";

#Distinguindo - Mostra apenas uma vez objeto repetido
SELECT DISTINCT carga FROM cursos ORDER BY carga;
#Paises cadastrados na tabela
SELECT DISTINCT nacionalidade FROM gafanhotos;

SELECT DISTINCT nacionalidade FROM gafanhotos ORDER BY nacionalidade;

SELECT COUNT(*) AS Quantidade_Cursos FROM cursos;

SELECT COUNT(*) AS Cursos_Acima_40h FROM cursos WHERE carga > 40;

SELECT MAX(carga) AS Maior_Carga_Horaria FROM cursos;

SELECT MAX(totaulas) AS Total_Horas_Maximas FROM cursos WHERE ano = "2016";

SELECT nome, MIN(totaulas) AS Total_Horas_Maximas FROM cursos WHERE ano = "2016";

SELECT SUM(totaulas) AS Total_Aulas FROM cursos WHERE ano = "2016";

SELECT AVG(totaulas) AS Media_Total_Aulas FROM cursos WHERE ano = "2016";

#1 - Lista de todas as alunas do banco
SELECT * FROM gafanhotos WHERE sexo = "F" ORDER BY nome;
#2 - Lista com os dados de todos que nasceram entre 1 Jan 2000 e 31 Dez 2015
SELECT * FROM gafanhotos WHERE nascimento BETWEEN "2000-01-01" AND "2015-12-31" ORDER BY nome;
#3 - Lista com homens que são programadores
SELECT * FROM gafanhotos WHERE sexo = "M" AND profissao = "Programador" ORDER BY nome;
#4 - Listar todas as mulheres brasileiras e que comecem com J
SELECT * FROM gafanhotos WHERE nacionalidade = "Brasil" AND nome LIKE "J%";
#5 - Listar nome e nacionalidade de todos os homens que tem Silva no nome, não são Brasil, e pesam 100kg
SELECT nome, nacionalidade FROM gafanhotos WHERE nacionalidade NOT LIKE "Brasil" AND nome LIKE "%Silva%" AND peso <= "100" AND sexo = "M";
#6 - Qual a maior altura entre os homens que moram no Brasil
SELECT MAX(altura) AS Maior_Altura_Homens FROM gafanhotos WHERE nacionalidade = "Brasil" AND sexo = "M";
#7 - Qual a media de peso entre todos os cadastrados
SELECT AVG(peso) FROM gafanhotos;
#8 - Qual a menor peso entre mulheres que nasceram fora do brasil e entre 1 Jan 1990 e 31 Dez 2000
SELECT MIN(peso) AS Menor_Peso FROM gafanhotos WHERE sexo = "F" AND nacionalidade NOT LIKE "Brasil" AND nascimento BETWEEN "1990-01-01" AND "2000-12-01" ORDER BY nome;
#9 - Quantas mulheres tem mais de 1,90 de altura
SELECT COUNT(altura) AS Mulheres_Maiores_1_90 FROM gafanhotos WHERE altura >= "1.90" AND sexo = "F";

SELECT carga AS Cargas_Horarias FROM cursos GROUP BY carga ORDER BY carga;

SELECT carga AS Cargas_Horarias, COUNT(nome) AS Quantidade FROM cursos GROUP BY carga ORDER BY carga;

SELECT totaulas, COUNT(*) AS Quantidade FROM cursos GROUP BY totaulas ORDER BY totaulas;

SELECT carga, totaulas, COUNT(*) AS Quantidade FROM cursos WHERE totaulas = 30 GROUP BY carga;

SELECT carga, COUNT(nome) AS Quantidade FROM cursos GROUP BY carga HAVING COUNT(nome) > 3;

SELECT ano, COUNT(*) AS Quantidade FROM cursos GROUP BY ano HAVING COUNT(*) >= 5 ORDER BY COUNT(*) DESC;

SELECT AVG(carga) FROM cursos;

SELECT carga, COUNT(*) AS Quantidade FROM cursos WHERE ano > 2015 GROUP BY carga HAVING carga > (SELECT AVG(carga) FROM cursos);

#1 - Lista de Profissão dos gafanhotos e Quantidades 
SELECT profissao, COUNT(profissao) AS Quantidade FROM gafanhotos GROUP BY profissao;

#2 - Lista quantos homens e quantas mulher nasceram após 01 Jan 2005
SELECT sexo, COUNT(*) AS Quantidade FROM gafanhotos WHERE nascimento > '2005-01-01' GROUP BY sexo;

SELECT
(SELECT COUNT(*) FROM gafanhotos WHERE sexo LIKE 'M' AND nascimento > '2005-01-01') AS Masculino,
(SELECT COUNT(*) FROM gafanhotos WHERE sexo LIKE 'F' AND nascimento > '2005-01-01') AS Feminino;

#3 - Lista de gafanhotos que nasceram fora do Brasil, mostrado o pais e o total nascidas lá, somente mais de 3 com a nascionlidade
SELECT nome, nacionalidade FROM gafanhotos WHERE nacionalidade NOT LIKE 'Brasil';

SELECT nacionalidade, COUNT(nacionalidade) AS Nacionalidade FROM gafanhotos WHERE nacionalidade NOT LIKE 'Brasil' GROUP BY nacionalidade;

SELECT nacionalidade, COUNT(nacionalidade) AS Nacionalidade FROM gafanhotos WHERE nacionalidade NOT LIKE 'Brasil' 
GROUP BY nacionalidade HAVING COUNT(nacionalidade) >= 3;

#4 - Lista agrupada pela altura mostrando quantas pessoas pesam mais de 100kg e estao acima da media de altura
SELECT COUNT(altura) AS Quantidade FROM gafanhotos WHERE peso >= 100
GROUP BY altura HAVING COUNT(altura) > (SELECT AVG(altura) FROM gafanhotos);

# FOREIGN KEYS E JOIN
DESCRIBE gafanhotos;

ALTER TABLE gafanhotos ADD COLUMN cursopreferido INT;
ALTER TABLE gafanhotos ADD FOREIGN KEY (cursopreferido) REFERENCES cursos(idcurso);

SELECT * FROM gafanhotos;
SELECT * FROM cursos;

UPDATE gafanhotos SET cursopreferido = '6' WHERE id = '1';

SELECT nome, cursopreferido FROM gafanhotos;
SELECT nome, ano FROM cursos;

SELECT g.nome, c.nome, c.ano FROM gafanhotos AS g INNER JOIN cursos AS c ON c.idcurso = g.cursopreferido ORDER BY g.nome;
#LEFT OUTER JOIN
SELECT g.nome, c.nome, c.ano FROM gafanhotos AS g LEFT JOIN cursos AS c ON c.idcurso = g.cursopreferido;
#RIGHT OUTER JOIN
SELECT g.nome, c.nome, c.ano FROM gafanhotos AS g RIGHT JOIN cursos AS c ON c.idcurso = g.cursopreferido;

CREATE TABLE gafanhoto_assiste_curso (
	id INT NOT NULL AUTO_INCREMENT,
    data date,
    idgafanhoto INT,
    idcurso INT,
    PRIMARY KEY (id),
    FOREIGN KEY (idgafanhoto) REFERENCES gafanhotos(id),
    FOREIGN KEY (idcurso) REFERENCES cursos(idcurso)
);

SELECT * FROM gafanhoto_assiste_curso;

INSERT INTO gafanhoto_assiste_curso VALUES
(DEFAULT, '2014-03-01', '1', '2');

SELECT g.nome, c.nome FROM gafanhotos AS g
INNER JOIN gafanhoto_assiste_curso AS a
ON g.id = a.idgafanhoto
INNER JOIN cursos AS c
ON c.idcurso = a.idcurso
ORDER BY g.nome;