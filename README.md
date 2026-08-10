# Sistema de Assistência Técnica de Computadores com Quarkus e Kafka

Trata-se de uma aplicação que gerencia informações de pedidos para uma assistência técnica.

É uma arquitetura de microsserviços composta pelos seguintes módulos:
* **Pedidos**, que tem as informações dos clientes, seus respectivos pedidos e os serviços contemplados em cada pedido. Roda na porta ```8080```
* **Pagamentos**, que permite a confirmação de um pagamento e a atualização do pedido a partir disso. Roda na porta ```8082```
* **Auditoria**, que informa no log operações efetuadas, como criação de pedido e confirmação de pagamento. Roda na porta ```8081```

# Como rodar?

## Executar o módulo pedidos
Abra o projeto na sua IDE de preferência (Eclipse, Intelij, etc.).

Abra o diretório do projeto no terminal disponibilizado pela IDE ou no do Sistema Operacional de digite o camando ```mvn clean quarkus:dev```. 


<img width="1500" height="640" alt="Diagrama-funcionamento-kafka" src="https://github.com/user-attachments/assets/3d3f7d0f-cc9e-4737-8787-1d562c76249d" />

