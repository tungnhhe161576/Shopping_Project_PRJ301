/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Entities.Orders;
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
public class DAOOrders extends DBConnect {

    public int addOrderByPre(Orders ord) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[orders]\n"
                + "           ([order_id]\n"
                + "           ,[customer_id]\n"
                + "           ,[order_status]\n"
                + "           ,[order_date]\n"
                + "           ,[required_date]\n"
                + "           ,[shipped_date]\n"
                + "           ,[store_id]\n"
                + "           ,[staff_id]\n"
                + "           ,[status])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, ord.getOrder_id());
            pre.setInt(2, ord.getCustomer_id());
            pre.setInt(3, ord.getOrder_status());
            pre.setInt(7, ord.getStore_id());
            pre.setInt(8, ord.getStaff_id());
            pre.setInt(9, ord.getStatus());
            pre.setString(4, ord.getOrder_date());
            pre.setString(5, ord.getRequired_date());
            pre.setString(6, ord.getShipped_date());
            

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateOrderByPre(Orders ord) {
        int n = 0;
        String sql = "UPDATE [dbo].[orders]\n"
                + "   SET [customer_id] = ? \n"
                + "      ,[order_status] = ?\n"
                + "      ,[order_date] = ?\n"
                + "      ,[required_date] = ?\n"
                + "      ,[shipped_date] =?\n"
                + "      ,[store_id] = ?\n"
                + "      ,[staff_id] = ?\n"
                + "      ,[status] = ?\n"
                + " WHERE [order_id] = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, ord.getCustomer_id());
            pre.setInt(2, ord.getOrder_status());
            
            pre.setInt(6, ord.getStore_id());
            pre.setInt(7, ord.getStaff_id());
            pre.setInt(8, ord.getStatus());
            pre.setInt(9, ord.getOrder_id());
            pre.setString(3, ord.getOrder_date());
            pre.setString(4, ord.getRequired_date());
            pre.setString(5, ord.getShipped_date());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int removeOrder(int id) {
        int n = 0;
        String sql = "delete from orders where order_id=" + id;

        try {
            Statement state = conn.createStatement();
            ResultSet rs1 = this.getData("select * from Order_items where order_id=" + id);

            if (rs1.next()) {
                n = -1; //-1 vi pham toan ven khoa ngoai;
            } else {
                n = state.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public Vector<Orders> getAll() {
        Vector<Orders> vector = new Vector<Orders>();
        String sql = "select * from orders";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) { //rs.previous()
                int order_id = rs.getInt(1);
                int customer_id = rs.getInt(2);
                int order_status = rs.getInt(3);
                String order_date = rs.getString(4);
                String required_date = rs.getString(5);
                String shipped_date = rs.getString(6);
                int store_id = rs.getInt(7);
                int staff_id = rs.getInt(8);
                int status = rs.getInt(9);

                Orders od = new Orders(order_id, customer_id, order_status, store_id, staff_id, 
                        status, required_date, shipped_date, order_date);

                vector.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public Vector<Orders> getAll(String sql) {
        Vector<Orders> vector = new Vector<Orders>();
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) {
                int order_id = rs.getInt(1);
                int customer_id = rs.getInt(2);
                int order_status = rs.getInt(3);
                String order_date = rs.getString(4);
                String required_date = rs.getString(5);
                String shipped_date = rs.getString(6);
                int store_id = rs.getInt(7);
                int staff_id = rs.getInt(8);
                int status = rs.getInt(9);

                Orders od = new Orders(order_id, customer_id, order_status, store_id, staff_id, 
                        status, required_date, shipped_date, order_date);

                vector.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    
    
    
    public static void main(String[] args) {
        DAOOrders dao = new DAOOrders();
        // ADD 
        int n = dao.addOrderByPre(new Orders(11111, 1, 4, 1, 2, 1, "2021-01-01", "2021-01-03", "2021-01-04"));
        if (n > 0) {
            System.out.println("inserted");
        }
        // UPDATE 
//        int n = dao.updateOrderByPre(new Orders(11111,1,4,1,2,1,"2021-01-01", "2021-01-03","2021-01-06"));
//        if(n>0){
//             System.out.println("update");
//        }
    }
}
