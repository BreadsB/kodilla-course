package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.when;

public class SimpleInvoiceTestSuite {

    @Test
    void testGetValueToPay() {
        SimpleProduct product1 = new SimpleProduct("Fridge",17.28);
        SimpleProduct product2 = new SimpleProduct("Oven",11.99);
        SimpleProduct product3 = new SimpleProduct("Product 2",6.49);
        SimpleItem item1 = new SimpleItem(product1, 2);
        SimpleItem item2 = new SimpleItem(product2, 3.5);
        SimpleItem item3 = new SimpleItem(product3, 5);
        SimpleInvoice invoice = new SimpleInvoice();
        invoice.addItem(item1);
        invoice.addItem(item2);
        invoice.addItem(item3);
        double result = invoice.getValueToPay();

        System.out.println(result);
        Assertions.assertEquals(108.975, result, 0.001);
    }
}
