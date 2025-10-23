# mspedido

Microserviço de Pedidos

## Tecnologias

- Spring Boot 3.5.6
- Spring Data JPA
- Spring Cloud Netflix Eureka Client
- MySQL
- Flyway
- Lombok

## Executar

```bash
mvn spring-boot:run
```

## Endpoints

- GET /pedidos - Listar pedidos (paginado)
- GET /pedidos/{id} - Buscar pedido por ID
- POST /pedidos - Criar novo pedido
- PUT /pedidos/{id} - Atualizar pedido
- DELETE /pedidos/{id} - Deletar pedido

## Modelo de Dados

### Pedido
- id: Long
- dataPedido: LocalDateTime
- idProdutos: List<Long>
- statusPedido: StatusPedido (CRIADO, CONFIRMADO, CANCELADO)