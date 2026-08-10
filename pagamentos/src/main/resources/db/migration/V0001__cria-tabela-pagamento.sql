create table Pagamento (
    id bigint primary key,
    status enum ('CRIADO', 'CONFIRMADO', 'CANCELADO'),
    pedido_id bigint
);

create table Pagamento_SEQ (
     next_val BIGINT
);