
package DAO;

import Entities.Customer;
import Entities.Item;
import Entities.Orders;
import Entities.Product;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.DBConnect;


public class DAOOrder extends DBConnect{
    String date = LocalDate.now().toString();
    
    public int addOrder(Item item, Customer cus, double price) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([customer_id]\n"
                + "           ,[product_id]\n"
                + "           ,[quantity]\n"
                + "           ,[price]\n"
                + "           ,[order_date])\n"
                + "     VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cus.getCustomer_id());
            pre.setInt(2, item.getProduct().getProduct_id());
            pre.setInt(3, item.getQuantity());
            pre.setDouble(4, price);
            pre.setString(5, date);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }
    
    public static void main(String[] args) {
        
    }
}
