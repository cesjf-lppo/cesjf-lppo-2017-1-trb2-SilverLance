<%-- 
    Document   : nova-coleta
    Created on : 21/05/2017, 11:40:05
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NovaColeta</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Nova Coleta</h1>
        <div style="color: red;">${mensagem}</div>
        <form method="post">
            <div><label> Descricao: <input type="text" name="descricao" value="${coleta.descricao}" /></label> </div>
            <div><input type="submit" value="CADASTRAR"/></div>   
        </form>
    </body>
</html>