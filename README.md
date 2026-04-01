# 📦 Sistema de Controle de Estoque

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de produtos, movimentações e controle de estoque com alertas automáticos.

---

## 🚀 Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Flyway (migrations)
* Lombok
* Swagger (OpenAPI)
* Java Mail (envio de email)

---

## 📁 Estrutura do projeto

```
src/main/java/com/zerbini/controle_estoque
│
├── controller      # Endpoints REST
├── service         # Regras de negócio
├── repository      # Acesso ao banco
├── entity          # Entidades JPA
├── dto             # Transferência de dados (DTO)
├── mapper          # Conversão DTO ↔ Entity
├── exception       # Tratamento global de erros
├── response        # Response padrão da API
└── config          # Configurações (Swagger, etc)
```

---

## ⚙️ Como rodar o projeto

### 🔹 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/controle-estoque.git
cd controle-estoque
```

---

### 🔹 2. Configurar banco de dados

Crie um banco no MySQL:

```sql
CREATE DATABASE estoque_db;
```

---

### 🔹 3. Configurar application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/estoque_db
spring.datasource.username=SEU_USER
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
```

---

### 🔹 4. Configurar envio de e-mail (opcional)

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=SEU_EMAIL@gmail.com
spring.mail.password=SENHA_DE_APP
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

### 🔹 5. Rodar aplicação

Via terminal:

```bash
mvn spring-boot:run
```

Ou rodar a classe:

```
ControleEstoqueApplication.java
```

---

## 📘 Documentação da API

Swagger disponível em:

```
http://localhost:8080/swagger-ui.html
```

---

## 📬 Principais endpoints

### 📦 Produtos

| Método | Endpoint       | Descrição       |
| ------ | -------------- | --------------- |
| POST   | /produtos      | Criar produto   |
| GET    | /produtos      | Listar produtos |
| GET    | /produtos/{id} | Buscar por ID   |
| PUT    | /produtos/{id} | Atualizar       |
| DELETE | /produtos/{id} | Deletar         |

---

### 📊 Movimentações

| Método | Endpoint                    | Descrição    |
| ------ | --------------------------- | ------------ |
| GET    | /movimentacoes              | Listar todas |
| GET    | /movimentacoes/produto/{id} | Por produto  |

---

## 📧 Alerta de estoque

Quando o produto atinge o estoque mínimo:

* Log é gerado
* Email é enviado automaticamente

---

## 🧪 Testes

Para rodar os testes:

```bash
mvn test
```

---

## 🧠 Funcionalidades

* CRUD de produtos
* Entrada e saída de estoque
* Histórico de movimentações
* Alerta automático de estoque baixo
* Paginação de dados
* Tratamento global de erros

---

## 📌 Melhorias futuras

* Autenticação (JWT)
* Deploy em nuvem (AWS / Render)
* Docker
* Cache com Redis
* Integração com filas (RabbitMQ)

---

## Autor

Desenvolvido por **Carolina Zerbini** 🚀
Backend Developer

---
