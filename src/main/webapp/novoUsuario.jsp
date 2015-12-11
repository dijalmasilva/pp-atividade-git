<%-- 
    Document   : novoUsuario
    Created on : 11/12/2015, 10:07:45
    Author     : IFPB
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User</title>
    </head>
    <body>
        <div>
            <h2>Novo Usuário</h2>
        </div>
        <div>
            <form action="newCliente" method="post">
                <input type="text" placeholder="Nome" name="nome"><br><br>
                <input type="text" placeholder="Sobrenome" name="sobrenome"><br><br>
                <input type="number" placeholder="Idade" name="idade"><br><br>
                <input type="submit" value="Cadastrar"><br><br>
            </form>
        </div>
        <c:if test="${cadastro} == true">
            <h4>Usuario Cadastrado com sucessso</h4>
        </c:if>
    </body>
</html>
