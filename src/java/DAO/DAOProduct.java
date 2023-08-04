/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Entities.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.DBConnect;


public class DAOProduct extends DBConnect {
    public int addProduct(Product pro) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[products]\n"
                + "           ([product_id]\n"
                + "           ,[product_name]\n"
                + "           ,[model_year]\n"
                + "           ,[list_price]\n"
                + "           ,[brand_name]\n"
                + "           ,[category_name]\n"
                + "           ,[image])\n"
                + "     VALUES\n"
                + "           (" + pro.getProduct_id() + ",'" + pro.getProduct_name()
                + "'," + pro.getModel_year() + "," + pro.getList_price()
                + ",'" + pro.getBrand_name() + "','" + pro.getCategory_name()
                + "','" + pro.getImage() + "')";
        Statement state;
        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int addProductbyPre(Product pro) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[products]\n"
                + "           ([product_id]\n"
                + "           ,[product_name]\n"
                + "           ,[model_year]\n"
                + "           ,[list_price]\n"
                + "           ,[brand_name]\n"
                + "           ,[category_name]\n"
                + "           ,[image])\n"
                + "     VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //set paramater
            pre.setInt(1, pro.getProduct_id());
            pre.setString(2, pro.getProduct_name());
            pre.setInt(3, pro.getModel_year());
            pre.setDouble(4, pro.getList_price());
            pre.setString(5, pro.getBrand_name());
            pre.setString(6, pro.getCategory_name());
            pre.setString(7, pro.getImage());
//              pre.setDate(index?, value);
//              dataType is dayaType of field (table)
//              index: index of ? start 1
            n = pre.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }

        return n;
    }

    public int updateProduct(Product pro) {
        int n = 0;

        String sql = "UPDATE [dbo].[products]\n"
                + "   SET [product_name] = ?\n"
                + "      ,[model_year] = ?\n"
                + "      ,[list_price] = ?\n"
                + "      ,[brand_name] = ?\n"
                + "      ,[category_name] = ?\n"
                + "      ,[image] = ?\n"
                + " WHERE [product_id] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            
            pre.setString(1, pro.getProduct_name());
            pre.setInt(2, pro.getModel_year());
            pre.setDouble(3, pro.getList_price());
            pre.setString(4, pro.getBrand_name());
            pre.setString(5, pro.getCategory_name());
            pre.setString(6, pro.getImage());
            pre.setInt(7, pro.getProduct_id());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }


//    public void displayAll() {
//        String sql = "select * from products";
//
//        try {
//            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = state.executeQuery(sql);
//            //default: con trỏ bản ghi chỉ đi từ bản ghi đầu đến bản ghi cuối
//            //dữ liệu chỉ đọc
//            //SCROLL: con trỏ dịch theo 2 chiều; 
//            //SENSITIVE: threadSafe ghe sự thay đổi/tranh chấp trong quá trình đọc dữ liệu
//            //UPDATEABLE: cho phép thay đổi dữ liệu
//            while (rs.next()) {
////            dataType varName = rs.getDataType(fieldName|index);
////            dataType là kiểu dữ liệu của tên trường, index bắt đầu từ 1 (thứ tự cột)
//                int id = rs.getInt("product_id");
//                // int id = rs.getInt(1);
//                String name = rs.getString("product_name");
//                // String name = rs.getString(2);
//                int year = rs.getInt("model_year");
//                Double price = rs.getDouble("list_price");
//                String brandName = rs.getString("brand_name");
//                String categoryName = rs.getString("category_name");
//                String image = rs.getString("image");
//                //create object
//
//                Product pro = new Product(id, name, image, year, price, brandName, categoryName);
//                System.out.println(pro);
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }

    public Vector<Product> getAll() {
        Vector<Product> vector = new Vector<Product>();
        String sql = "select * from products";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) {
//            dataType varName = rs.getDataType(fieldName|index);
//            dataType là kiểu dữ liệu của tên trường, index bắt đầu từ 1 (thứ tự cột)
                int id = rs.getInt("product_id");
                // int id = rs.getInt(1);
                String name = rs.getString("product_name");
                int year = rs.getInt("model_year");
                Double price = rs.getDouble("list_price");
                String brandName = rs.getString("brand_name");
                String categoryName = rs.getString("category_name");
                String image = rs.getString("image");
                int quantity = rs.getInt("quantity");
                //create object

                Product pro = new Product(id, name, image, year, price, brandName, categoryName, quantity);
                
                vector.add(pro);
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return vector;
    }
    
    public Vector<Product> getAll(String sql) {
        Vector<Product> vector = new Vector<Product>();
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int year = rs.getInt("model_year");
                Double price = rs.getDouble("list_price");
                String brandName = rs.getString("brand_name");
                String categoryName = rs.getString("category_name");
                String image = rs.getString("image");
                int quantity = rs.getInt("quantity");
                Product pro = new Product(id, name, image, year, price, brandName, categoryName, quantity);
                vector.add(pro);
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return vector;
    }
    
