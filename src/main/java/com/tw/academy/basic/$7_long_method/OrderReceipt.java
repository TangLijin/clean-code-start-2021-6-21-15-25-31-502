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
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
    }

    //Deprecated
    public String printCustomerName() {
        return o.getCustomerName();
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append(RECEIPT_HEADER);

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append(RECEIPT_SALES_TAX).append('\t').append(totSalesTx);

        // print total amount
        output.append(RECEIPT_TOTAL_AMOUNT).append('\t').append(tot);
        return output.toString();
    }
}