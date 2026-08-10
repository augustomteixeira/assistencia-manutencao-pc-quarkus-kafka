create table Servico (
    id bigint primary key,
    preco decimal(9, 2) not null,
    tipo enum ('FORMATACAO','INSTALACAO_PROGRAMAS','OTIMIZACAO_DESEMPENHO','REMOCAO_VIRUS') not null
);

create table Servico_SEQ (
    next_val BIGINT
);