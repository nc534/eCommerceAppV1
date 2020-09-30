package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private final int invoice_number;
    private static int invoiceCounter = 0;
    private final LocalDateTime purchase_date;
    private List<Product> purchaseList;
    private double total;

    public Invoice(List<Product> purchaseList) {
        this.invoice_number = invoiceCounter++;
        this.purchase_date = LocalDateTime.now();
        this.purchaseList = purchaseList;
        this.total = addTotal();
    }

    public int getInvoice_number() {
        return invoice_number;
    }

    public LocalDateTime getPurchase_date() {
        return purchase_date;
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
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
