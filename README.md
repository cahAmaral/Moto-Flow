MotoFlow
Descrição

O MotoFlow é um sistema desenvolvido em Java com Spring Boot para gerenciamento de motos, modelos e movimentações. A aplicação permite realizar operações de CRUD (Create, Read, Update, Delete) em entidades como Moto, Modelo e Movimentação, fornecendo uma API REST para integração com front-end ou ferramentas externas.

Funcionalidades

Listar motos, modelos e movimentações.

Criar, editar e deletar motos, modelos e movimentações.

Suporte a operações via API REST.

Integração com banco de dados Oracle.

Log de queries geradas pelo Hibernate.

Tecnologias utilizadas

Java 21

Spring Boot 3.5.6

Spring Data JPA

Hibernate ORM

Thymeleaf (views, parcialmente implementado)

Banco de dados Oracle

Maven (gerenciamento de dependências)

Endpoints da API
Moto
Método	Endpoint	Descrição
GET	/motos	Lista todas as motos
POST	/motos	Cria uma nova moto
GET	/motos/{id}	Busca moto por ID
PUT	/motos/{id}	Atualiza moto existente
DELETE	/motos/{id}	Remove moto por ID
Modelo
Método	Endpoint	Descrição
GET	/modelos	Lista todos os modelos
POST	/modelos	Cria um novo modelo
GET	/modelos/{id}	Busca modelo por ID
PUT	/modelos/{id}	Atualiza modelo existente
DELETE	/modelos/{id}	Remove modelo por ID
Movimentação
Método	Endpoint	Descrição
GET	/movimentacoes	Lista todas as movimentações
POST	/movimentacoes	Cria uma nova movimentação
GET	/movimentacoes/{id}	Busca movimentação por ID
PUT	/movimentacoes/{id}	Atualiza movimentação existente
DELETE	/movimentacoes/{id}	Remove movimentação por ID
Rodando o projeto
Pré-requisitos

Java 21

Maven

Banco de dados Oracle

IDE (IntelliJ IDEA, Eclipse ou VSCode)

Passos

Clone o repositório:

git clone https://github.com/cahAmaral/Moto-Flow.git


Configure o application.properties com as credenciais do banco Oracle:

spring.datasource.url=jdbc:oracle.fiap.com.br/1521:orcl
spring.datasource.username=rm558012
spring.datasource.password=200106
spring.jpa.hibernate.ddl-auto=update


Rode o projeto:

mvn spring-boot:run


Teste os endpoints via Postman ou qualquer cliente REST.

Integrantes
RM
558012
558301
556999
