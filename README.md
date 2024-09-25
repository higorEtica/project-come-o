# Projeto incial Crud 

É um crud simples com as operações de inserção, atualização, exclusão e listagem de dados.
Para aprimorar o conhecimento em java (Spring boot ) e em react 

## Tecnologias utilizadas

 - Java 17
 - Spring Boot
 - React
 - Docker
 - Mysql 8.0

## Como rodar o projeto

Para executar segue os seguintes passos:

1. Clone o projeto
2. Entre na pasta do projeto
3. Execute o comando `docker-compose build --no-cache` para criar a imagem do projeto 
4. Execute o comando `docker-compose up -d` para subir o banco de dados e a plicação a porta é [8080](http://localhost:8080/)
5. Acesse a pasta frontend e execute o comando `npm install` para instalar as dependências isso fica dentro da pasta ReactCrud

## Endpoints

- GET /api/v1/client
- POST /api/v1/client
- PUT /api/v1/client/{id}
- DELETE /api/v1/client/{id}
- GET /api/v1/client/{id}

## swagger

[Swagger](http://localhost:8080/api/v1/swagger-ui/index.html)

