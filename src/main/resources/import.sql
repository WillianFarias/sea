-- Inserir um setor
INSERT INTO setor (nome) VALUES ('Setor A');

-- Inserir um cargo vinculado ao setor
INSERT INTO cargo (nome, setor_id) VALUES ('Cargo X', 1);

-- Inserir um trabalhador vinculado ao setor e cargo
INSERT INTO trabalhador (nome, cpf, cargo_id) VALUES ('João Silva', '12345678901', 1);