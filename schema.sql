-- Projeto: API de gestão de chamados de atendimento
-- Banco: chamados_db (PostgreSQL)
-- Autor: Vinicius Degelo

CREATE TABLE status(
	id_status SERIAL PRIMARY KEY,
	descricao_status VARCHAR(30) NOT NULL
);

CREATE TABLE tipo_chamado(
	id_tipo_chamado SERIAL PRIMARY KEY,
	descricao_tipo VARCHAR(30) NOT NULL
);

CREATE TABLE tecnico(
	id_tecnico SERIAL PRIMARY KEY,
	nome VARCHAR(40) NOT NULL,
	nivel VARCHAR(20) CHECK (nivel IN ('Junior', 'Pleno', 'Senior'))
);

CREATE TABLE chamados(
	id_chamado SERIAL PRIMARY KEY,
	id_status INT REFERENCES status(id_status),
	id_tipo_chamado INT REFERENCES tipo_chamado(id_tipo_chamado),
	id_tecnico INT REFERENCES tecnico(id_tecnico),
	data_abertura TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	data_solucao TIMESTAMP
);

INSERT INTO status (descricao_status) VALUES
	('Aberto'),
	('Em andamento'),
	('Resolvido');

INSERT INTO tipo_chamado(descricao_tipo) VALUES
	('Hardware'),
	('Software'),
	('Rede');

INSERT INTO tecnico(nome, nivel) VALUES
	('Joao Silva', 'Junior'),
	('Maria Santos', 'Pleno'),
	('Carlos Souza','Senior');

INSERT INTO chamados (id_status, id_tipo_chamado, id_tecnico, data_abertura, data_solucao) VALUES
(1, 2, 1, '2026-07-20 09:15:00', '2026-07-20 14:30:00'),
(2, 1, 2, '2026-07-21 10:00:00', NULL);

SELECT * FROM status;
SELECT * FROM tipo_chamado;
SELECT * FROM tecnico;
SELECT * FROM chamados;

SELECT 
    c.id_chamado,
    t.nome AS tecnico,
    tc.descricao_tipo AS tipo,
    s.descricao_status AS status,
    c.data_abertura,
    c.data_solucao
FROM chamados c
JOIN tecnico t ON c.id_tecnico = t.id_tecnico
JOIN tipo_chamado tc ON c.id_tipo_chamado = tc.id_tipo_chamado
JOIN status s ON c.id_status = s.id_status;
