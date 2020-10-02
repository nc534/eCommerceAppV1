package com.ecommerce.model;

public class Product {
    private int product_code;
    private static int productCounter = 0;
    private String product_name;
    private double price;

    public Product(){

    }

    public Product(String product_name, double price) {
        this.product_code = ++productCounter;
        this.product_name = product_name;
        this.price = price;
    }

    public int getProductCode() {
        return product_code;
    }

    public String getProductName() {
        return product_name;
    }

    public double getPrice() {
        return price;
    }
}
