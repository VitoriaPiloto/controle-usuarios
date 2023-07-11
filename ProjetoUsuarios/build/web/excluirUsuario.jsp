<%-- 
    Document   : excluirUsuario
    Created on : 10 de jul de 2023, 22:38:36
    Author     : Vitória
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, dominio.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONFRIMAÇÃO EXCLUSÃO</title>
        <style>
            body{
                font-family: "Open Sans",sans-serif;
                padding: 1.35em;
                background-color: #f8f8f8;
            }
            h1{
                color: #242424;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>Usuário excluído com sucesso ;)</h1>
        <%
            String cpf = request.getParameter("cpf");
            DaoUsuario.excluir(cpf);
        %>
    </body>
</html>
