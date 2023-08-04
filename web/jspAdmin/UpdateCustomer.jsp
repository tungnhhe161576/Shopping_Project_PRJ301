

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCustomer"%>
<%@page import="Entities.Customer"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%Vector<Customer> vector = (Vector<Customer>)request.getAttribute("listCustomer");
        Customer cus = vector.get(0);%>
        
        <form action="CustomerManager" method="post">
            <input type="hidden" name="service" value="update">
            <table>
                <tr>
                    <td><label for="customer_id">customer_id</label></td>
                    <td><input type="text" name="customer_id" id="customer_id" 
                               value="<%=cus.getCustomer_id()%>"></td>
                </tr>
                <tr>
                    <td><label for="status">status</label></td>
                    <td><input type="text" name="status" id="status " 
                               value="<%=cus.getStatus()%>" readonly=""></td>
                </tr>
                <tr>
                    <td><label for="first_name">first_name</label></td>
                    <td><input type="text" name="first_name" id="first_name" 
                               value="<%=cus.getFirst_name()%>"></td>
                </tr>
                <tr>
                    <td><label for="last_name">last_name</label></td>
                    <td><input type="text" name="last_name" id="last_name" 
                               value="<%=cus.getLast_name()%>"></td>
                </tr>
                <tr>
                    <td><label for="phone">phone</label></td>
                    <td><input type="text" name="phone" id="phone" 
                               value="<%=cus.getPhone()%>"></td>
                </tr>
                <tr>
                    <td><label for="email">email</label></td>
                    <td><input type="text" name="email" id="email" 
                               value="<%=cus.getEmail()%>"></td>
                </tr>
                <tr>
                    <td><label for="street">street</label></td>
                    <td><input type="text" name="street" id="street"
                               value="<%=cus.getStreet()%>"></td>
                </tr>
                <tr>
                    <td><label for="city">city</label></td>
                    <td><input type="text" name="city" id="city"
                               value="<%=cus.getCity()%>"></td>
                </tr>
                <tr>
                    <td><label for="state">state</label></td>
                    <td><input type="text" name="state" id="state"
                               value="<%=cus.getState()%>"></td>
                </tr>
                <tr>
                    <td><label for="zip_code">zip_code</label></td>
                    <td><input type="text" name="zip_code" id="zip_code"
                               value="<%=cus.getZip_code()%>"></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="update Customer" name="submit"></td>
                    <td><input type="reset" value="reset"></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
