# 🚀 TechMarket - API de Cadastro de Clientes

Este projeto é uma API REST robusta desenvolvida com **Spring Boot** para o gerenciamento de clientes. Ele demonstra a aplicação de padrões de projeto profissionais, validações de dados e persistência em um banco de dados relacional.

## 🛠️ Tecnologias Utilizadas
* **Java 25**: Utilizando as versões mais recentes da linguagem.
* **Spring Boot 3.5.7**: Framework base para a construção da API.
* **Spring Data JPA**: Para abstração da camada de persistência.
* **MySQL**: Banco de dados relacional para persistência permanente dos dados.
* **Swagger/OpenAPI 3**: Documentação interativa e testes de endpoints.
* **Jakarta Validation**: Regras de validação de e-mail e CPF diretamente no DTO.
* **Lombok**: Para redução de código boilerplate.

## 🌟 Funcionalidades de Destaque
- **CRUD Completo**: Criação, leitura, atualização e exclusão de clientes.
- **Busca por Nome**: Filtro inteligente que busca por trechos do nome, ignorando maiúsculas e minúsculas.
- **Validação de Negócio**: O sistema impede o cadastro de CPFs duplicados, lançando exceções tratadas.
- **Camada de DTO**: Proteção da entidade do banco de dados através de objetos de transferência de dados.

## 📁 Estrutura do Projeto
A arquitetura segue o padrão de camadas para facilitar a manutenção:
* `controller`: Porta de entrada da API e gerenciamento de rotas HTTP.
* `service`: Concentra as regras de negócio e validações.
* `repository`: Interface de comunicação direta com o MySQL.
* `dto`: Objetos de entrada de dados com validações integradas.
* `model`: Representação das tabelas do banco de dados.

## 🚀 Como Executar
1. Clone o repositório.
2. Certifique-se de ter o **MySQL** instalado e rodando.
3. Crie o banco de dados: `CREATE DATABASE techmarket_db;`.
4. Configure suas credenciais no arquivo `src/main/resources/application.properties`.
5. Execute o projeto via IntelliJ ou terminal com `./mvnw spring-boot:run`.

## 📖 Documentação (Swagger)
Com a aplicação rodando, acesse a documentação interativa para testar todos os endpoints:
`http://localhost:8080/swagger-ui/index.html`

---
Desenvolvido por **Danilo Domingues** durante o aprendizado de arquitetura Spring Boot.
