<%-- 
    Document   : edit
    Created on : 23 jun 2024, 22:33:52
    Author     : tibur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if(request.getAttribute("ListaEntidades")==null||
    request.getAttribute("Localidad")==null){
    response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Localidad</title>
    </head>
    <body>
        <h2>Editar Localidad</h2>
    </body>
</html>
