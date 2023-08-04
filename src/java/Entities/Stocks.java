/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Entities;

/**
 *
 * @author Admin
 */
public class Stocks {

    /**
     * @param args the command line arguments
     */
    private int store_id, product_id, quantity;

    public Stocks() {
    }

    public Stocks(int store_id, int product_id, int quantity) {
        this.store_id = store_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStock_id(int stock_id) {
        this.store_id = stock_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
