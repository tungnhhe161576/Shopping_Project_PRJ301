/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Entities.Stocks;
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
public class DAOStocks extends DBConnect {

    public int addStockByPre(Stocks s) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[stocks]\n"
                + "           ([store_id]\n"
                + "           ,[product_id]\n"
                + "           ,[quantity])\n"
                + "     VALUES(?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, s.getStore_id());
            pre.setInt(2, s.getProduct_id());
            pre.setInt(3, s.getQuantity());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStocks.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateStockByPre(Stocks s) {
        int n = 0;
        String sql = "UPDATE [dbo].[stocks]\n"
                + "   SET [quantity]=?\n"
                + " WHERE [store_id]=?\n"
                + " AND [product_id]=?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, s.getQuantity());
            pre.setInt(2, s.getStore_id());
            pre.setInt(3, s.getProduct_id());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int removeStock(int id1, int id2) {
        int n = 0;
        String sql = "delete from stocks where store_id=" + id1 + " and product_id=" + id2;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Stocks> getAll() {
        Vector<Stocks> vector = new Vector<Stocks>();
        String sql = "select * from stocks";
        ResultSet rs = this.getData(sql);

        try {
            while (rs.next()) { //rs.previous()
                int store_id = rs.getInt(1);
                int product_id = rs.getInt(2);
                int quantity = rs.getInt(3);

                Stocks st = new Stocks(store_id, product_id, quantity);
                vector.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Stocks> getAll(String sql) {
        Vector<Stocks> vector = new Vector<Stocks>();
//        String sql = "select * from stocks";
        ResultSet rs = this.getData(sql);

        try {
            while (rs.next()) { //rs.previous()
                int store_id = rs.getInt(1);
                int product_id = rs.getInt(2);
                int quantity = rs.getInt(3);

                Stocks st = new Stocks(store_id, product_id, quantity);
                vector.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOStocks dao = new DAOStocks();
//        // ADD 
//        int n = dao.addStockByPre(new Stocks(1, 201, 10));
//        if (n > 0) {
//            System.out.println("inserted");
//        }
//         UPDATE 
//        int n = dao.updateStockByPre(new Stocks(1,1,32));
//        if (n > 0) {
//            System.out.println("updated");
//        }
        
        //delete
//        int n = dao.removeStock(1, 201);
//        if(n > 0){
//            System.out.println("deleted");
//        }
    }

}
