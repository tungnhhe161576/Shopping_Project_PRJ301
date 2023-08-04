/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Entities.Customer;
import Entities.Staffs;
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
public class DAOStaffs extends DBConnect {
    
    public boolean login(String email, String phone) {
        boolean flag = false;
        String sql = "select * from staffs where email = ? and phone = ?";

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
    
    public Staffs Login(String username, String password) {
        String sql = "select * from staffs where email like ? and phone like ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                return new Staffs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOStaffs.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public int addStaffByPre(Staffs st) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[staffs]\n"
                + "           ([staff_id]\n"
                + "           ,[first_name]\n"
                + "           ,[last_name]\n"
                + "           ,[email]\n"
                + "           ,[phone]\n"
                + "           ,[active]\n"
                + "           ,[store_id]\n"
                + "           ,[manager_id]\n"
                + "           ,[status])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, st.getStaff_id());
            pre.setString(2, st.getFirst_name());
            pre.setString(3, st.getLast_name());
            pre.setString(4, st.getEmail());
            pre.setString(5, st.getPhone());
            pre.setInt(6, st.getActive());
            pre.setInt(7, st.getStore_id());
            pre.setInt(8, st.getManager_id());
            pre.setInt(9, st.getStatus());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaffs.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateStaffByPre(Staffs st) {
        int n = 0;
        String sql = "UPDATE [dbo].[staffs]\n"
                + "   SET [first_name] = ?\n"
                + "      ,[last_name] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[active] = ?\n"
                + "      ,[store_id] = ? \n"
                + "      ,[manager_id] = ? \n"
                + "      ,[status] = ?\n"
                + " WHERE [staff_id] = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, st.getFirst_name());
            pre.setString(2, st.getLast_name());
            pre.setString(3, st.getEmail());
            pre.setString(4, st.getPhone());
            pre.setInt(5, st.getActive());
            pre.setInt(6, st.getStore_id());
            pre.setInt(7, st.getManager_id());
            pre.setInt(8, st.getStatus());
            pre.setInt(9, st.getStaff_id());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaffs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }


    public Vector<Staffs> getAll() {
        Vector<Staffs> vector = new Vector<Staffs>();
        String sql = "select * from staffs";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) { //rs.previous()
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                int status = rs.getInt(9);

                Staffs staff = new Staffs(staff_id, first_name, last_name,
                        email, phone, active, store_id, manager_id, status);

                vector.add(staff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaffs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Staffs> getAll(String sql) {
        Vector<Staffs> vector = new Vector<Staffs>();
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) { //rs.previous()
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                int status = rs.getInt(9);

                Staffs staff = new Staffs(staff_id, first_name, last_name,
                        email, phone, active, store_id, manager_id, status);

                vector.add(staff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaffs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int removeStaff(int id) {
        int n = 0;
        String sql = "delete from staffs where staff_id=" + id;

        try {
            Statement state = conn.createStatement();
            ResultSet rs1 = this.getData("select * from orders where staff_id = " + id);
            if (rs1.next()) {
                n = -1; //-1 vi pham toan ven khoa ngoai;
            } else {
                n = state.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOStaffs.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public static void main(String[] args) {
        DAOStaffs dao = new DAOStaffs();
        // ADD 
        int n = dao.addStaffByPre(new Staffs(15, "Do", "Van Hieu", "hiesrgbudv@fpt.edu.vn",
                "0902121881", 1, 1, 3, 1));
        if (n > 0) {
            System.out.println("inserted");
        }
        // UPDATE 
//    int n = dao.updateStaffByPre(new Staffs(1,"Nguyen", "Huy Tung","hieudv@fpt.edu.vn",
//             "0902121881",1,1,0,1));
//         if(n>0){
//             System.out.println("Updated");
//         }
//        int n = dao.removeStaff(12);
//        if (n > 0) {
//            System.out.println("deleted");
//        }
    }

}
