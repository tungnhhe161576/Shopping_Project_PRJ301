package mvcController;

import DAO.DAOProduct;
import DAO.DAOStaffs;
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

@WebServlet(urlPatterns = {"/ProductManager"})
public class ProductManager extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAOProduct dao = new DAOProduct();
            String service = request.getParameter("service");

            if (service == null) {
                service = "display";
            }
            
            if(service.equals("insert")){
                String submit = request.getParameter("submit");
                if (submit == null) {
                    RequestDispatcher dispath = request.getRequestDispatcher("/jspAdmin/InsertProduct.jsp");
                    dispath.forward(request, response);

                } else {
                    int product_id = Integer.parseInt(request.getParameter("product_id"));
                    String product_name = request.getParameter("product_name"),
                            image = request.getParameter("image");
                    int model_year = Integer.parseInt(request.getParameter("model_year"));
                    double list_price = Double.parseDouble(request.getParameter("list_price"));
                    String brand_name = request.getParameter("brand_name"),
                            category_name = request.getParameter("category_name");

                    Product pro = new Product(product_id, product_name, image,
                            model_year, list_price, brand_name, category_name);

                    int n = dao.addProduct(pro);
                    response.sendRedirect("ProductManager");
                }
            }

            if (service.equals("display")) {
                Vector<Product> vector = dao.getAll();
                ResultSet rsCategory = dao.getData("select distinct category_name from products");
                request.setAttribute("listProduct", vector);
                request.setAttribute("rsCategory", rsCategory);
                request.getRequestDispatcher("/jspAdmin/ManagerProduct.jsp").forward(request, response);
            }

            if (service.equals("displayCategory")) {
                String cname = request.getParameter("cname");
                Vector<Product> vector = dao.getAll("select * from products where category_name = '" + cname + "'");
                ResultSet rsCategory = dao.getData("select distinct  category_name from products");
                request.setAttribute("listProduct", vector);
                request.setAttribute("rsCategory", rsCategory);
                request.getRequestDispatcher("/jspAdmin/ManagerProduct.jsp").forward(request, response);
            }
            
            if(service.equals("update")){
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int product_id = Integer.parseInt(request.getParameter("product_id"));
                    Vector<Product> vector = dao.getAll("select * from products where product_id = " + product_id);
                    Product pro = vector.get(0);
                    request.setAttribute("pro", pro);
                    request.setAttribute("listProduct", vector);
                    dispath(request, response, "/jspAdmin/UpdateProduct.jsp");
                } else {
                    int product_id = Integer.parseInt(request.getParameter("product_id"));
                    String product_name = request.getParameter("product_name"),
                            image = request.getParameter("image");
                    int model_year = Integer.parseInt(request.getParameter("model_year"));;
                    double list_price = Double.parseDouble(request.getParameter("list_price"));
                    String brand_name = request.getParameter("brand_name"),
                            category_name = request.getParameter("category_name");
                    Product proUpdate = new Product(product_id, product_name, image, model_year,
                            list_price, brand_name, category_name);

                    int n = dao.updateProduct(proUpdate);
                    response.sendRedirect("ProductManager");
                }
            }
            
            if(service.equals("delete")){
                int product_id = Integer.parseInt(request.getParameter("product_id"));
                int n = dao.removeProduct(product_id);
                response.sendRedirect("ProductManager");
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
