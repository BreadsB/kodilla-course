package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.List;

public class ProductOrderService {

    private OrderInformationService orderInformationService;
    private OrderRepository orderRepository;

    public static boolean order(final User user, final LocalDate orderDate, final List<BucketElement> bucketElementList) {
        return user != null & orderDate != null & bucketElementList != null & !bucketElementList.isEmpty();
    }

    public ProductOrderService(final OrderInformationService orderInformationService,
                          final OrderRepository orderRepository) {
        this.orderInformationService = orderInformationService;
        this.orderRepository = orderRepository;
    }
    public OrderDto process(Order order) {
        boolean orderAccepted = ProductOrderService.order(order.getUser(), order.getOrderDate(), order.getBucketList());

        if (orderAccepted) {
            orderInformationService.sendConfirmationEmail(order.getUser());
            orderRepository.putOrderInRepository(order.getUser(), order.getOrderDate(), order.getBucketList());
            return new OrderDto(order.getUser(), true);
        } else {
            return new OrderDto(order.getUser(), false);
        }
    }
    public static void main(String[] args) {

        OrderRetriever orderRetriever = new OrderRetriever();
        Order order1 = orderRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new OrderInformationService(), new OrderRepository());
        productOrderService.process(order1);
    }
}
