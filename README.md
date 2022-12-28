# Bem Vindos ao repositório do projeto Streaming Microsservice

[![Continuos Integration with GitHub](https://github.com/Humberto-Bonadiman/streaming-microsservice/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/Humberto-Bonadiman/streaming-microsservice/actions/workflows/docker-publish.yml)

---

## Descrição do projeto

Neste projeto eu fui responsável por criar uma aplicação de microsserviços utilizando o Eureka, Api-Gateway, Spring-Boot com MySQL, Zipkin e RabbitMQ.
</br>
A aplicação conta com 3 microsserviços, um para a adição de filmes, um para a adição de series e um que cria categorias onde é possível utilizar informações tanto dos filmes como das series.

---

## Explicação de alguns componentes

Eureka: é uma solução de service discovery, que em conjunto com outras ferramentas possibilita gerenciamento dinâmico e escalabilidade para as aplicações.
</br>
Api-Gateway: um API Gateway pode ser usado para autenticar chamadas de API. Dessa forma, mesmo que o cliente precise acessar dados de vários serviços, ele só precisará fazer a autenticação uma vez no gateway. Isso reduz a latência e garante que os processos de autenticação sejam consistentes em todo o aplicativo.
</br>
Zipkin: é uma solução usada para interpretar os logs de serviço desde um simples troubleshoot até uma interface gráfica para visualização e monitoração das aplicações.
</br>
RabbitMQ: é um software open source de mensageria. Fornece uma forma comunicação assíncrona de dados entre processos, aplicações ou servidores.

## Instalação do projeto localmente

Após cada um dos passos, haverá um exemplo do comando a ser digitado para fazer o que está sendo pedido.

1. Realize o clone do projeto no diretório de sua preferência:
```javascript
git clone git@github.com:humberto-bonadiman/streaming-microsservice.git
```

2. Acesse todos os diretórios do projeto, utilize o comando **mvn install** para instalar todas as dependências necessárias e depois para empacotar o código compilado é necessário utilizar o comando **mvn package**:
```javascript
  mvn install
  mvn package
```

## Comandos para utilizar o Docker

Para criar e iniciar os contêineres:
</br>
Obs.: Com o comando abaixo o docker fica rodando no terminal.
```javascript
docker-compose up
```

Para criar e iniciar os contêineres em stand-by:
```javascript
docker-compose up -d
```

Para realizar apenas a etapa de build das imagens que serão utilizadas:
```javascript
docker-compose build
```

Para paralisar e remover todos os contêineres e seus componentes como rede, imagem e volume:
```javascript
docker-compose down
```
---

## Utilizando o Spring-boot sem o Docker

Nos arquivos dos diretórios movies-service, series-service e streaming-service que está no caminho **/src/main/resources/application.yml** de cada um deles você deve alterar o usuário e senha do seu MySQL:
```javascript
spring:
  datasource:
    username: username
    password: password
```

Rodar o Spring-Boot em todos os diretórios (indico começar pelo naming-server) com o comando:
```javascript
mvn spring-boot:run
```

---

## Documentação

![Documentação Swagger](swagger_bank_account.png)
![Documentação Swagger](swagger_bank_account.png)
![Documentação Swagger](swagger_bank_account.png)

Para acessar a documentação pelo swagger rode o comando **mvn spring-boot:run** em todos os diretórios ou **docker-compose up** no diretório raiz e acesse o projeto via browser, no caminho http://localhost:8765/swagger-ui.html.

## URLs disponíveis com o projeto rodando

Eureka (Naming Server) --> http://localhost:8761/
</br>
API Gateway Swagger    --> http://localhost:8765/swagger-ui.html
</br>
RabbitMQ               --> http://localhost:15672  (somente com o Docker)
</br>
API Gateway Movies     --> http://localhost:8765/movies-service
</br>
API Gateway Series     --> http://localhost:8765/series-service
</br>
API Gateway Streaming  --> http://localhost:8765/streaming-service
</br>
Zipkin                 --> http://localhost:9411/zipkin/ (somente com o Docker)
