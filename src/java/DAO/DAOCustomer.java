/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Entities.Customer;
import Entities.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.DBConnect;

/**
 *
 * @author Admin
 */
public class DAOCustomer extends DBConnect {

    public boolean login(String email, String phone) {
        boolean flag = false;
        String sql = "select * from customers where email like ? and phone like ? and status = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, phone);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }

        return flag;
    }
    
    public Customer Login(String username, String password) {
        String sql = "select * from customers where email like ? and phone like ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }
    
    public Vector<Customer> search(String searchName){
        Vector<Customer> vector = new Vector<>();
        String sql = "select * from customers where first_name like ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,"%"+searchName+"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                vector.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int addCustommerByPre(Customer cus) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[customers]\n"
                + "           ([customer_id]\n"
                + "           ,[first_name]\n"
                + "           ,[last_name]\n"
                + "           ,[phone]\n"
                + "           ,[email]\n"
                + "           ,[street]\n"
                + "           ,[city]\n"
                + "           ,[state]\n"
                + "           ,[zip_code]\n"
                + "           ,[status])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cus.getCustomer_id());
            pre.setString(2, cus.getFirst_name());
            pre.setString(3, cus.getLast_name());
            pre.setString(4, cus.getPhone());
            pre.setString(5, cus.getEmail());
            pre.setString(6, cus.getStreet());
            pre.setString(7, cus.getCity());
            pre.setString(8, cus.getState());
            pre.setString(9, cus.getZip_code());
            pre.setInt(10, cus.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCustomerByPre(Customer cus) {
        int n = 0;
        String sql = "UPDATE [dbo].[customers]\n"
                + "   SET [first_name] = ?\n"
                + "      ,[last_name] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[street] = ?\n"
                + "      ,[city] = ?\n"
                + "      ,[state] = ?\n"
                + "      ,[zip_code] = ?\n"
                + "      ,[status] = ?\n"
                + " WHERE [customer_id] = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getFirst_name());
            pre.setString(2, cus.getLast_name());
            pre.setString(3, cus.getPhone());
            pre.setString(4, cus.getEmail());
            pre.setString(5, cus.getStreet());
            pre.setString(6, cus.getCity());
            pre.setString(7, cus.getState());
            pre.setString(8, cus.getZip_code());
            pre.setInt(9, cus.getStatus());
            pre.setInt(10, cus.getCustomer_id());

            //RUN
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Customer> getAll() {
        Vector<Customer> vector = new Vector<Customer>();
        String sql = "select * from customers";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) { //rs.previous()
                int customer_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String street = rs.getString(6);
                String city = rs.getString(7);
                String state = rs.getString(8);
                String zip_code = rs.getString(9);
                int status = rs.getInt(10);

                Customer cus = new Customer(customer_id, first_name, last_name,
                        phone, email, street, city, state, zip_code, status);

                vector.add(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public Vector<Customer> getAll(String sql) {
        Vector<Customer> vector = new Vector<Customer>();
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) { //rs.previous()
                int customer_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String street = rs.getString(6);
                String city = rs.getString(7);
                String state = rs.getString(8);
                String zip_code = rs.getString(9);
                int status = rs.getInt(10);

                Customer cus = new Customer(customer_id, first_name, last_name,
                        phone, email, street, city, state, zip_code, status);

                vector.add(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int removeCustomer(int id) {
        int n = 0;
        String sql = "delete from Customers where customer_id=" + id;

        Statement state;
        try {
            state = conn.createStatement();
            ResultSet rs1 = this.getData("select * from Orders where order_id = " + id);

            if (rs1.next()) {
                n = -1; //-1 vi pham toan ven khoa ngoai;
            } else {
                n = state.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public static void main(String[] args) {
        DAOCustomer dao = new DAOCustomer();
//        // ADD 
//        int n = dao.addCustommerByPre(new Customer(1002, "Do", "Van Dat", "01234",
//                "fpt.edu.vn", "DP", "HN", "B", "10000", 1));
//        if (n > 0) {
//            System.out.println("inserted");
//        }

        // UPDATE 
//    int n = dao.updateCustomerByPre(new Customer(506, "Tung", "a", "a", "aa@gmail.com", "a", "a", "a", "a", 1));
//         if(n>0){
//             System.out.println("updated");
//         }
//
        int n = dao.removeCustomer(503);
        if(n > 0){
            System.out.println("deleted");
        }

//        boolean flag = dao.login("charolette.rice@msn.com", "(916) 381-6003", "NULL");
//        if(flag){
//            System.out.println("ok");
//        }

//        Customer cus = dao.Login("fpt.edu.vn", "01234");
//        System.out.println(cus.toString());
        
    }

}
