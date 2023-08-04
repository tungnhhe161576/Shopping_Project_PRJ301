

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOProduct"%>
<%@page import="Entities.Product"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/HeaderHome.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Customer Page</title>
    </head>
    <body  style="background-color: rgb(249, 242, 242)">
        <div class="intro" style="background-color: rgb(249, 242, 242)">
            <jsp:include page="IntroCustomer.jsp"></jsp:include>
            </div>

            <div class="header bg-dark container-fluit">
                <div class="row">
                    <div class="col-md-2 left text-white">
                        <a href="ForCustomerController?service=display">Home</a>
                        <a href="OrderDetail?service=orderOfCustomer"><strong>${sessionScope.customer}</strong></a>
                </div>
                <div class="search col-md-8">
                    <form action="Search" method="post">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Search</span>
                            </div>
                            <input value="${text}" type="text" class="form-control" placeholder="Search in website" name="product_name">
                        </div>
                    </form>
                </div>
                <div class="col-md-2 right" style="float: right"><a href="Logout">Log Out</a> 
                    <a href="ShowCart">Cart</a>
                </div>
            </div>
        </div>



        <div class="container body">
            <div class="row" style="padding-top: 15px;">
                <div class="col-md-3 category">
                    <%ResultSet rs = (ResultSet)request.getAttribute("rsCategory");%>
                    <table class="table table-hover table-bordered  bg-white">
                        <thead class="text-white bg-dark">
                            <tr><th>Category Menu</th></tr>
                        </thead>
                        <tbody>
                            <% while(rs.next()) {%>
                            <tr>
                                <td><a  href="ForCustomerController?service=displayCategory&cname=<%=rs.getString(1)%>"><%=rs.getString(1)%></a></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>

                    <table class="table table-hover table-bordered  bg-white">
                        <thead class="text-white bg-dark text-center">
                            <tr>
                                <th>Giá</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <ul style="list-style: none" class="bor">
                                        <li style="margin-bottom: 10px"><a href="HomeController?service=searchPrice&from=300&to=0">Dưới 300K</a></li>
                                        <li style="margin-bottom: 10px"><a href="HomeController?service=searchPrice&from=300&to=500">Từ 300K đến 500K</a></li>
                                        <li><a href="HomeController?service=searchPrice&from=500&to=1000">Từ 500K đến 1000K</a></li>
                                    </ul>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-9 product">
                    <div class="row">
                        <%Vector<Product> vector = (Vector<Product>)request.getAttribute("listProduct");%>
                        <%for (Product o : vector){%>
                        <div class="col-md-3">                
                            <div class="product-item border-0 mb-4 bg-white">
                                <div class="product-img position-relative overflow-hidden bg-transparent border p-0">
                                    <img class="img-fluid w-100" src="./images/phone.jpg" alt="alt" width="50%">
                                </div>
                                <div class="border-left border-right text-center p-0 pt-4 pb-3">
                                    <h6 class="text-truncate mb-3"><%=o.getProduct_name()%></h6>
                                    <div class="d-flex justify-content-center">
                                        <h6 class="text-danger"><%= o.getList_price()%> VND</h6>
                                    </div>
                                </div>
                                <div class="card-footer d-flex justify-content-between bg-light border">
                                    <a href="HomeController?service=details&id=<%=o.getProduct_id()%>" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                    <a href="Cart?service=addToCart&id=<%=o.getProduct_id()%>" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                                </div>
                            </div>                  
                        </div>
                        <%}%>
                    </div>
                </div>        
            </div>
        </div>

        <%
            int endP = (int)request.getAttribute("endP");
            int indexP = (int)request.getAttribute("indexP");
            String href = (String)request.getAttribute("href");
        %>
        <p class="paging text-center" style="margin: 20px 0 20px 0">
            <a href="<%=href%>&index=<%=(indexP-1)%>" style="<%=indexP > 1 && indexP <= endP ? "display: inline-block" : "display: none"%>"> 
                <i class="fas fa-chevron-left btn_prev"></i>
            </a>

            <%for(int i = 1; i <= endP; i++) {%>
            <a class="paging_link <%=indexP == i ? "active" : ""%>" href="<%=href%>&index=<%=i%>"><%=i%></a>
            <%}%>

            <a href="<%=href%>&index=<%=(indexP+1)%>" style="<%=indexP < endP && indexP >= 1 ? "display: inline-block" : "display: none"%>"> 
                <i class="fas fa-chevron-right btn_next"></i>
            </a>
        </p>    


        <footer class="bg-white">
            <div class="container-fluit">
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
