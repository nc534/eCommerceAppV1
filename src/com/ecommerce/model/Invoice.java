package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

public class Invoice {
    private final int invoice_number;
    private static int invoiceCounter = 0;
    private final Customer customer;
    private final LocalDateTime purchase_date;
    private List<Product> purchaseList;
    private double total;

    public Invoice(Customer customer, List<Product> purchaseList) {
        this.customer = customer;
        this.invoice_number = ++invoiceCounter;
        this.purchase_date = LocalDateTime.now();
        this.purchaseList = purchaseList;
        this.total = addTotal();
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getInvoiceNumber() {
        return invoice_number;
    }

    public LocalDateTime getPurchaseDate() {
        return purchase_date;
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public double addTotal(){
        double totalPurchase = 0;

        for(Product p: purchaseList){
            totalPurchase += p.getPrice();
        }

        return totalPurchase;
    }

    public double getTotal() {
        return total;
    }
}
