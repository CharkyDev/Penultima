/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mrysi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tibur
 */
@WebServlet(name = "ConexionMYSQL", urlPatterns = {"/ConexionMYSQL"})
public class ConexionMySQL extends HttpServlet {
    private Connection conn;
    private String bd;
    private String host;
    private String port;
public ConexionMySQL(){
    bd = "EscuelasDB";
    host = "localhost";
    port = "3036";
    conn = null;
}
private boolean setDriver(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        return true;
    }catch (ClassNotFoundException ex){
        return false;
    }
  }
public Connection getConnection() throws SQLException{
    if(setDriver()){
        String URL = "jdc:mysql://"+host+":"+port+"/"+bd;
        conn = DriverManager.getConnection(URL,"usersql","stan");
    }
    return conn;
}
}
