# Sistema de Assistência Técnica de Computadores com Quarkus e Kafka

Trata-se de uma aplicação que gerencia informações de pedidos para uma assistência técnica.

É uma arquitetura de microsserviços composta pelos seguintes módulos:
* **Pedidos**, que gerencia os clientes, seus respectivos pedidos e os serviços contemplados em cada pedido. Roda na porta ```8080```.
* **Auditoria**, que informa no log operações efetuadas, como criação de pedido e confirmação de pagamento. Roda na porta ```8081```.
* **Pagamentos**, que permite a confirmação de um pagamento e a atualização do pedido a partir disso. Roda na porta ```8082```.

# Como rodar?

## Executar o módulo Pedidos
Abra o projeto na IDE sua de preferência (Eclipse, Intellij, etc.).

Abra o diretório do projeto no terminal disponibilizado pela IDE ou no do Sistema Operacional e digite o comando ```mvn clean quarkus:dev```. 

Abra o Postman, importe a coleção ```assistencia-manut-pc-pedidos.postman_collection.json``` e acesse os endpoints.

## Executar o módulo Pagamentos
Abra o projeto na IDE de sua preferência (Eclipse, Intelij, etc.).

Abra o diretório do projeto no terminal disponibilizado pela IDE ou no do Sistema Operacional e digite o comando ```mvn clean quarkus:dev```. 

Abra o Postman, importe a coleção ```assistencia-manut-pc-pagamentos.postman_collection.json``` e acesse os endpoints.

## Executar o módulo Auditoria
Abra o projeto na IDE de sua preferência (Eclipse, Intelij, etc.).

Abra o diretório do projeto no terminal disponibilizado pela IDE ou no do Sistema Operacional e digite o comando ```mvn clean quarkus:dev```. 

Veja as saídas que serão impressas no log ao efetuar operações como **Criar Pedido** e **Confirmar Pagamento**.

## Executar o Kafka
No Terminal, abra o diretório raiz do projeto, onde fica o arquivo ```docker-compose.yml``` e rode o comando abaixo:
```bash
docker compose up
```

## Diagrama para representar a comunicação entre os módulos
<img width="1500" height="570" alt="Diagrama funcionamento Kafka" src="https://github.com/user-attachments/assets/86fafd8c-41d1-4995-bcc6-b6c75aa5252e" />


## Fluxo principal da aplicação

1. O microsserviço **Pedidos** cria um novo pedido.
2. Um evento **PedidoCriado** é publicado no Kafka.
3. O microsserviço **Pagamentos** consome o evento e cria um pagamento.
4. O microsserviço **Auditoria** imprime a criação do pedido.
5. Após a confirmação do pagamento, o evento **PagamentoConfirmado** é publicado.
6. O microsserviço **Pedidos** consome o evento e atualiza o status do pedido para `CONCLUIDO`.
7. O microsserviço **Auditoria** imprime a confirmação do pagamento.
