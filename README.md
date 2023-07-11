# Controle de usuários
Programa em java responsável pelo CRUD (create, read, update e delete) da tabela 'usuarios', que contém os campos nome, email, telefone, cpf. A aplicação foi feita no modelo MVC (model, view, controller), com front-end utilizando JSP. Sem utilização de nenhum framework.

## Divisão dos pacotes 

1. Dominio - responsável pela integração com a entidade do banco de dados e pela criação de seu modelo (DTO);
2. Controle - responsável pela manipulação dos dados da tela enviando-os para o banco;
3. View - front da aplicação.

<p align="center">
<img src="https://s2-techtudo.glbimg.com/KOoOj-V9yWLe8q1_t7HhEHHxkZw=/0x0:479x356/600x0/smart/filters:gifv():strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/a/X/P9PMn2Tx2DzVnJes78ag/2013-05-06-sem-titulo.jpg" width="400px"/>
</p>

<hr/>

# Replicação da tabela usuário

```
CREATE TABLE usuarios (
  nome VARCHAR(100),
  email VARCHAR(100),
  telefone VARCHAR(15),
  cpf VARCHAR(15)
);
```

# Tecnologias e bibliotecas utilizadas:

1. JDBC
2. MySQL
3. Java Servlet
4. Glassfish

   <hr/>
