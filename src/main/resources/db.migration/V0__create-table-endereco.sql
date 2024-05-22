CREATE TABLE enderecos (
    id SERIAL PRIMARY KEY,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(100),
    cidade VARCHAR(50) NOT NULL,
    uf VARCHAR(2) NOT NULL
);