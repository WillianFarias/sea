-- Inserir setores
INSERT INTO setor (nome) VALUES ('Setor A'), ('Setor B'), ('Setor C');

-- Inserir cargos vinculado ao setor
INSERT INTO cargo (nome, setor_id) VALUES ('Cargo 1', 1), ('Cargo 2', 1), ('Cargo 3', 2), ('Cargo 4', 2), ('Cargo 5', 3), ('Cargo 6', 3);

-- Inserir um trabalhador vinculado ao setor e cargo
INSERT INTO trabalhador (cpf, nome, cargo_id) VALUES ('11111111111', 'João', 1), ('22222222222', 'Maria', 2), ('33333333333', 'José', 3), ('44444444444', 'Ana', 4), ('55555555555', 'Pedro', 5), ('66666666666', 'Laura', 6);