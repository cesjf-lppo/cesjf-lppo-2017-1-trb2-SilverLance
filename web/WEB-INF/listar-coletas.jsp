<%-- 
    Document   : listar-coletas
    Created on : 21/05/2017, 11:44:52
    Author     : Adriano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Coletas</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Lista de Coletas</h1>
        <div style="color: red;">${mensagem}</div>
        <table border="1px">
            <thead>
                <tr>
                <th>ID</th>
                <th>Descricão</th>
                <th>Data</th>
                </tr>
            </thead>    
            <tbody>
                <c:forEach var="coleta" items="${coletas}">    
                <tr>
                    <td>${coleta.id}</td>
                    <td>${coleta.descricao}</td>
                    <td>${coleta.data}</td>
                    <td><a href="nova-leitura.html?id=${coleta.id}">FAZER LEITURA</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
