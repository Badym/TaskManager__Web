package pl.pols.lab.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import pl.polsl.lab.model.Client;
import pl.polsl.lab.model.SingletonModel;

@WebServlet("/people")
public class PeopleServlet extends HttpServlet {

    @Override
    public void init() {
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        response.setContentType("text/html;charset=UTF-8");
        
        String firstName = request.getParameter("firstName");
        boolean showAll = firstName == null || firstName.length() == 0;
        
        PrintWriter out = response.getWriter();        
        for(Client client : SingletonModel.getInstance().getClientList()){
            if(showAll || client.getStudentName().contains(firstName)){
                out.println("<tr>");
                out.println("<td>");
                out.println("<input type=\"text\" id=\"studentName\" name=\"studentName\" placeholder=\"Student name\" value=\""+ client.getStudentName() + "\"/>");
                out.println("</td>");
                out.println("<td>");
                out.println("<input type=\"text\" id=\"parentName\" name=\"parentName\" placeholder=\"Parent name\" value=\""+ client.getParentName() + "\"/>");
                out.println("</td>");
                out.println("<td>");
                out.println("<input type=\"text\" id=\"phoneNumber\" name=\"phoneNumber\" placeholder=\"Phone number\" value=\""+ client.getPhoneNumber() + "\"/>");
                out.println("</td>");
                out.println("<td>");
                out.println("<input type=\"text\" id=\"description\" name=\"description\" placeholder=\"Description\" value=\""+ client.getDescription() + "\"/>");
                out.println("</td>");
                
                out.println("<td>");
                out.println("<input type=\"button\" value=\"Uaktualnij\" onclick=\"updatePerson(" + client.getClientId() + ",'studentName','parentName','phoneNumber','description','tablePeopleId','errorInfo');\" />");
                out.println("</td>");
                out.println("<td>");
                out.println("<input type=\"button\" value=\"Usuń\" onclick=\"deletePerson(" + client.getClientId() + ", 'tablePeopleId','errorInfo');\" />");
                out.println("</td>");
                out.println("</tr>");
            }
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
