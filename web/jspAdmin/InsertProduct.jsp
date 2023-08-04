<%-- 
    Document   : InsertProduct
    Created on : Feb 20, 2023, 12:12:08 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOProduct"%>
<%@page import="Entities.Product"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ProductManager" method="post">
            <input type="hidden" name="service" value="insert">
            
            <table>
                <tr>
                    <td> <label for="product_id">product_id</label></td>
                    <td> <input type="text" name="product_id" id="product_id"></td>
                </tr>
                <tr>
                    <td> <label for="product_name">product_name</label></td>
                    <td> <input type="text" name="product_name" id="product_name"></td>
                </tr>
                <tr>
                    <td> <label for="image">image</label></td>
                    <td> <input type="text" name="image" id="image"></td>
                </tr>
                <tr>
                    <td> <label for="model_year">model_year</label></td>
                    <td> <input type="number" name="model_year" id="model_year"></td>
                </tr>
                <tr>
                    <td> <label for="list_price">list_price</label></td>
                    <td> <input type="number" name="list_price" id="list_price"></td>
                </tr>
                <tr>
                    <td> <label for="brand_name">brand_name</label></td>
                    <td> <input type="text" name="brand_name" id="brand_name"></td>
                </tr>
                <tr>
                    <td> <label for="category_name">category_name</label></td>
                    <td> <input type="text" name="category_name" id="category_name"></td>
                </tr>

                <tr>
                    <td> <input type="submit" value="add Product" name="submit"></td>
                    <td> <input type="reset" value="reset"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
