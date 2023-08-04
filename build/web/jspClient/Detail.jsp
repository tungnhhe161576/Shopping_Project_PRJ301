<%-- 
    Document   : Detail
    Created on : Mar 15, 2023, 12:35:40 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOProduct"%>
<%@page import="Entities.Product"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Detail Page</title>
    </head>
    <body>

        <div class="header bg-dark text-white" style="height: 30px; margin-bottom: 50px">
                <div> <a class="text-white" href="HomeController?service=display">Home</a> </div>
        </div>


        <div class="container">
            <form action="HomeController" method="post">
                <input type="hidden" name="service" value="details">

                <%Vector<Product> vector = (Vector<Product>)request.getAttribute("detail");%>
                <%for (Product o : vector){%>
                <div class="row" style="border: 1px solid">
                    <div class="col-md-5">                
                        <div class="">
                            <img class="" src="./images/phone.jpg" alt="alt" width="">
                        </div>
                    </div>
                    
                    <div class="col-md-7">
                        <div class="">
                            <h3> <strong><%=o.getProduct_name()%> </strong></h3>
                            <br>
                            <br>
                            <div> 
                                <h5> <strong class="text-danger"> Category: </strong> <%=o.getCategory_name()%> </h5>
                            </div>
                            <div> 
                                <h5> <strong class="text-danger"> Brand: </strong> <%=o.getBrand_name()%>  </h5>
                            </div>
                            <div> 
                                <h5> <strong class="text-danger"> Quantity:  </strong> <%=o.getQuantity()%>  </h5>
                            </div>
                            <div> 
                                <h5> <strong class="text-danger"> Model Year </strong> <%=o.getModel_year()%>  </h5>
                            </div>
                            <div>
                                <h5> <strong class="text-danger"> Price: </strong> <%= o.getList_price()%> VND</h5>
                            </div>
                            <div> 
                                <a href="Cart?service=addToCart&id=<%=o.getProduct_id()%>" class="btn btn--block btn-danger text-white">Add To Cart</a>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
            </form>
        </div>

        <footer class="bg-dark text-white" style="margin-top: 250px">
              <div class="container">
                <div class="row">
                  <div class="col-md-6">
                    <h3>Liên hệ</h3>
                    <p>Email: info@vidu.com</p>
                    <p>Số điện thoại: 0123456789</p>
                  </div>
                  <div class="col-md-6">
                    <h3>Liên kết</h3>
                    <ul>
                      <li><a href="#">Giới thiệu</a></li>
                      <li><a href="#">Chính sách bảo mật</a></li>
                      <li><a href="#">Điều khoản sử dụng</a></li>
                    </ul>
                  </div>
                </div>
                <hr>
                <p>&copy; 2023 Trang web Ví dụ. Bản quyền thuộc về chủ sở hữu.</p>
              </div>
        </footer>
    </body>
</html>
