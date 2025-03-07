<%-- 
    Document   : new
    Created on : 23 jun 2024, 21:56:15
    Author     : tibur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.getRequestDispatcher("/LocalidadLoad").include(request, response);
    if(request.getAttribute("ListaEntidades")== null){
    response.sendRedirect("index.jsp");
    }
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Localidad</title>
    </head>
    <body>
        <h2>Agregar Localidad</h2>
        <form action="../LocalidadLoad" method="POST">
            Nombre: <input type ="text" name="nombreLocalidad" value=""/><br/>
            Entidad:
            <select name="idEntidad">
                <c:forEach var="entidad" items="${requestScope.ListaEntidades}">
                    <option value="${entidad.idEntidad}">
                        ${entidad.nombreEntidad}
                    </option>
                </c:forEach>
            </select>
                    
                    <p>
                        <input type="submit" value="Guardar"/>
                        <input type="button" value="Cancelar" onclick="window.history.back();"/>
                    </p>
        </form>
    </body>
</html>
