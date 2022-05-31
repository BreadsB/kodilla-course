package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.List;

public class ProductOrderService {

    public boolean order(final User user, final LocalDate orderDate, final List<BucketElement> bucketElementList) {
        System.out.println("User placed an order");
        return user != null & orderDate != null & bucketElementList != null & !bucketElementList.isEmpty();
    }

    public static void main(String[] args) {

        OrderRetriever orderRetriever = new OrderRetriever();
        Order order1 = orderRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new OrderInformationService(), new OrderRepository(), new ProductOrderService());
        orderProcessor.process(order1);
    }
}
