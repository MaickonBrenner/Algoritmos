USE rpg;

SELECT * FROM jogador;

SELECT * FROM personagem;

SELECT * FROM item;

SELECT * FROM habilidade;

INSERT INTO jogador (nome, email, data_criacao) VALUES
('Julia Pereira', 'julia.pereira@example.com', '2024-05-07');

DELETE FROM personagem WHERE nome = 'Eldor' AND personagem_id = '2';

UPDATE personagem SET vida = '120', mana = '40' WHERE nome LIKE 'Thorin' AND personagem_id = '1';

SELECT nome, tipo FROM item WHERE tipo LIKE 'arma';

