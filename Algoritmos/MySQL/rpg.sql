USE rpg;

SELECT * FROM classe;
SELECT * FROM habilidade;
SELECT * FROM inventario;
SELECT * FROM inventarioitem;
SELECT * FROM item;
SELECT * FROM jogador;
SELECT * FROM personagem;
SELECT * FROM personagemhabilidade;

#1
INSERT INTO jogador (nome, email, data_criacao) VALUES
('Julia Pereira', 'julia.pereira@example.com', '2024-05-07');
#2
DELETE FROM personagem WHERE nome = 'Eldor' AND personagem_id = '2';
#3
UPDATE personagem SET vida = '120', mana = '40' WHERE nome LIKE 'Thorin' AND personagem_id = '1';
#4
SELECT nome, tipo FROM item WHERE tipo LIKE 'arma';
#5
INSERT INTO habilidade VALUES ('Bola de Fogo', 'Ataque com bolas de fogos.', '25');
INSERT INTO personagemhabilidade VALUES ('1', '3');
#6
UPDATE item SET tipo = 'Arma especial' WHERE tipo LIKE 'Espada%';
#7
SELECT p.nome, c.nome FROM personagem p
INNER JOIN classe c ON p.classe_id = c.classe_id;
#8
SELECT p.nome, h.descricao FROM personagem p 
INNER JOIN personagemhabilidade ph ON p.personagem_id = ph.personagem_id
INNER JOIN habilidade h ON h.habilidade_id = ph.habilidade_id
WHERE h.custo_mana > 15;
#9
SELECT c.nome, i.nome FROM inventario iv
INNER JOIN inventarioitem ivi ON iv.inventario_id = ivi.inventario_id
INNER JOIN item i ON i.item_id = ivi.item_id
INNER JOIN personagem p ON p.personagem_id = iv.personagem_id
INNER JOIN classe c ON c.classe_id = p.classe_id
WHERE c.classe_id = 2;
#10
SELECT c.nome, COUNT(c.nome) AS Quantidade FROM personagem p
INNER JOIN classe c ON c.classe_id = p.classe_id
GROUP BY c.nome HAVING COUNT(c.nome);
#11
SELECT p.nome, i.nome AS Itens, COUNT(i.nome) AS Quantidade FROM inventario iv
INNER JOIN inventarioitem ivi ON iv.inventario_id = ivi.inventario_id
INNER JOIN item i ON i.item_id = ivi.item_id
INNER JOIN personagem p ON p.personagem_id = iv.personagem_id
GROUP BY p.nome ORDER BY p.nome ASC, i.nome ASC;
#12
SELECT p.nome AS Nome, c.nome AS Classe, MAX(p.nivel) AS Nivel FROM personagem p
INNER JOIN classe c ON p.classe_id = c.classe_id
GROUP BY p.nome;
#13
SELECT p.nome AS Nome, c.nome AS Classe, p.nivel AS Nivel, MAX(p.nivel) AS Ranking FROM personagem p
INNER JOIN classe c ON p.classe_id = c.classe_id
GROUP BY c.nome ORDER BY c.nome ASC, MAX(p.nivel) ASC;
#14
SELECT c.nome, p.nome, p.mana, p.vida, (SELECT AVG(nivel) FROM personagem) AS Media_Nivel FROM classe c
INNER JOIN personagem p ON p.classe_id = c.classe_id
GROUP BY p.nome;
#15
SELECT p.nome AS Personagem, i.nome AS Item FROM inventario iv
INNER JOIN inventarioitem ivi ON iv.inventario_id = ivi.inventario_id
INNER JOIN item i ON i.item_id = ivi.item_id
INNER JOIN personagem p ON p.personagem_id = iv.personagem_id
WHERE ivi.quantidade >= 1
GROUP BY p.nome ORDER BY p.nome;
#16
SELECT DISTINCT p.nome AS Personagem, h.nome AS Habilidade, h.custo_mana AS Custo FROM personagem p
INNER JOIN personagemhabilidade ph ON p.personagem_id = ph.personagem_id
INNER JOIN habilidade h ON h.habilidade_id = ph.habilidade_id
WHERE (SELECT MAX(h.custo_mana) FROM habilidade)
GROUP BY p.nome ORDER BY h.custo_mana DESC;