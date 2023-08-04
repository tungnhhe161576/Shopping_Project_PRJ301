/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mvcController;

import DAO.DAOCustomer;
import DAO.DAOProduct;
import Entities.Customer;
import Entities.Product;
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
import java.sql.ResultSet;
import java.util.Vector;

@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAOProduct dao = new DAOProduct();
            DAOCustomer daoC = new DAOCustomer();
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");
            
            String searchName = request.getParameter("product_name");
            request.setAttribute("text", searchName);
            Vector<Product> vector = dao.search(searchName);
            Customer cus = (Customer) session.getAttribute("cus");
            Staffs staff = (Staffs) session.getAttribute("sta");
            ResultSet rsCategory = dao.getData("select distinct category_name from products");
            if (cus == null && staff == null) {
                request.setAttribute("rsCategory", rsCategory);
                request.setAttribute("listProduct", vector);
                request.getRequestDispatcher("/jspClient/HomePage.jsp").forward(request, response);
            } else if (cus != null && staff == null) {
                request.setAttribute("rsCategory", rsCategory);
                request.setAttribute("listProduct", vector);
                request.getRequestDispatcher("/jspClient/ForCustomer.jsp").forward(request, response);
            } else if(cus == null && staff != null) {
                request.setAttribute("rsCategory", rsCategory);
                request.setAttribute("listProduct", vector);
                request.getRequestDispatcher("/jspAdmin/ManagerProduct.jsp").forward(request, response);
            }
        }
    }

    void dispath(HttpServletRequest request, HttpServletResponse response, String url)
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
