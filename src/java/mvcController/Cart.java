/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mvcController;

import java.text.DecimalFormat;
import DAO.DAOProduct;
import Entities.Customer;
import Entities.Item;
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

@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAOProduct daoP = new DAOProduct();
            HttpSession session = request.getSession();
            String service = request.getParameter("service");

            if (service.equals("addToCart")) {
                String key = request.getParameter("id");
                int product_id = Integer.parseInt(key);
                Vector<Product> vector = daoP.getAll("select * from products where product_id = " + product_id);
                Product pro = vector.get(0);
                Item item = (Item) session.getAttribute(key);

                if (item == null) {
                    item = new Item();
                    item.setQuantity(1);
                    item.setProduct(pro);
                    session.setAttribute(key, item);
                } else {
                    item.setQuantity(item.getQuantity() + 1);
                    session.setAttribute(key, item);
                }

                Customer cus = (Customer) session.getAttribute("cus");
                if (cus == null) {
                    response.sendRedirect("HomeController");
                } else {
                    response.sendRedirect("ForCustomerController");
                }
            }

            if (service.equals("remove")) {
                String key = request.getParameter("id");
                session.removeAttribute(key);
                response.sendRedirect("ShowCart");
            }

            if (service.equals("update")) {
                java.util.Enumeration em = session.getAttributeNames();
                while (em.hasMoreElements()) {
                    String id = (String) em.nextElement();
                    if (!id.equals("cus") && !id.equals("customer")) {
                        int quantity = Integer.parseInt(request.getParameter("quantity" + id));
                        Item item = (Item) session.getAttribute(id);
                        item.setQuantity(quantity);
                        session.setAttribute(id, item);
                    }
                }
                request.getRequestDispatcher("/jspClient/Cart.jsp").forward(request, response);
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
