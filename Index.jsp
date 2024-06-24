<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mrysi.Beans.Escuelas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="..//WEB-INF/jspf/menu.jspf" %>
        <%getServletContext().getRequestDispatcher("/LocalidadLoad").include(request,response);%>
        <h2>Entidades Federativas</h2>
        <a href="new.jsp">Agregar</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Entidad</th>
                <th>Turno</th>
                <th></th>
            </tr>
            <c:forEach items="${requestScope.ListaEscuelas}" var="e">
                <tr>
                    <td>${loc.idLocalidad}</td>
                    <td>${loc.nombreLocalidad}</td>
                    <td>${loc.entidad.nombreEntidad}</td>
                    <td>
                        <a href="../LocalidadEdit?id=${loc.idLocalidad}">Editar</a>
                        <a href="../LocalidadDelete?id=${loc.idLocalidad}&_METHOD=DELETE"
                    onclick="return confirm('¿Estas seguro de Eliminar el registro')">Borrar</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

