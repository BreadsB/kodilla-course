package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {

        Product product1 = new Product("Butter");
        Product product2 = new Product("Bread");

        Item item1 = new Item(product1, new BigDecimal(500), 5);
        Item item2 = new Item(product2, new BigDecimal(300), 3);

        Invoice invoice1 = new Invoice("1");
        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);

        invoiceDao.save(invoice1);
        int id = invoice1.getId();

        Assertions.assertEquals(0, id);

        //CleanUp
        invoiceDao.deleteById(id);
    }

}
