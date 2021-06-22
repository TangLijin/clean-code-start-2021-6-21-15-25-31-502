package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    public static final String RECEIPT_HEADER = "======Printing Orders======\n";
    public static final double TAX_RATE = .10;
    public static final String RECEIPT_SALES_TAX = "Sales Tax";
    public static final String RECEIPT_TOTAL_AMOUNT = "Total Amount";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //Deprecated
    public String printCustomerName() {
        return order.getCustomerName();
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        receipt.append(RECEIPT_HEADER);

        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());

        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getDescription());
            receipt.append('\t');
            receipt.append(lineItem.getPrice());
            receipt.append('\t');
            receipt.append(lineItem.getQuantity());
            receipt.append('\t');
            receipt.append(lineItem.totalAmount());
            receipt.append('\n');

        }

        receipt.append(RECEIPT_SALES_TAX).append('\t').append(calculateTotalSalesTax());

        receipt.append(RECEIPT_TOTAL_AMOUNT).append('\t').append(calculateTotalAmount());
        return receipt.toString();
    }

    private double calculateTotalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalAmount += lineItem.totalAmount() + calculateTaxAmount(lineItem);
        }
        return totalAmount;
    }

    private double calculateTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalSalesTax += calculateTaxAmount(lineItem);
        }
        return totalSalesTax;
    }

    private double calculateTaxAmount(LineItem lineItem) {
        return lineItem.totalAmount() * TAX_RATE;
    }

}