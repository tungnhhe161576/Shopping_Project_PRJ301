
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
        <title>Admin Page</title>
    </head>
    <body>
        <div> 
            <h3>Hi ${sessionScope.staff}</h3> 
        </div>
        
        <div class="header" style="height: 50px">
            <div> <a class="" href="Logout">LogOut</a> </div>
        </div>

        <div class="manager bg-dark">
            <div> <a class="text-white" href="ProductManager"> Manager Product </a> </div>
            <div> <a class="text-white" href="CustomerManager"> Manager Customer </a> </div>
            <div> <a class="text-white" href="OrderDetail?service=displayAll"> Manager Order </a></div>
        </div>


        <div class="footer bg-dark" style="height: 150px">
        </div>          
    </body>
</html>
