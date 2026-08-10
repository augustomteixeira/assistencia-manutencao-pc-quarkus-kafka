# Sistema de Assistência Técnica de Computadores com Quarkus e Kafka

Trata-se de uma aplicação que gerencia informações de pedidos para uma assistência técnica.

É uma arquitetura de microsserviços composta pelos seguintes módulos:
* **Pedidos**, que gerencia os clientes, seus respectivos pedidos e os serviços contemplados em cada pedido. Roda na porta ```8080```.
* **Auditoria**, que informa no log operações efetuadas, como criação de pedido e confirmação de pagamento. Roda na porta ```8081```.
* **Pagamentos**, que permite a confirmação de um pagamento e a atualização do pedido a partir disso. Roda na porta ```8082```.

# Como rodar?

## Executar o módulo Pedidos
Abra o projeto na sua IDE de preferência (Eclipse, Intellij, etc.).

Abra o diretório do projeto no terminal disponibilizado pela IDE ou no do Sistema Operacional e digite o comando ```mvn clean quarkus:dev```. 

Abra o Postman, importe a coleção ```assistencia-manut-pc-pedidos.postman_collection.json``` e accesse os endpoints.

## Executar o módulo Pedidos
Abra o projeto na sua IDE de preferência (Eclipse, Intelij, etc.).

Abra o diretório do projeto no terminal disponibilizado pela IDE ou no do Sistema Operacional e digite o camando ```mvn clean quarkus:dev```. 

Abra o Postman, importe a coleção ```assistencia-manut-pc-pedidos.postman_collection.json``` e accesse os endpoints.

## Executar o módulo Auditoria
Abra o projeto na sua IDE de preferência (Eclipse, Intelij, etc.).

Abra o diretório do projeto no terminal disponibilizado pela IDE ou no do Sistema Operacional e digite o camando ```mvn clean quarkus:dev```. 

Veja as saídas que serão impressas no log ao efetuar operações como **Criar Pedido** e **Confirmar Pagamento**.

## Executar o Kafka
No Terminal, abra o diretório raiz do projeto, onde fica o arquivo ```doccker-compose.yml``` e rode o comando abaixo:
```
docker compose up
```

## Diagrama para representar a comunicação entre os módulos
<img width="1500" height="640" alt="Diagrama-funcionamento-kafka" src="https://github.com/user-attachments/assets/3d3f7d0f-cc9e-4737-8787-1d562c76249d" />

