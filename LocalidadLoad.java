/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mrysi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mrysi.Beans.EntidadDAOImp;
import mrysi.Beans.Localidad;
import mrysi.Beans.localidadDAOImp;

/**
 *
 * @author tibur
 */
@WebServlet(name = "LocalidadLoad", urlPatterns = {"/LocalidadLoad"})
public class LocalidadLoad extends HttpServlet {
private localidadDAOImp ldi;
private EntidadDAOImp edi;

public void init() throws ServletException{
    String host = getServletContext().getInitParameter("LocalidadLoad");
    ldi = new localidadDAOImp();
    edi = new EntidadDAOImp();
    super.init();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{
    try{
        request.setAttribute("ListaLocalidades",ldi.readAll());
        request.setAttribute("ListaEntidades",edi.readAll());
    }catch (SQLException ex){
        getServletContext().setAttribute("Err",ex);
        response.sendRedirect("Err.jsp");
    }
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
    if(esValido(request)){
        String name = request.getParameter("nombreLocalidad").toUpperCase().trim();
        int idEntidad = Integer.valueOf(request.getParameter("idEntidad"));
        try{
            ldi.insert(new Localidad(0,name,idEntidad));
        }catch(SQLException ex){
            getServletContext().setAttribute("Err",ex);
            response.sendRedirect("Err.jsp");
        }
        response.sendRedirect("Localidades/index.jsp");
    }else{
        getServletContext().setAttribute("msj","No se pudo guardar"
        +"registro,debido a que"
        +"uno de los campos no es válido.");
        response.sendRedirect("Localidades/new.jsp");
    }
}

    private boolean esValido(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
