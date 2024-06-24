
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
import mrysi.Beans.localidadDAOImp;

/**
 *
 * @author tibur
 */
@WebServlet(name = "LocalidadEdit", urlPatterns = {"/LocalidadEdit"})
public class LocalidadEdit extends HttpServlet {
private localidadDAOImp ldi;
private EntidadDAOImp edi;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            if(request.getParameter("id")!= null){
                int id= Integer.parseInt(request.getParameter("id"));
                request.setAttribute("Localidad", ldi.read(id));
                request.setAttribute("ListaEntidades", edi.readAll());
                request.getRequestDispatcher("/Localidades/edit.jsp")
                        .forward(request,response);
            }
        }catch(SQLException ex){
            getServletContext().setAttribute("Err", ex);
            response.sendRedirect("Err.jsp");
        }
    }

}
