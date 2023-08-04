/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mvcController;

import DAO.DAOOrder;
import Entities.Customer;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;

@WebServlet(name = "OrderDetail", urlPatterns = {"/OrderDetail"})
public class OrderDetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAOOrder dao = new DAOOrder();
            String service = request.getParameter("service");
            HttpSession session = request.getSession();
            Customer cus = (Customer) session.getAttribute("cus");
            if (service.equals("orderOfCustomer")) {
                ResultSet rsOrder = dao.getData("select p.product_name, p.category_name, p.brand_name, p.model_year, o.order_date, o.quantity, o.price  from [Order] as o \n"
                        + "join products as p on o.product_id = p.product_id where o.customer_id = " + cus.getCustomer_id());
                request.setAttribute("rsOrder", rsOrder);
                request.getRequestDispatcher("/jspClient/OrderByCustomer.jsp").forward(request, response);
            }

            if (service.equals("displayAll")) {
                ResultSet rsOrder = dao.getData("select o.order_id, c.first_name + ' ' + c.last_name, p.product_name, p.model_year, p.category_name, o.order_date, o.quantity, o.price  from [Order] as o \n"
                        + "join customers as c on c.customer_id = o.customer_id join products as p on p.product_id=o.product_id");
                request.setAttribute("rsOrder", rsOrder);
                request.getRequestDispatcher("/jspAdmin/ManagerOrder.jsp").forward(request, response);
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
