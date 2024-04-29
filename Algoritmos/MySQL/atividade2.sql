USE fiscal;

SELECT * FROM funcionarios;

SELECT * FROM projetos;

SELECT * FROM cargos;

SELECT * FROM funcionarios WHERE DepartamentoID = 5;

SELECT f.Nome, f.Sobrenome, f.DataContratacao FROM funcionarios AS f WHERE DataContratacao ORDER BY f.DataContratacao LIMIT 10;

SELECT COUNT(f.nome) AS Quantidade FROM funcionarios AS f WHERE DataContratacao >= "2023-01-01";

SELECT p.ProjetoID, p.NomeProjeto, p.Orçamento FROM projetos AS p WHERE DataInicio >= "2022-01-01" ORDER BY p.DataInicio DESC;