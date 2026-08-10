create table Pedido (
    id bigint primary key,
    dataHora datetime not null,
    valorTotal decimal(9, 2) not null,
    status enum ('CANCELADO','CONCLUIDO','EM_ANDAMENTO','RECEBIDO') not null,
    cliente_id bigint,
    foreign key (cliente_id) references Cliente(id)
);

create table Pedido_SEQ (
    next_val BIGINT
);

create table pedido_servico (
    pedido_id bigint not null,
    servico_id bigint not null,
    foreign key (pedido_id) references Pedido(id),
    foreign key (servico_id) references Servico(id)
);