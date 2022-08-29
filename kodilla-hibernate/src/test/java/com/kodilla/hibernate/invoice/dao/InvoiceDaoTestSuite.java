package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;


@Transactional
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoSave() {

        Product product1 = new Product("Butter");
        Product product2 = new Product("Bread");

        Item item1 = new Item(new BigDecimal(500), 5);
        Item item2 = new Item(new BigDecimal(300), 3);

        Invoice invoice1 = new Invoice("1");

        item1.setProduct(product1);
        item2.setProduct(product2);

        product1.getItems().add(item1);
        product2.getItems().add(item2);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);

        invoiceDao.save(invoice1);

        int id = invoice1.getId();

        Assertions.assertTrue(invoice1.getId() > 0);

        //CleanUp
        invoiceDao.deleteById(id);
    }
}
