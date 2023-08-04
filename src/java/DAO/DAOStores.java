/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Entities.Stores;
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
public class DAOStores extends DBConnect {

    public int addStoreByPre(Stores store) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[stores]\n"
                + "           ([store_id]\n"
                + "           ,[store_name]\n"
                + "           ,[phone]\n"
                + "           ,[email]\n"
                + "           ,[street]\n"
                + "           ,[city]\n"
                + "           ,[state]\n"
                + "           ,[zip_code]\n"
                + "           ,[status])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, store.getStore_id());
            pre.setString(2, store.getStore_name());
            pre.setString(3, store.getPhone());
            pre.setString(4, store.getEmail());
            pre.setString(5, store.getStreet());
            pre.setString(6, store.getCity());
            pre.setString(7, store.getState());
            pre.setString(8, store.getZip_code());
            pre.setInt(9, store.getStatus());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStores.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateStoreByPre(Stores store) {
        int n = 0;
        String sql = "UPDATE [dbo].[stores]\n"
                + "   SET [store_name] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[street] = ?\n"
                + "      ,[city] = ?\n"
                + "      ,[state] = ?\n"
                + "      ,[zip_code] = ?\n"
                + "      ,[status] = ?\n"
                + " WHERE [store_id] = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, store.getStore_name());
            pre.setString(2, store.getPhone());
            pre.setString(3, store.getEmail());
            pre.setString(4, store.getStreet());
            pre.setString(5, store.getCity());
            pre.setString(6, store.getState());
            pre.setString(7, store.getZip_code());
            pre.setInt(8, store.getStatus());
            pre.setInt(9, store.getStore_id());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStores.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public Vector<Stores> getAll() {
        Vector<Stores> vector = new Vector<Stores>();
        String sql = "select * from stores";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) { //rs.previous()
                int store_id = rs.getInt(1);
                String store_name = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                String street = rs.getString(5);
                String city = rs.getString(6);
                String state = rs.getString(7);
                String zip_code = rs.getString(8);
                int status = rs.getInt(9);

                Stores store = new Stores(store_id, status, store_name, phone, email,
                        street, city, state, zip_code);

                vector.add(store);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Stores> getAll(String sql) {
        Vector<Stores> vector = new Vector<Stores>();
//        String sql = "select * from stores";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) { //rs.previous()
                int store_id = rs.getInt(1);
                String store_name = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                String street = rs.getString(5);
                String city = rs.getString(6);
                String state = rs.getString(7);
                String zip_code = rs.getString(8);
                int status = rs.getInt(9);

                Stores store = new Stores(store_id, status, store_name, phone, email,
                        street, city, state, zip_code);

                vector.add(store);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    
    public int removeStore(int id) {
        int n = 0;
        String sql = "delete from stores where store_id=" + id;
        try {
            Statement state = conn.createStatement();
            ResultSet rs1 = this.getData("select * from staffs where store_id = " + id);
            ResultSet rs2 = this.getData("select * from orders where store_id = " + id);
            ResultSet rs3 = this.getData("select * from stocks where store_id = " + id);
            if (rs1.next() || rs2.next() || rs3.next()) {
                n = -1; //-1 vi pham toan ven khoa ngoai;
            } else {
                n = state.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOStores.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public static void main(String[] args) {
        DAOStores dao = new DAOStores();
        // ADD 
//        int n = dao.addStoreByPre(new Stores(6, 1, "Dior", "9999", "dior@fpt.edu.vn",
//                "10 Dior", "HN", "B", "1000"));
//        if (n > 0) {
//            System.out.println("inserted");
//        }
        // UPDATE 
//        int n = dao.updateStoreByPre(new Stores(6, 1, "TungNorthSide", "aaa", "tungnhhe@fpt.edu.vn",
//                "TLe", "HN", "B", "1000"));
//        if (n > 0) {
//            System.out.println("inserted");
//        }

        int n = dao.removeStore(4);
        if(n > 0){
            System.out.println("deleted");
        }
    }

}
