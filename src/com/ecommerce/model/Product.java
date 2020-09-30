package com.ecommerce.model;

public class Product {
    private int product_code;
    private static int productCounter = 0;
    private String product_name;
    private double price;

    public Product(){

    }

    public Product(String product_name, double price) {
        this.product_code = productCounter++;
        this.product_name = product_name;
        this.price = price;
    }

    public int getProduct_code() {
        return product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
