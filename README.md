# Microservices & API - Exercício PÓS-GRADUAÇÃO

## Sobre o Projeto

Este projeto é um exercício da pós-graduação de desenvolvimento web da instituição UNIPE, no qual foram aplicados conceitos fundamentais da arquitetura de microserviços. A implementação demonstra na prática o padrão **Service Registry** utilizando Netflix Eureka como servidor centralizado de registro de serviços, permitindo que as instâncias dos microserviços se registrem automaticamente e possam ser descobertas dinamicamente. O **Service Discovery** é implementado através do cliente Eureka, que consulta o registry para localizar as instâncias disponíveis dos serviços. Um **API Gateway** construído com Spring Cloud Gateway atua como ponto de entrada único, fornecendo roteamento inteligente, balanceamento de carga automático e políticas de roteamento baseadas em predicados, direcionando as requisições para as instâncias mais adequadas dos microserviços backend.

## Arquitetura

O projeto é composto por 4 microserviços:

- **Service Registry**: Servidor Eureka para registro e descoberta de serviços
- **Gateway**: API Gateway para roteamento e load balancing
- **MS Pedido**: Microserviço responsável pela gestão de pedidos
- **MS Produto**: Microserviço responsável pela gestão de produtos

## Requisitos

### Software Necessário

- **Java**: JDK 21
- **Maven**: 3.6+ (incluído nos projetos via wrapper)
- **VS Code**: Para desenvolvimento e debug
- **Extensões VS Code recomendadas**:
  - Extension Pack for Java
  - Spring Boot Extension Pack
  - REST Client (para testar as APIs)

### Verificação dos Requisitos

```bash
# Verificar versão do Java
java -version

# Verificar Maven (caso tenha instalado globalmente)
mvn -version
```

## Como Executar o Projeto

### Ordem de Inicialização

É importante seguir a ordem correta de inicialização dos serviços:

1. **Service Registry** (porta 8761)
2. **MS Produto** 
3. **MS Pedido**
4. **Gateway** (última a ser iniciada)

### Opção 1: Execução via Terminal

#### 1. Service Registry
```bash
cd serviceregistry
./mvnw spring-boot:run
```

#### 2. MS Produto
```bash
cd msproduto
./mvnw spring-boot:run
```

#### 3. MS Pedido
```bash
cd mspedido
./mvnw spring-boot:run
```

#### 4. Gateway
```bash
cd gateway
./mvnw spring-boot:run
```

### Opção 2: Execução com Debug no VS Code

#### Executando com Debug

1. **Abra o VS Code** na raiz do projeto
2. **Inicie o debug**:
   - Vá para a aba `Run and Debug` (Ctrl+Shift+D)
   - Execute cada serviço individualmente na ordem correta

## Portas dos Serviços

- **Service Registry (Eureka)**: http://localhost:8761
- **Gateway**: http://localhost:8080
- **MS Produto**: Porta dinâmica (registrada no Eureka)
- **MS Pedido**: Porta dinâmica (registrada no Eureka)

## Endpoints Disponíveis

### Via Gateway (http://localhost:8080)

- **Produtos**: `/produtos`
- **Pedidos**: `/pedidos`

### Eureka Dashboard

- **URL**: http://localhost:8761
- **Descrição**: Interface web para visualizar os serviços registrados

## Testando a API

Use o arquivo `http.rest` na raiz do projeto para testar os endpoints usando a extensão REST Client do VS Code.

## Estrutura do Projeto

```
├── .vscode/                 # Configurações do VS Code
├── gateway/                 # API Gateway
├── serviceregistry/         # Eureka Server
├── mspedido/               # Microserviço de Pedidos
├── msproduto/              # Microserviço de Produtos
├── http.rest               # Arquivo para testes de API
└── README.md               # Este arquivo
```

## Tecnologias Utilizadas

- **Spring Boot 3.5.6**
- **Spring Cloud 2025.0.0**
- **Netflix Eureka** (Service Discovery)
- **Spring Cloud Gateway** (API Gateway)
- **Java 21**
- **Maven** (Gerenciamento de dependências)