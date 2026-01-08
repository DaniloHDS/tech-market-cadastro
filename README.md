# TechMarket - Sistema de Cadastro de Clientes

Este é um projeto de API REST desenvolvido para gerenciar o cadastro de clientes de uma plataforma de tecnologia. O sistema permite a persistência de dados em um banco real e buscas personalizadas.

## 🚀 Tecnologias Utilizadas
* **Java 25**
* **Spring Boot 3.5.7**
* **Spring Data JPA**
* **MySQL Server**
* **Swagger/OpenAPI** (Documentação da API)
* **Maven** (Gerenciador de dependências)

## 🛠️ Funcionalidades
- [x] Cadastro de clientes (Nome, E-mail, CPF).
- [x] Validação de dados (CPF com 11 dígitos, e-mail válido).
- [x] Listagem de todos os clientes.
- [x] **Busca por parte do nome** (Ignora maiúsculas e minúsculas).
- [x] Persistência em banco de dados MySQL.

## 📋 Como rodar o projeto
1. Clone o repositório.
2. Certifique-se de ter o MySQL instalado e crie o banco `teckmarket_db`.
3. Configure seu usuário e senha no arquivo `src/main/resources/application.properties`.
4. Execute a classe `TechMarketApplication`.
5. Acesse a documentação em: `http://localhost:8080/swagger-ui/index.html`

## 🧪 Testes
O projeto conta com testes unitários e de integração utilizando **JUnit 5** e **Mockito** para garantir a qualidade das rotas de controller e lógica de serviço.
