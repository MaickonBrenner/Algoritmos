USE fiscal;

SELECT * FROM funcionarios;

SELECT * FROM departamentos;

SELECT * FROM alocacoes;

SELECT * FROM projetos;

SELECT * FROM cargos;

SELECT * FROM funcionarios WHERE DepartamentoID = 5;

SELECT f.Nome, f.Sobrenome, f.DataContratacao FROM funcionarios AS f WHERE DataContratacao ORDER BY f.DataContratacao LIMIT 10;

SELECT COUNT(f.Nome) AS Quantidade FROM funcionarios AS f WHERE DataContratacao >= "2023-01-01";

SELECT p.ProjetoID, p.NomeProjeto, p.Orçamento FROM projetos AS p WHERE DataInicio >= "2022-01-01" ORDER BY p.Orçamento DESC LIMIT 5;

SELECT c.CargoID, c.titulo, c.SalarioBase FROM cargos AS c WHERE SalarioBase ORDER BY SalarioBase DESC LIMIT 5;

SELECT DISTINCT f.FuncionarioID, COUNT(p.ProjetoID) AS Projetos_Envolvidos FROM funcionarios f
INNER JOIN alocacoes AS a ON a.FuncionarioID = f.FuncionarioID
INNER JOIN projetos AS p ON p.ProjetoID = a.ProjetoID
GROUP BY f.FuncionarioID;

SELECT f.Nome, f.Sobrenome, c.Titulo FROM funcionarios AS f 
INNER JOIN cargos AS c ON f.CargoID = c.CargoID
GROUP BY f.Nome, f.Sobrenome, c.Titulo;

SELECT d.Nome, COUNT(f.FuncionarioID) AS Funcionarios_Envolvidos FROM departamentos AS d
INNER JOIN funcionarios AS f ON f.DepartamentoID = d.DepartamentoID
GROUP BY d.Nome;

