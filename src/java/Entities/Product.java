/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Entities;

/**
 *
 * @author Admin
 */
public class Product {

    /**
     * @param args the command line arguments
     */
    private int product_id;
    private String product_name, image;
    private int model_year;
    private double list_price;
    private String brand_name, category_name;
    private int quantity;

    public Product(int product_id, String product_name, String image, int model_year, double list_price, String brand_name, String category_name) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.image = image;
        this.model_year = model_year;
        this.list_price = list_price;
        this.brand_name = brand_name;
        this.category_name = category_name;
    }
    
    public Product(int product_id, String product_name, String image, int model_year, double list_price, String brand_name, String category_name, int quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.image = image;
        this.model_year = model_year;
        this.list_price = list_price;
        this.brand_name = brand_name;
        this.category_name = category_name;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(int product_id, String product_name, int model_year, double list_price, String brand_name, String category_name, String image) {
        this.product_id = product_id;
        this.product_name = product_name;

        this.model_year = model_year;
        this.list_price = list_price;
        this.brand_name = brand_name;
        this.category_name = category_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public double getList_price() {
        return list_price;
    }

    public void setList_price(double list_price) {
        this.list_price = list_price;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", product_name=" + product_name + ", image=" + image + ", model_year=" + model_year + ", list_price=" + list_price + ", brand_name=" + brand_name + ", category_name=" + category_name + '}';
    }

}
