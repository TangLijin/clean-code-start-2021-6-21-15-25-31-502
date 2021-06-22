package com.tw.academy.basic.$7_long_method;

import java.util.List;

public class Order {
    public static final double TAX_RATE = .10;
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double calculateTotalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : getLineItems()) {
            totalAmount += lineItem.totalAmount() + calculateTaxAmount(lineItem);
        }
        return totalAmount;
    }

    public double calculateTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            totalSalesTax += calculateTaxAmount(lineItem);
        }
        return totalSalesTax;
    }

    public double calculateTaxAmount(LineItem lineItem) {
        return lineItem.totalAmount() * TAX_RATE;
    }

}
