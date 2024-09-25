# Etapa 1: Construir o projeto
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o arquivo pom.xml e as dependências para o container
COPY pom.xml .

# Baixa as dependências do Maven sem rodar o build
RUN mvn dependency:go-offline

# Copia o código-fonte do projeto para o container
COPY src ./src

# Compila o projeto e gera o .jar final
RUN mvn clean package -DskipTests

# Etapa 2: Executar a aplicação
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o .jar gerado na etapa de build para o diretório de trabalho
COPY --from=build /app/target/crud-0.0.1-SNAPSHOT.jar /app/spring-app.jar

# Exponha a porta 8080 para acessar a aplicação
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/spring-app.jar"]
