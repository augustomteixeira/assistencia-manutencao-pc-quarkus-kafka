# Sistema de Assistência Técnica de Computadores com Quarkus e Kafka

Trata-se de uma aplicação que gerencia informações de pedidos para uma assistência técnica.

É uma arquitetura de microsserviços composta pelos seguintes módulos:
* Pedidos, que tem as informações dos clientes, seus respectivos pedidos e os serviços contemplados em cada pedido.
* Pagamentos, que permite a confirmação de um pagamento e a atualização do pedido a partir disso.
* Auditoria, que informa no log operações efetuadas, como criação de pedido e cconfirmação de pagamento.
<img width="1500" height="640" alt="Diagrama-funcionamento-kafka" src="https://github.com/user-attachments/assets/3d3f7d0f-cc9e-4737-8787-1d562c76249d" />

