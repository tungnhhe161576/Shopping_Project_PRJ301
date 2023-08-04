/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mvcController;

import DAO.DAOCustomer;
import Entities.Customer;
import Entities.Product;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            DAOCustomer dao = new DAOCustomer();

            String submit = request.getParameter("submit");
            if (submit == null) {
                RequestDispatcher dispath = request.getRequestDispatcher("/jspClient/Register.jsp");
                dispath.forward(request, response);
            } else {
                Vector<Customer> vector = dao.getAll();
                    int    status = Integer.parseInt(request.getParameter("status"));
                String first_name = request.getParameter("first_name"),
                        last_name = request.getParameter("last_name"),
                        phone = request.getParameter("phone"),
                        email = request.getParameter("email"),
                        street = request.getParameter("street"),
                        city = request.getParameter("city"),
                        state = request.getParameter("state"),
                        zip_code = request.getParameter("zip_code");
                
                boolean checkEmail = true;
                for (Customer o : vector) {
                    if(o.getEmail().equals(email)){
                        checkEmail = false;
                    }
                }
                
                if(checkEmail){
                    int n = dao.addCustommerByPre(new Customer(vector.size()+1, first_name, last_name, phone, email, street, city, state, zip_code, status));
                    response.sendRedirect("HomeController");
                } else {
                    request.setAttribute("emailExist", "Email existed, please choose other email");
                    request.getRequestDispatcher("/jspClient/Register.jsp").forward(request, response);
                }
            }
        }
    }

    void dispath(HttpServletRequest request, HttpServletResponse response,
            String url)
            throws ServletException, IOException {
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
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
