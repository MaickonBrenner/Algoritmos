USE cadastro_usuarios;

SELECT * FROM cursos;

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