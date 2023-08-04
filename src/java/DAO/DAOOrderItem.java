/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Entities.OrderItem;
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
public class DAOOrderItem extends DBConnect {

    public int addOrderItems(OrderItem oi) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[order_items]\n"
                + "           ([order_id]\n"
                + "           ,[item_id]\n"
                + "           ,[product_id]\n"
                + "           ,[quantity]\n"
                + "           ,[list_price]\n"
                + "           ,[discount])\n"
                + "     VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, oi.getOrder_id());
            pre.setInt(2, oi.getItem_id());
            pre.setInt(3, oi.getProduct_id());
            pre.setInt(4, oi.getQuantity());
            pre.setDouble(5, oi.getList_price());
            pre.setDouble(6, oi.getDiscount());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateOrderItems(OrderItem oi) {
        int n = 0;
        String sql = "UPDATE [dbo].[order_items]\n"
                + "   SET [item_id] = ?\n"
                + "      ,[product_id] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[list_price] = ?\n"
                + "      ,[discount] = ?\n"
                + " WHERE [order_id] = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setInt(1, oi.getItem_id());
            pre.setInt(2, oi.getProduct_id());
            pre.setInt(3, oi.getQuantity());
            pre.setDouble(4, oi.getList_price());
            pre.setDouble(5, oi.getDiscount());
            pre.setInt(6, oi.getOrder_id());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public Vector<OrderItem> getAll() {
        Vector<OrderItem> vector = new Vector<OrderItem>();
        String sql = "select * from order_items";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) { //rs.previous()
                int order_id = rs.getInt(1);
                int item_id = rs.getInt(2);
                int product_id = rs.getInt(3);
                int quantity = rs.getInt(4);
                double list_price = rs.getDouble(5);
                double discount = rs.getDouble(6);

                OrderItem oi = new OrderItem(list_price, discount, order_id, item_id, product_id, quantity);

                vector.add(oi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<OrderItem> getAll(String sql) {
        Vector<OrderItem> vector = new Vector<OrderItem>();
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) { //rs.previous()
                int order_id = rs.getInt(1);
                int item_id = rs.getInt(2);
                int product_id = rs.getInt(3);
                int quantity = rs.getInt(4);
                double list_price = rs.getDouble(5);
                double discount = rs.getDouble(6);

                OrderItem oi = new OrderItem(list_price, discount, order_id, item_id, product_id, quantity);

                vector.add(oi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int removeOrderItems(int id1, int id2) {
        int n = 0;
        String sql = "delete from order_items where store_id=" + id1
                + " and item_id=" + id2;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public static void main(String[] args) {
        DAOOrderItem dao = new DAOOrderItem();
        // ADD 
        int n = dao.addOrderItems(new OrderItem(379.99, 0, 11111, 1, 1, 1));
        if (n > 0) {
            System.out.println("inserted");
        }

//        Vector<OrderItem> vector = dao.getAll();
//        for (OrderItem orderItem : vector) {
//            System.out.println(orderItem);
//        }

//        int n = dao.removeOrderItems(1, 1);
//        if (n > 0) {
//            System.out.println("deleted");
//        }
    }

}
