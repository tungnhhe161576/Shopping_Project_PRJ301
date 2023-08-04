/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mvcController;

import DAO.DAOProduct;
import Entities.Product;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.Vector;

@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAO.DAOProduct dao = new DAOProduct();
            String service = request.getParameter("service");
            
            if(service == null){
                service = "display";
            }
            
            if(service.equals("display")){
                int endP = dao.getEndPage("select * from products");
                String index = request.getParameter("index");
                if (index == null) {
                    index = "1";
                }
                int indexP = Integer.parseInt(index);
                String href = "HomeController?service=display";
                String sql = "select * from products order by product_id offset " + ((indexP - 1) * 12) + " rows fetch next 12 rows only";
                request.setAttribute("endP", endP);
                request.setAttribute("indexP", indexP);
                request.setAttribute("href", href);
                
                Vector<Product> vector = dao.getAll(sql);
                request.setAttribute("listProduct", vector);
                ResultSet rsCategory = dao.getData("select distinct  category_name from products");
                request.setAttribute("rsCategory", rsCategory);
                request.getRequestDispatcher("/jspClient/HomePage.jsp").forward(request, response);
            }
            
            if(service.equals("desc")){
                Vector<Product> vector = dao.getAll("select * from products order by list_price desc");
                request.setAttribute("listProduct", vector);
                ResultSet rsCategory = dao.getData("select distinct  category_name from products");
                request.setAttribute("rsCategory", rsCategory);
                request.getRequestDispatcher("/jspClient/HomePage.jsp").forward(request, response);
            }
            if(service.equals("asc")){
                Vector<Product> vector = dao.getAll("select * from products order by list_price asc");
                request.setAttribute("listProduct", vector);
                ResultSet rsCategory = dao.getData("select distinct  category_name from products");
                request.setAttribute("rsCategory", rsCategory);
                request.getRequestDispatcher("/jspClient/HomePage.jsp").forward(request, response);
            }
            
            if (service.equals("displayCategory")) {
                String cname = request.getParameter("cname");
                int endP = dao.getEndPage("select * from products where category_name like '" + cname + "'");
                String index = request.getParameter("index");
                if (index == null) {
                    index = "1";
                }
                int indexP = Integer.parseInt(index);
                String href = "HomeController?service=displayCategory&cname=" + cname;
                request.setAttribute("endP", endP);
                request.setAttribute("indexP", indexP);
                request.setAttribute("href", href);
                String sql = "select * from products where category_name like '" + cname + "' order by product_id offset " + ((indexP - 1) * 12) + " rows fetch next 12 rows only";
               
                Vector<Product> vector = dao.getAll(sql);
                request.setAttribute("listProduct", vector);
                ResultSet rsCategory = dao.getData("select distinct  category_name from products");
                request.setAttribute("rsCategory", rsCategory);
                request.getRequestDispatcher("/jspClient/HomePage.jsp").forward(request, response);
            }
            
            if(service.equals("details")){
                int product_id = Integer.parseInt(request.getParameter("id"));
                Vector<Product> vector = dao.getAll("select * from products where product_id = " + product_id);
                request.setAttribute("detail", vector);
                request.getRequestDispatcher("/jspClient/Detail.jsp").forward(request, response);
            }
            
            
            if (service.equals("searchPrice")) {
                String sql = "";
                int from = Integer.parseInt(request.getParameter("from"));
                int to = Integer.parseInt(request.getParameter("to"));
                if (from != 0 && to == 0) {
                    sql = "select * from Products where list_price <=" + from;
                } else if (from != 0 && to != 0) {
                    sql = "select * from Products where list_price between " + from + " and " + to;
                } else {
                    sql = "select * from Products where list_price >=" + from;
                }
                Vector<Product> vector = dao.getAll(sql);
                ResultSet rsCategory = dao.getData("select distinct category_name from products");
                request.setAttribute("listProduct", vector);
                request.setAttribute("rsCategory", rsCategory);
                request.getRequestDispatcher("/jspClient/HomePage.jsp").forward(request, response);
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
