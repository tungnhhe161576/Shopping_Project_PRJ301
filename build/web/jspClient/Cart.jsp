<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entities.Item"%>
<%@page import="Entities.Product"%>
<%@page import="java.text.DecimalFormat"%>

<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            .table tbody td{
                vertical-align: middle;
            }
            .btn-incre, .btn-decre{
                box-shadow: none;
                font-size: 25px;
            }
        </style>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                java.util.Enumeration em = session.getAttributeNames();
                DecimalFormat dcf = new DecimalFormat("#,###.00");
                double total = 0;
            %>
            <div class="d-flex py-3">
                <h3> List Shopping </h3> 
            </div>

            <form action="Cart" method="post">
                <input type="hidden" value="update" name="service">
                <table class="table table-light">
                    <thead>
                        <tr>
                            <th scope="col">Sản phẩm</th>
                            <th scope="col">Tên sản phẩm</th>
                            <th scope="col">Category</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Giá tiền</th>
                            <th scope="col">Remove</th>
                        </tr>
                    </thead>

                    <tbody>
                        <%while(em.hasMoreElements()){
                            String id = (String) em.nextElement();
                            if(!id.equals("cus") && !id.equals("customer")) {
                                Item item = (Item) session.getAttribute(id);
                                total += item.getQuantity()*item.getProduct().getList_price();
                        %>
                        <tr>  
                            <td><img style="width: 20%" src="./images/phone.jpg"></td>
                            <td><%=item.getProduct().getProduct_name()%></td>
                            <td><%=item.getProduct().getCategory_name()%></td>
                            <td>
                                <input type="number" min="1" max="<%=item.getProduct().getQuantity()%>" name="quantity<%=id%>" value="<%=item.getQuantity()%>">
                            </td>
                            <td><%=(dcf.format((item.getQuantity()*item.getProduct().getList_price())))%>K</td>
                            <td><a href="Cart?service=remove&id=<%=id%>" class="btn btn-sm btn-danger">Remove</a></td>
                        </tr>
                        <%}
                        }%>
                    </tbody>


                </table>
                    <div>
                        <input style="margin-bottom: 20px" class="text-center btn btn-block btn-primary" type="submit" value="Update" name="Update cart">
                    </div>
            </form>
                    
            <div style="display: flex; justify-content: space-around">
                <p style="text-align: center; margin-top: 12px">
                    <%
                            if(session.getAttribute("cus") == null) {
                    %>
                        <div class="d-flex py-3"><h4>Total Price: <%=(dcf.format(total))%>  VND </h4> 
                            <a class="mx-3 btn btn-primary" href="Login?service=loginCustomer">Pay</a>
                        </div>
                        <div>
                            <a href="HomeController" class="text-dark"><i class="fas fa-long-arrow-alt-left"></i>Back to Home</a>
                        </div>
                    <%} else { %>
                        <div class="d-flex py-3"><h4>Total Price: <%=(dcf.format(total))%>  VND </h4> 
                            <a class="mx-3 btn btn-primary" href="Pay">Pay</a>
                        </div>
                        <div>
                            <a href="ForCustomerController" class="text-dark"><i class="fas fa-long-arrow-alt-left"></i>Back to Home</a>
                        </div>
                    <%}%>
                </p>
            </div>    
        </div>

                <footer class="bg-dark text-white" style="margin-top: 250px">
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
