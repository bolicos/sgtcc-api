# Sistema de Gerenciamento de TCC

----

Gerenciamento de TCCs de turmas do IFRS.

----

## Front-end 

Como este projeto é somente a parte do Back-end, sendo uma API REST, o Front-end se encontra em outro projeto:

 **Projeto com React.JS:**
 
- [Front-end](https://github.com/analuciabolico/sgtcc-front)

----

## PLSQL

- [PLSQL](https://github.com/analuciabolico/sgtcc-api/tree/master/plsql)

----

![Java CI with Gradle](https://github.com/analuciabolico/sgtcc-api/workflows/Java%20CI/badge.svg) <img src='https://img.shields.io/github/tag/analuciabolico/sgtcc-api.svg' alt='latest semver version' /> <img src='https://img.shields.io/github/issues/analuciabolico/sgtcc-api.svg' alt='open issues badge' /> <img src='https://img.shields.io/github/issues-pr/analuciabolico/sgtcc-api.svg' alt='open pull requests badge' />

## Dependências

O que você precisa para instalar o software e como instalá-lo:

- [Java 11](https://computingforgeeks.com/how-to-install-java-11-on-ubuntu-debian-linux/)
- [Oracle ](https://www.oracle.com/database/technologies/xe-downloads.html)
- Gradle 6.7
- [Git SCM](https://git-scm.com/download/linux)

- Obs .: O gradle está incorporado no projeto e não requer instalação.

----

## Configurando banco de dados local via Docker

Execute esse comando para criar o oracle via docker

```sh
docker run --name oracle18 -d -p 1521:1521 pvargacl/oracle-xe-18.4.0
```

----

## Após instalar e configurar as dependências, para executar o projeto faça os seguintes passos:


1. Abra um terminal e rode este comando para baixar o projeto:

```sh
git clone https://github.com/analuciabolico/sgtcc-api.git
```

2. Entre na pasta do projeto:
```sh
cd ./sgtcc-api
```

3. Dentro da pasta do projeto rode este comando para iniciar a aplicação:

```sh
./gradlew bootRun
```

## E para rodar os testes, siga estes passos:

1. Esteja dentro da pasta do projeto e rode este comando:

```sh
./gradlew test
```

----

## Wiki

- [Wiki](https://github.com/analuciabolico/sgtcc-api/wiki)

**A wiki contém informações sobre:**

- Link do Swagger
- Collections do Postman com rotas

----

## Autoras

**Ana Lúcia Bolico de Oliveira** [GitHub Ana Lúcia](https://github.com/analuciabolico)

**Ana Clara Kettl** [GitHub Ana Clara](https://github.com/anakettl) 

