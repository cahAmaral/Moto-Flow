# 🏍️ MotoFlow

Sistema web para gerenciamento de motos, modelos, operadores, movimentações e setores, desenvolvido em **Java 17** com **Spring Boot 3**, **Spring Security**, **JPA/Hibernate** e **Oracle Database**.  
Inclui autenticação com controle de acesso por papéis (**USER** e **ADMIN**) e documentação interativa via **Swagger UI**.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **Thymeleaf**
- **Oracle Database**
- **Lombok**
- **Swagger / SpringDoc OpenAPI**

---

## ⚙️ Configuração do Projeto

### 1️⃣ Clone o repositório
```bash
git clone https://github.com/cahAmaral/MotoFlow.git
cd MotoFlow
```

### 2️⃣ Configure o banco de dados Oracle
No arquivo `application.properties` ou `application.yml`, ajuste as credenciais:
```properties
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/XE
spring.datasource.username=system
spring.datasource.password=admin
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
```

---

## 🔐 Autenticação e Usuários

O sistema utiliza **Spring Security** com autenticação **HTTP Basic** e criptografia de senhas com **BCrypt**.

Ao iniciar a aplicação, um usuário padrão é criado automaticamente:

| Usuário | Senha   | Papel        |
|----------|----------|--------------|
| admin    | 123456   | ROLE_ADMIN   |

Esse usuário possui acesso total ao sistema.

---

## 📚 Endpoints Principais (Swagger)

Após rodar o projeto, acesse:

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Endpoints disponíveis:
- `/api/usuarios` → CRUD de usuários
- `/api/motos` → CRUD de motos
- `/api/modelos` → CRUD de modelos
- `/api/setores` → CRUD de setores
- `/api/operadores` → CRUD de operadores
- `/api/movimentacoes` → CRUD de movimentações

---

## 🧩 Estrutura de Pacotes

```
com.motoflow.motoflow
├── config           → Configurações de segurança e beans
├── controller       → Controladores REST e Views
│   ├── api          → Endpoints JSON
│   └── view         → Páginas Thymeleaf
├── model            → Entidades JPA
├── repository       → Interfaces JPA
├── service          → Regras de negócio
└── MotoFlowApplication.java → Classe principal
```

---

## 🧠 Funcionalidades

- Login e autenticação com **Spring Security**
- Controle de acesso por **roles (USER/ADMIN)**
- CRUD completo para todas as entidades
- Interface web com **Thymeleaf**
- Documentação interativa com **Swagger UI**
- Senhas criptografadas com **BCrypt**
- Integração total com banco **Oracle**

---

## 🖥️ Execução

Para rodar o projeto localmente:

```bash
mvn spring-boot:run
---

Integrantes
RM
558012
558301
556999
