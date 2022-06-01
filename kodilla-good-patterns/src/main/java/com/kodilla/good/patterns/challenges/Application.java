package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String[] args) {
        OrderRetriever orderRetriever = new OrderRetriever();
        Order order1 = orderRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new OrderInformationService(), new OrderRepository());
        productOrderService.process(order1);
    }
}
