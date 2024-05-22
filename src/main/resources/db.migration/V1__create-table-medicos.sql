CREATE TABLE medicos
(
    id                   SERIAL PRIMARY KEY,
    nome                 VARCHAR(100) NOT NULL,
    email                VARCHAR(100) NOT NULL UNIQUE,
    crm                  VARCHAR(20)  NOT NULL UNIQUE,
    telefone             VARCHAR(20)  NOT NULL,
    ativo                BOOLEAN      NOT NULL DEFAULT TRUE,
    especialidade_medico VARCHAR(50)  NOT NULL,
    endereco_id          INT,
    FOREIGN KEY (endereco_id) REFERENCES enderecos (id)
);