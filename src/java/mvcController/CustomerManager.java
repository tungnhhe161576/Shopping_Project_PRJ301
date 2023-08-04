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


@WebServlet(name = "CustomerManager", urlPatterns = {"/CustomerManager"})
public class CustomerManager extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAOCustomer dao = new DAOCustomer();
            
            String service = request.getParameter("service");
            
            if(service == null){
                service = "display";
            }
            
            if(service.equals("display")){
                Vector<Customer> vector = dao.getAll();
                request.setAttribute("listCustomer", vector);
                request.getRequestDispatcher("/jspAdmin/ManagerCustomer.jsp").forward(request, response);
            }
            
            if(service.equals("update")){
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int customer_id = Integer.parseInt(request.getParameter("id"));
                    Vector<Customer> vector = dao.getAll("select * from customers where customer_id = " + customer_id);
                    Customer cus = vector.get(0);
                    request.setAttribute("cus", cus);
                    request.setAttribute("listCustomer", vector);
                    dispath(request, response, "/jspAdmin/UpdateCustomer.jsp");
                } else {
                    int customer_id = Integer.parseInt(request.getParameter("customer_id")),
                            status = Integer.parseInt(request.getParameter("status"));
                    String first_name = request.getParameter("first_name"),
                            last_name = request.getParameter("last_name"),
                            phone = request.getParameter("phone"),
                            email = request.getParameter("email"),
                            street = request.getParameter("street"),
                            city = request.getParameter("city"),
                            state = request.getParameter("state"),
                            zip_code = request.getParameter("zip_code");

                    int n = dao.updateCustomerByPre(new Customer(customer_id, first_name, last_name,
                            phone, email, street, city, state, zip_code, status));
                    response.sendRedirect("CustomerManager");
                }
            }
            
            if(service.equals("delete")){
                int customer_id = Integer.parseInt(request.getParameter("id"));
                int n = dao.removeCustomer(customer_id);
                response.sendRedirect("CustomerManager");
            }
            
            if(service.equals("search")){
                HttpSession session = request.getSession();
                request.setCharacterEncoding("UTF-8");

                String searchName = request.getParameter("customer_name");
                request.setAttribute("textC", searchName);
                Vector<Customer> vector = dao.search(searchName);
                
                request.setAttribute("listCustomer", vector);
                request.getRequestDispatcher("/jspAdmin/ManagerCustomer.jsp").forward(request, response);
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
