<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCustomer"%>
<%@page import="Entities.Customer"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Manager Page</title>
    </head>
    <body>
        <%
            Vector<Customer> vector = (Vector<Customer>)request.getAttribute("listCustomer");
        %>

        <div class="header container bg-dark">
            <div class="row">
                <div class="home col-md-2"> 
                    <a class="text-white text-center" href="CustomerManager">Home</a> 
                </div>
                <div class="search col-md-7">
                    <form action="CustomerManager" method="post">
                        <input type="hidden" name="service" value="search">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Search</span>
                            </div>
                            <input value="${textC}" type="text" class="form-control" placeholder="Search in website" name="customer_name">
                        </div>
                    </form>
                </div>
                <div class="staff col-md-3"> 
                    <a class="text-white text-center" href="ForAdmin">${sessionScope.staff}</a> 
                </div>
            </div>
        </div>

        <div class="container-fluit" style="padding-top: 15px; background-color: rgb(249, 242, 242)">
            <table class="table table-bordered  bg-white">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Street</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zip Code</th>
                        <th>Status</th>
                        <th>Update</th>
                        <th>Delete</th>
                        <th>Order</th>
                    </tr>
                </thead>

                <tbody>
                    <%for (Customer o : vector) {%>
                    <tr>
                        <td> <%=o.getCustomer_id()%> </td>
                        <td> <%=o.getFirst_name()%> </td>
                        <td> <%=o.getLast_name()%> </td>
                        <td> <%=o.getPhone()%> </td>
                        <td> <%=o.getEmail()%> </td>
                        <td> <%=o.getStreet()%> </td>
                        <td> <%=o.getCity()%> </td>
                        <td> <%=o.getState()%> </td>
                        <td> <%=o.getZip_code()%> </td>
                        <td> <%=o.getStatus()%> </td>
                        <td> <a href="CustomerManager?service=update&id=<%=o.getCustomer_id()%>">Update</a> </td>
                        <td> <a href="CustomerManager?service=delete&id=<%=o.getCustomer_id()%>">Delete</a> </td>
                        <td> <a href="#">View Order</a> </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>   

        <div class="footer">
        </div>

    </body>
</html>
