create table Cliente (
     id bigint primary key,
     email varchar(255) not null,
     nome varchar(255) not null,
     telefone varchar(255) not null
);

create table Cliente_SEQ (
    next_val BIGINT
);