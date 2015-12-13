<%-- 
    Document   : removeUsuario
    Created on : 13/12/2015, 09:24:58
    Author     : dijalma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover Usuario</title>
    </head>
    <body>
        <h1>Remover Usuário</h1>
        <div>
            <table border="1" class="padding">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Sobrenome</th>
                        <th>Idade</th>
                        <th>Opção</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${usuarios}" var="user">
                        <tr>
                            <td>${user.nome}</td>
                            <td>${user.sobrenome}</td>
                            <td>${user.idade}</td>
                            <td><a href="removeUser?id=${user.id}">Remover</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <c:if test="${removeu == true}">
            <h4>Usuário removido com sucesso!</h4>
        </c:if>

        <br><br><br>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
