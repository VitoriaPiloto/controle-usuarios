<%-- 
    Document   : processaEdicao
    Created on : 10 de jul de 2023, 23:44:34
    Author     : Vitória
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, dominio.*"%>dominio
<jsp:useBean id="u" class="dominio.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edição concluída com sucesso</h1>
        <%
            System.out.println(u.getNome());
            System.out.println(u.getEmail());
            System.out.println(u.getTelefone());
            System.out.println(u.getCpf());
            DaoUsuario.atualizar(u);
            response.sendRedirect("listarUsuarios.jsp");
        %>
    </body>
</html>
