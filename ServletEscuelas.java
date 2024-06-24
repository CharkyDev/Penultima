package mrysi.servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mrysi.Beans.Escuelas;

/**
 *
 * @author tibur
 */
@WebServlet(urlPatterns = {"/ServletEscuelas"})
public class ServletEscuelas extends HttpServlet {

    Connection connect;
    Statement statement;
    ResultSet resultSet;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String URL ="jdbc:mysql://localhost/EscuelasDB?user=root&password=root";
            
            connect = DriverManager.getConnection(URL);
            statement =  connect.createStatement();
            
            request.setAttribute("ListaEscuelas", getListaEscuelas());
            
            connect.close();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }
    }
    public List<Escuelas> getListaEscuelas() throws SQLException{
        String query = "SELECT * from Escuelas";
        resultSet = statement.executeQuery(query);
        
        List<Escuelas> Escuelas = new ArrayList();
        Escuelas escuela;
        while(resultSet.next()){
            escuela = new Escuelas();
            escuela.setClaveEscuela(resultSet.getString(1));
            escuela.setNombreEscuela(resultSet.getString(2));
            escuela.setDomicilio(resultSet.getString(3));
            escuela.setCodigoPostal(resultSet.getInt(4));
            escuela.setTurno(resultSet.getString(5));
            escuela.setIdLocalidad(resultSet.getInt(6));
            Escuelas.add(escuela);
        }
        return Escuelas;
    }
}
