package com.ecommerce.data;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Invoice;
import com.ecommerce.model.Product;
import com.ecommerce.service.eCommerceService;

import java.util.ArrayList;
import java.util.List;

public class InitialData {
    public void generateInitialData(){

        //Create product inventory
        Product p1 = new Product("Jacket", 25.75);
        Product p2 = new Product("Jeans", 15.25);
        Product p3 = new Product("Blouse", 12.00);
        Product p4 = new Product("Coat", 53.50);
        Product p5 = new Product("TShirt", 7.50);
        Product p6 = new Product("Skirt", 9.00);
        Product p7 = new Product("Cardigan", 10.00);
        Product p8 = new Product("Leggings", 6.25);
        Product p9 = new Product("Sweater", 16.75);

        eCommerceService.addProduct(p1, p2, p3, p4, p5, p6, p7, p8, p9);

        //mock customer
        Customer newCustomer = new Customer("testuser", "Testpw@123", "Test User",
                "test@email.com", "1234567890", "132 Orange St.");

        eCommerceService.addCustomer(newCustomer);

        List<Product> purchaseList = new ArrayList<>();
            purchaseList.add(p2);
            purchaseList.add(p5);
            purchaseList.add(p7);

        Invoice newInvoice = new Invoice(newCustomer, purchaseList);
        eCommerceService.addInvoice(newInvoice);

    }
}
