

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOOrder"%>
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
        <title>Order Manager Page</title>
    </head>
    <body>
        <div class="header container bg-dark">
            <div class="row">
                    <a class="text-white text-center" href="ForAdmin">${sessionScope.staff}</a> 
            </div>
        </div>

        <div class="container">
            <div class="row"  style="padding-top: 15px; background-color: rgb(249, 242, 242)">
            <%ResultSet rsOrder = (ResultSet)request.getAttribute("rsOrder");%>
                <table class="table table-bordered  bg-white">
                    <thead>
                        <tr class="text-white bg-dark">
                            <th>Order ID</th>
                            <th>Customer Name</th>
                            <th>Product Name</th>
                            <th>Model Year</th>
                            <th>Category Name</th>
                            <th>Order Date</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Image</th>
                        </tr>
                    </thead>

                    <tbody>
                        <%while(rsOrder.next()) { %>
                        <tr>
                            <td> <%=rsOrder.getInt(1)%> </td>
                            <td> <%=rsOrder.getString(2)%> </td>
                            <td> <%=rsOrder.getString(3)%> </td>
                            <td> <%=rsOrder.getInt(4)%> </td>
                            <td> <%=rsOrder.getString(5)%> </td>
                            <td> <%=rsOrder.getString(6)%> </td>
                            <td> <%=rsOrder.getInt(7)%> </td>
                            <td> <%=rsOrder.getDouble(8)%> </td>
                            <td> <img src="./images/phone.jpg" alt="alt" width="50%"> </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="footer">
        </div>        
    </body>
</html>
