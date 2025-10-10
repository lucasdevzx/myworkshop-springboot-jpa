# Estágio 1: Build da Aplicação com Maven e Java 21
# ATUALIZADO: Usando uma imagem base com suporte ao Java 21.
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o pom.xml primeiro para aproveitar o cache de dependências do Docker
COPY pom.xml .

# Baixa todas as dependências do projeto
RUN mvn dependency:go-offline

# Copia o resto do código-fonte
COPY src ./src

# Executa o build, gerando o arquivo .jar
RUN mvn clean package -DskipTests


# Estágio 2: Execução da Aplicação com Java 21
# ATUALIZADO: Usando uma imagem JRE (Java Runtime Environment) baseada no Java 21,
# que é mais leve para produção.
FROM eclipse-temurin:21-jre

# Define o diretório de trabalho
WORKDIR /app

# ATUALIZADO: Copia o .jar gerado com o nome do seu projeto ('projectF')
COPY --from=build /app/target/projectF-*.jar app.jar

# Expõe a porta que a sua aplicação usa (padrão do Spring Boot é 8080)
EXPOSE 8080

# Comando para iniciar a aplicação quando o contêiner rodar
ENTRYPOINT ["java", "-jar", "app.jar"]