<%-- 
    Document   : InsertCustomer
    Created on : Mar 3, 2023, 1:26:11 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCustomer"%>
<%@page import="Entities.Customer"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" href="./css/HeaderHome.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>

        <div class="container">
            <div>
                <h5>Register For Customer</h5>
            </div>
            <form action="Register" method="post">
                <table class="table-light">
                    <tr>
                        <td><label for="status">Status</label></td>
                        <td><input type="number" name="status" id="status" placeholder="Status" required=""></td>
                    </tr>

                    <tr>
                        <td><label for="first_name">First Name</label></td>
                        <td><input type="text" name="first_name" id="first_name" placeholder="First Name" required=""></td>
                    </tr>
                    <tr>
                        <td><label for="last_name">Last Name</label></td>
                        <td><input type="last_name" name="last_name" id="last_name" placeholder="Last Name"required=""></td>
                    </tr>
                    <tr>
                        <td><label for="phone">Phone Number</label></td>
                        <td><input type="phone" name="phone" id="phone" placeholder="Phone Numer" required=""></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email</label></td> 
                        <td><input type="email" name="email" id="email" placeholder="Email" required=""></td>
                        <td>${emailExist}</td>
                    </tr>
                    <tr>
                        <td><label for="street">Street</label></td>
                        <td><input type="text" name="street" id="street" placeholder="Street" required=""> </td>
                    </tr>
                    <tr>
                        <td><label for="city">City</label></td>
                        <td><input type="text" name="city" id="city" placeholder="City" required=""> </td>
                    </tr>
                    <tr>
                        <td><label for="state">State</label></td>
                        <td><input type="text" name="state" id="state" placeholder="State" required=""> </td>
                    </tr>
                    <tr>
                        <td><label for="zip_code">Zip Code</label></td>
                        <td><input type="text" name="zip_code" id="zip_code" placeholder="Your Code" required=""> </td>
                    </tr>

                    <tr class="text-center">
                        <td></td>
                        <td><input type="submit" value="Register" name="submit"></td>
                    </tr>
                </table>
        </div>
    </body>
</html>
