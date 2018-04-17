/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfclient;

import entities.Contacts;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Andrew De Abreu Ruiz
 */
@WebServlet(name = "RestFulClientBDContactsServlet", urlPatterns = {"/RestFulClientBDContactsServlet"})
public class RestFulClientBDContactsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RestFulClientBDContacts rfclient = new RestFulClientBDContacts();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RestFulClientBDContactsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RestFulClientBDContactsServlet at " + request.getContextPath() + "</h1>");
            out.println("NUMBER OF CONTACTS: " + rfclient.countREST());

            Response resp = rfclient.findAll_XML(Response.class);
            GenericType<List<Contacts>> genericType = new GenericType<List<Contacts>>() {};
            List<Contacts> contactsList= resp.readEntity(genericType);
            out.println("<table>");
            out.println("<thead><tr><th>ID</th><th>NAME</th><th>TELEPHONE</th><th>MOBILE</th><th>EMAIL</th><th>DIRECTION</th></tr></thead>");
            out.println("<tbody>");
            for (Contacts c : contactsList) {
                out.println("<tr>");
                out.println("<td>" + c.getId() + "</td>" + "<td>" + c.getName() 
                        + "</td>" + "<td>" + c.getTelephone() + "</td>" 
                                + "<td>" + c.getTelephone() + "</td>" 
                                        + "<td>" + c.getMobile()+ "</td>" 
                                                + "<td>" + c.getEmail() 
                        + "</td>"+ "<td>" + c.getDirection()+ "</td>");               
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            }

        }
    



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



