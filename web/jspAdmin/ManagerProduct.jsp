

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOProduct"%>
<%@page import="Entities.Product"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Manager Page</title>
    </head>
    <body>
        <div class="header container bg-dark">
            <div class="row">
                <div class="home col-md-2"> 
                    <a class="text-white text-center" href="ProductManager">Home</a> 
                </div>
                <div class="search col-md-6">
                        <form action="Search" method="post">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Search</span>
                                </div>
                            <input value="${text}" type="text" class="form-control" placeholder="Search in website" name="product_name">
                            </div>
                        </form>
                </div>
                <div class="staff col-md-2"> 
                    <a class="text-white text-center" href="ForAdmin">${sessionScope.staff}</a> 
                </div>
                <div class="insert col-md-2"> 
                    <a class="text-white text-center" href="ProductManager?service=insert">Insert Product</a> 
                </div>
            </div>
        </div>
        
        
        <div class="container">
            <div class="row"  style="padding-top: 15px; background-color: rgb(249, 242, 242)">
                <%ResultSet rs = (ResultSet)request.getAttribute("rsCategory");%>

                <div class="CategoryName col-md-3 text-center">
                    <table class="table table-hover table-bordered  bg-white">
                        <thead class="text-white bg-dark">
                            <tr><th>Category Menu</th></tr>
                        </thead>
                        <tbody>
                            <% while(rs.next()) {%>
                            <tr>
                                <td><a href="ProductManager?service=displayCategory&cname=<%=rs.getString(1)%>"><%=rs.getString(1)%></a></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>


                <div class="Product col-md-9 text-center">
                    <%Vector<Product> vector = (Vector<Product>)request.getAttribute("listProduct");%>
                    <table class="table table-bordered  bg-white">
                        <thead>
                            <tr class="text-white bg-dark">
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Model Year</th>
                                <th>List Price</th>
                                <th>Brand Name</th>
                                <th>Category Name</th>
                                <th>Quantity</th>
                                <th>Image</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>

                        <tbody>
                            <%for (Product o : vector) { %>
                            <tr>
                                <td> <%=o.getProduct_id()%> </td>
                                <td> <%=o.getProduct_name()%> </td>
                                <td> <%=o.getModel_year()%> </td>
                                <td> <%=o.getList_price()%> </td>
                                <td> <%=o.getBrand_name()%> </td>
                                <td> <%=o.getCategory_name()%> </td>
                                <td> <%=o.getQuantity()%> </td>
                                <td> <img src="./images/phone.jpg" alt="alt" width="100%"> </td>
                                <td> <a href="ProductManager?service=update&product_id=<%=o.getProduct_id()%>">Update</a> </td>
                                <td> <a href="ProductManager?service=delete&product_id=<%=o.getProduct_id()%>">Delete</a> </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
        <div class="footer">
        </div>
    </body>
</html>