//    public Vector<Product> paging(int index) {
//        Vector<Product> vector = new Vector<Product>();
//        ResultSet rs = this.getData(sql);
//        try {
//            while (rs.next()) {
//                int id = rs.getInt("product_id");
//                String name = rs.getString("product_name");
//                int year = rs.getInt("model_year");
//                Double price = rs.getDouble("list_price");
//                String brandName = rs.getString("brand_name");
//                String categoryName = rs.getString("category_name");
//                String image = rs.getString("image");
//
//                Product pro = new Product(id, name, image, year, price, brandName, categoryName);
//                vector.add(pro);
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return vector;
//    }

    public int removeProduct(int id) {
        int n = 0;
        String sql = "delete from Products where product_id = " + id;
        try {
            Statement state = conn.createStatement();
            ResultSet rs1 = this.getData("select * from Stocks where Product_id = " + id);
            ResultSet rs2 = this.getData("select * from order_items where Product_id = " + id);
            if (rs1.next() || rs2.next()) {
                n = -1; 
                //-1 nghĩa là vi phạm toàn vẹn khóa ngoại
            } else {
                n = state.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public Vector<Product> search(String searchName){
        Vector<Product> vector = new Vector<>();
        String sql = "select * from products where product_name like ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,"%"+searchName+"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                vector.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), 
                        rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    
    public Vector<Product> searchByPrice(int from, int to){
        Vector<Product> vector = new Vector<>();
        String sql = "select * from products where list_price between ? and ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, from);
            pre.setInt(1, to);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                vector.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), 
                        rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public int updateQuantity(Product pro, int quantity) {
        int n = 0;
        String sql = "update products set quantity = " + (pro.getQuantity() - quantity) + " where product_id = " + pro.getProduct_id();

        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return n;
    }
    
    public int getEndPage(String sql) {
        int endPage = 0;
        Vector<Product> vector = getAll(sql);
        endPage = vector.size()/12;
        if(vector.size() % 12 != 0) {
            endPage++;
        }
        return endPage;
    }
    
    
    
    public static void main(String[] args) {
        DAOProduct dao = new DAOProduct();
//        int n = dao.addProduct(new Product(1000, "iphone", "no image", 2023,
//                100, "apple", "mobile"));
//        if (n > 0) {
//            System.out.println("inserted");
//        }
//        int n = dao.addProductbyPre(new Product(203, "...", "no image", 2023,
//                100, "...", "..."));
//        if (n > 0) {
//            System.out.println("Inserted");
//        }

//        int n = dao.updateProduct(new Product(202, "MT", "MayTInh", 2023,
//                100, "apple", "mobile"));
//        if (n > 0) {
//            System.out.println("updated");
//        }


//        dao.displayAll();
//        Vector<Product> list = dao.getAll();
//        for (Product item : list) {
//            System.out.print(item.toString() + " ");
//        }

//        int n = dao.removeProduct(205);

//        Vector<Product> list = dao.search("Electra");
//        for (Product o : list) {
//            System.out.println(o);
//        }

//        Vector<Product> vector = dao.searchByPrice(400, 500);
//        for (Product o : vector) {
//            System.out.println(o);
//        }

    }
}
