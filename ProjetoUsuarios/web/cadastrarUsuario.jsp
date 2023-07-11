<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CADASTRO USUARIO</title>
        <style>
            body{
                font-family: "Roboto", sans-serif;
                background-color: #f8f8f8;
            }
            h1{
                text-align: center;
                margin:50px;
            }
            form{
                background: #FFFFFF;
                margin: 0 auto 100px;
                padding: 45px;
                text-align: center;
                width: 50%;
                height: 90%;
                box-shadow: 0 0 20px 0 rgba(0,0,0,0.2),0 5px 5px rgba(0,0,0,0.24);
            }
            input{
                outline: 0;
                background: #f2f2f2;
                color: black;
                width: 50%;
                border:0;
                margin: 0 0 15px;
                box-sizing: border-box;
                font-size: 14px;
                height: 30px;
                border-radius: 10px;
            }
            button{
                text-transform: uppercase;
                outline: 0;
                background-color: #242424;
                border: 0;
                border-radius: 10px;
                padding: 10px;
                color: white;
                font-size: 10px;
                height: 35px;
                cursor: pointer;
                font-size: 14px;
            }
        </style>
    </head>
    <body>
        <h1>Cadastro</h1>
        <form action="ControleUsuario" method="post">
            <label for="nome">Nome:</label><br>
            <input type="text" id="nome" name="nome" ><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" ><br><br>

            <label for="telefone">Telefone:</label><br>
            <input type="text" id="telefone" name="telefone" ><br><br>

            <label for="cpf">CPF:</label><br>
            <input type="text" id="cpf" name="cpf" ><br><br>

            <button type="submit">Criar cadastro</button>
        </form>
    </body>
</html>
