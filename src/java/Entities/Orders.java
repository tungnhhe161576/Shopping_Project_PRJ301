/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Entities;

/**
 *
 * @author Admin
 */
public class Orders {

    /**
     * @param args the command line arguments
     */
    private int order_id, customer_id, order_status, store_id, staff_id, status;
    private String required_date, shipped_date, order_date;

    public Orders() {
    }

    public Orders(int order_id, int customer_id, int order_status, int store_id, int staff_id, int status, String required_date, String shipped_date, String order_date) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_status = order_status;
        this.store_id = store_id;
        this.staff_id = staff_id;
        this.status = status;
        this.required_date = required_date;
        this.shipped_date = shipped_date;
        this.order_date = order_date;
    }

   

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getRequired_date() {
        return required_date;
    }

    public void setRequired_date(String required_date) {
        this.required_date = required_date;
    }

    public String getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(String Shipped_date) {
        this.shipped_date = Shipped_date;
    }

}
