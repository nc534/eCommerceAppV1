package com.ecommerce.service;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class eCommerceService {

    public static List<Customer> customerList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();

    public static void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public static List<Customer> getCustomers() {
        return customerList;
    }

    public static void addProduct(Product... products) {
        productList.addAll(Arrays.asList(products));
    }

    public static List<Product> getProducts() {
        return productList;
    }

}
