# Binarying
## _Aprenda Programação Jogando_
![Static Badge](https://img.shields.io/badge/version-0.9.0-blue)

Binarying é uma plataforma que te permite aprender programação de forma divertida.

## Features

- Tela de fases estilizadas como jogos isométricos
- Facilidade na prática de programação

## Tech

Binarying foi feito em::

- [Spring Boot](https://spring.io/) - FrameWork para java, utilizado no BackEnd
- [Docker](https://www.docker.com/) - Utilizado para rodar o Banco de Dados 

## Utilização

O Binarying precisa da versão 21 do [Java](https://www.oracle.com/java/technologies/downloads/) para rodar. Também é necessário o Docker instalado para que o spring se comunique com o banco de dados.

Para rodar, primeiro, abra o terminal na pasta "main-project" e rode o comando:
```sh
docker-compose up -d
```

Em seguida rode o Spring-Boot usando o comando:

```sh
./mvnw spring-boot:run
```

Agora basta entrar no navegador de sua preferência e abrir o link (http://localhost:8080)
