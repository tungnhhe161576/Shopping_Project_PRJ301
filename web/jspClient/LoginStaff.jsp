<%-- 
    Document   : Login
    Created on : Mar 12, 2023, 4:14:10 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .simpleLogin form {
                max-width: 400px;
                margin: auto;
                background:#fefefd;
                box-shadow: 0 10px 10px #222;
            }
            .simpleLogin form fieldset {
                border: 0 none;
                margin: 0;
                padding: 20px;
            }
            .simpleLogin form legend,
            .simpleLogin form fieldset input {
                font-family: Open Sans;
                font-size:15px;
            }
            .simpleLogin form legend {
                background-color: #8fc400;
                border-top: 0 none;
                color: white;
                display: table-cell;
                padding: 10px 20px;
                width: auto;
            }

            .simpleLogin form fieldset input {
                width: 90%;
                margin: 10px 0;
                padding: 10px 5%;
                border: thin #8fc400 solid;
            }
            .simpleLogin input[type="submit"] {
                width: 100px;
                float: right;
                background: #8fc400;
                color: white;
                transition: .2s;
                border: 0;
                cursor:pointer;
            }
            .simpleLogin input[type="submit"]:focus,
            .simpleLogin input[type="submit"]:hover,
            .simpleLogin input[type="submit"]:active {
                padding: 10px 5%;
                background:#B3E226;
                outline: none;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="simpleLogin">
            <form action="Login" method="post">
                <input type="hidden" name="service" value="loginStaff">
                <legend>Let's Login</legend>
                <p class="text-danger" style="padding: 10px">${massage}</p>
                <fieldset>
                    <input id="name" placeholder="Username" type="text" name="email" required="">
                    <input id="pass" placeholder="Password" type="password" name="phone" required="">
                    <div> <a href="Login?service=loginCustomer" style="font-size: 12px">Login for Customer</a> </div>
                    <input type="submit" value="Log In" name="submit">
                </fieldset>
            </form>
        </div>   
    </body>
</html>
