CREATE TABLE pacientes
(
    id          SERIAL PRIMARY KEY,
    nome        VARCHAR(100) NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE,
    telefone    VARCHAR(20)  NOT NULL,
    cpf         VARCHAR(14)  NOT NULL UNIQUE,
    endereco_id INT,
    ativo       BOOLEAN      NOT NULL DEFAULT TRUE,
    FOREIGN KEY (endereco_id) REFERENCES enderecos (id)
);