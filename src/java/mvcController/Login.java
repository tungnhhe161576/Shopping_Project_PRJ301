/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mvcController;

import DAO.DAOCustomer;
import DAO.DAOStaffs;
import Entities.Customer;
import Entities.Staffs;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAOCustomer dao = new DAOCustomer();
            DAOStaffs daoS = new DAOStaffs();
            String service = request.getParameter("service");
            HttpSession session = request.getSession();

            if (service.equals("loginCustomer")) {
                String submit = request.getParameter("submit");
                if(submit == null){
                    request.getRequestDispatcher("/jspClient/Login.jsp").forward(request, response);
                } else {
                    String username = request.getParameter("email");
                    String password = request.getParameter("phone");
                    Customer cus = dao.Login(username, password);
                    if (cus != null) {
                        session.setAttribute("cus", cus);
                        session.setAttribute("customer", cus.getFirst_name() + " " + cus.getLast_name());
                        response.sendRedirect("ForCustomerController");
                    } else {
                        request.setAttribute("massage", "Wrong user or password !!");
                        request.getRequestDispatcher("/jspClient/Login.jsp").forward(request, response);
                    }
                }
            }
            
            if(service.equals("loginStaff")){
               String submit = request.getParameter("submit");
                if(submit == null){
                    request.getRequestDispatcher("/jspClient/LoginStaff.jsp").forward(request, response);
                } else {
                    String username = request.getParameter("email");
                    String password = request.getParameter("phone");
                    Staffs staff = daoS.Login(username, password);
                    if (staff != null) {
                        session.setAttribute("sta", staff);
                        session.setAttribute("staff", staff.getFirst_name() + " " + staff.getLast_name());
                        response.sendRedirect("ForAdmin");
                    } else {
                        request.setAttribute("massage", "Wrong user or password !!");
                        request.getRequestDispatcher("/jspClient/LoginStaff.jsp").forward(request, response);
                    }
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
