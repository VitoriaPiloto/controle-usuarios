<%-- 
    Document   : listarUsuarios
    Created on : 10 de jul de 2023, 00:19:20
    Author     : Vitória
--%>

<%@page import="java.util.*, dominio.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR USUARIOS</title>
        <style>
            body{
                font-family: "Open Sans",sans-serif;
                padding: 1.35em;
                background-color: #f8f8f8;
            }
            table {
                table-layout: fixed;
                border: 1px solid #ccc;
                border-collapse: collapse;
                margin:0;
                padding: 0;
                width: 100%;
            }
            tr, td {
                font-size: 1em;
                margin:.5em 0 .75em;
            }
            tr {
                background-color: white;
                border: 1px solid #ddd;
                padding: .35em;
            }
            th, td {
                padding: .625em;
                text-align: center;
            }
            th {
                font-size: .85em;
                letter-spacing: .1em;
                text-transform: uppercase;
            }
            a{
                text-decoration: none;
                color: black;
            }
        </style>
    </head>
    <body>
        <h2>Listagem usuários</h2>
        <hr/>
        <%
        List<Usuario> list = DaoUsuario.consultar();
        request.setAttribute("list", list);
        %>
        
        <table>
            <tr>
                <th>NOME</th>
                <th>EMAIL</th>
                <th>TELEFONE</th>
                <th>CPF</th>
                <th>-</th>
                <th>-</th>
            </tr>
            <c:forEach items="${list}" var="usu">
                <tr>
                    <td>${usu.getNome()}</td>
                    <td>${usu.getEmail()}</td>
                    <td>${usu.getTelefone()}</td>
                    <td>${usu.getCpf()}</td>
                    <td><a href="editarUsuario.jsp?cpf=${usu.getCpf()}">Editar</a></td>
                    <td><a href="excluirUsuario.jsp?cpf=${usu.getCpf()}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

