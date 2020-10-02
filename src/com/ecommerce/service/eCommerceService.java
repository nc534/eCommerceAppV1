package com.ecommerce.service;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Invoice;
import com.ecommerce.model.Product;

import java.util.*;

public class eCommerceService {

    public static List<Customer> customerList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();
    public static Map<String, String> customerLogin = new HashMap<>();
    public static Map<Integer, Product> productMap = new HashMap<>();
    public static List<Product> purchaseList = new ArrayList<>();
    public static List<Invoice> invoiceList = new ArrayList<>();

    public static void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public static Customer getCustomerByUsername(String username) {
        return customerList.stream().filter(c -> c.getUserId().equals(username)).findAny().orElse(null);
    }

    public static Map<String, String> loginCheck() {
        for(Customer c : customerList){
            customerLogin.put(c.getUserId(), c.getPassword());
        }

        return customerLogin;
    }

    public static void addProduct(Product... products) {
        productList.addAll(Arrays.asList(products));
    }

    public static List<Product> getProducts() {
        return productList;
    }

    public static List<Product> purchaseList(String purchaseCodes) {
        String[] splitCodes = purchaseCodes.split(",");
        int[] codes = new int[splitCodes.length];

        for(int i = 0; i < splitCodes.length; i++) {
            codes[i] = Integer.parseInt(splitCodes[i]);
        }

        for(int c : codes){
            purchaseList.add(getProductByCode(c));
        }

        return purchaseList;
    }

    public static void clearPurchaseList() {
        purchaseList.clear();
    }

    public static Product getProductByCode(int code) {
        Product product;

        for(Product p : productList){
            productMap.put(p.getProductCode(), p);
        }

        product = productMap.get(code);

        return product;
    }

    public static void addInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }

    public static Invoice getInvoiceByNumber(int number) {
        return invoiceList.stream().filter(i -> i.getInvoiceNumber() == number).findAny().orElse(null);
    }

}
