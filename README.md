# :books: Primeira Aplicação Spring
<div align="center" display="flex" style="justify-content:flex-start;">
      <img align="center" alt="java" height="60" width="60" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" />
</div>

<p align="center">
 <a href="#desc">Descrição</a> •
 <a href="#about">O que a API faz?</a> •
 <a href="#rotas">Rotas</a> •
 <a href="#exemplos">Modelos</a> •
 <a href="#tecnologias">Tecnologias</a> • 
 <a href="#executando">Executar o projeto</a> • 
 <a href="#autor">Autor</a>
</p>

<div id="desc"/>

## 📝 Descrição
Primeiros passos com Spring-boot. <br>
Esse projeto tem por objetivo implementar algumas tecnologias do ecossistema Spring. <br>


<div id="about"/>

## ⚙️ O que a API faz?
Consiste em uma API que simula um sistema universitário, existe a entidade usuario e disciplina. <br>
Uma disciplina é formada por vários alunos. <br>
Cada disciplina tem comentários, likes e pode ser classificadas em ordem de avaliações. <br>

> NOTE: A aplicação utiliza um banco em memória, quando ela é finalizada, os dados são perdidos

<div id="rotas" />

## :busstop: Rotas
#### Login
- [ ] POST /auth/login
  
#### Usuário
- [ ] POST /api/usuarios
- [ ] GET /api/usuarios
- [ ] GET /api/usuarios/id
- [ ] PUT /api/usuarios/id
- [ ] DELETE /api/usuarios/id

#### Publicações
- [ ] POST /api/disciplinas
- [ ] GET /api/disciplinas
- [ ] GET /api/disciplinas/id
- [ ] PUT /api/disciplinas/nome/id
- [ ] PUT /api/disciplinas/nota/id
- [ ] PUT /api/disciplinas/likes/id
- [ ] GET /ranking/likes
- [ ] GET /ranking/notas
- [ ] DELETE /api/disciplinas/id

<div id="exemplos"/>

## 📑 Modelos JSON
##### JSON para criação de usuário: <br>
```json
{
    "nome": "Jurema",
    "email": "jurama.htinha@gmail.com",
    "senha": "jureminhaVidaLoka123"
}
```

##### JSON para criação de disciplina: <br>
```json
{
    "nome": "Análise de Dados com Python",
    "nota": 9
}
```

<div id="tecnologias"/>

## ✨ Tecnologias

-   [ ] [Java](https://www.java.com/pt-BR/)
-   [ ] [Spring Boot](https://spring.io/)
-   [ ] [Project Lombok](https://projectlombok.org/)
-   [ ] [Json Web Token](https://jwt.io/)
-   [ ] [Jackson Databind](https://github.com/FasterXML/jackson-databind)
-   [ ] [H2 Database](h2database.com/html/main.html)
-   [ ] [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
-   [ ] [Hibernate](https://hibernate.org/)

<div id="executando" />

## ▶️ Executando o projeto

Para executar localmente, siga os passos:
```sh
$ git clone https://github.com/MarcosLudgerio/firstAppSpring.git
$ cd firstAppSpring
$ ./mvnw install
$ ./mvnw spring-boot:run
```

<div id="autor" />

## 👩‍💻 Autor 

<table>
   <tr>
     <td align="center">
        <a href="https://github.com/MarcosLudgerio">
         <img style="border-radius: 50%;" src="https://avatars0.githubusercontent.com/u/43012976?s=460&u=1163c04d9f35b577063b3f6550ae520c4dd2f866&v=4" width="100px;" alt=""/>
        </a>
        <br/><sub><b>Marcos Ludgério</b></sub>
     </td>
   </tr>
</table>
