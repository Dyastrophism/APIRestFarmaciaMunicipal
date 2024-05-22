create table remedio(
    id serial primary key,
    nome varchar(255) not null,
    fabricante varchar(255) not null,
    dosagem varchar(255) not null,
    forma_farmaceutica varchar(255) not null,
    quantidade_em_estoque integer not null)
);