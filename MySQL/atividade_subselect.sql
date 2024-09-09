USE escola;

SELECT * FROM alunos;

SELECT * FROM cursos;

SELECT * FROM matriculas;

SELECT * FROM professores;

#1 - Liste os alunos que estão matriculados em pelo menos um curso que seu colega "Maria Fernanda" também está matriculado

#Utilizando SubConsultas
SELECT a.Nome AS Nome, c.Nome_Curso AS Curso FROM alunos a, matriculas m, cursos c
WHERE m.ID_Aluno = a.ID_Aluno AND m.ID_Curso = c.ID_Curso AND m.ID_Curso IN (
	SELECT m2.ID_Curso FROM matriculas m2, alunos a2
    WHERE m2.ID_Aluno = a2.ID_Aluno AND a2.ID_Aluno = 1);

#Utilizando INNER JOIN
SELECT a.Nome AS Nome, c.Nome_Curso AS Curso FROM alunos a
INNER JOIN matriculas m ON a.ID_Aluno = m.ID_Aluno
INNER JOIN cursos c ON c.ID_Curso = m.ID_Curso
WHERE EXISTS (
	SELECT 1 FROM matriculas m2
    INNER JOIN alunos a2 ON m2.ID_Aluno = a2.ID_Aluno
    WHERE a2.ID_Aluno = 1 AND m2.ID_Curso = m.ID_Curso);

#2 - Liste os professores que lecionam mais de um curso.

#Utilizando SubConsultas

SELECT p.Nome AS Professor FROM professores p 
WHERE p.ID_Professor IN (
	SELECT c.ID_Professor FROM cursos c 
    GROUP BY c.ID_Professor HAVING COUNT(DISTINCT c.ID_Curso) > 1);

#Utilizando INNER JOIN

SELECT p.Nome, COUNT(c.ID_Professor) AS Curso_Lecionados FROM professores p
INNER JOIN cursos c ON p.ID_Professor = c.ID_Professor
WHERE (SELECT COUNT(c.ID_Professor) FROM cursos c WHERE ) > 2
GROUP BY p.Nome;

#Todos os professores:
SELECT p.Nome, COUNT(c.ID_Professor) AS Curso_Lecionados FROM professores p
INNER JOIN cursos c ON p.ID_Professor = c.ID_Professor
GROUP BY p.Nome;

#3 - Liste os nomes dos cursos que não têm alunos matriculados em 2024.

#Utilizando SubConsultas

SELECT c.nome AS nome_curso
FROM cursos c
WHERE c.id_curso NOT IN (
    SELECT DISTINCT m.id_curso
    FROM matriculas m
    WHERE YEAR(m.data_matricula) = 2024
);

#Utilizando INNER JOIN