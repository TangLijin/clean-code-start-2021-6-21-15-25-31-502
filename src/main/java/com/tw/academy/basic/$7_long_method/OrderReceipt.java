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
    public static final char SEPARATOR = '\t';
    public static final char LINE_SEPARATOR = '\n';
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

        constructHeader(receipt);
        constructCustomerInfo(receipt);
        constructItemInfo(receipt);

        constrcuctAmountAndTax(receipt);
        return receipt.toString();
    }

    private void constrcuctAmountAndTax(StringBuilder receipt) {
        receipt.append(RECEIPT_SALES_TAX).append(SEPARATOR).append(calculateTotalSalesTax());
        receipt.append(RECEIPT_TOTAL_AMOUNT).append(SEPARATOR).append(calculateTotalAmount());
    }

    private void constructHeader(StringBuilder receipt) {
        receipt.append(RECEIPT_HEADER);
    }

    private void constructCustomerInfo(StringBuilder receipt) {
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
    }

    private void constructItemInfo(StringBuilder receipt) {
        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getDescription());
            receipt.append(SEPARATOR);
            receipt.append(lineItem.getPrice());
            receipt.append(SEPARATOR);
            receipt.append(lineItem.getQuantity());
            receipt.append(SEPARATOR);
            receipt.append(lineItem.totalAmount());
            receipt.append(LINE_SEPARATOR);

        }
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