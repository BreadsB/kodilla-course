package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private OrderInformationService orderInformationService;
    private OrderRepository orderRepository;
    private ProductOrderService productOrderService;

    public OrderProcessor(final OrderInformationService orderInformationService,
                          final OrderRepository orderRepository,
                          final ProductOrderService productOrderService) {
        this.orderInformationService = orderInformationService;
        this.orderRepository = orderRepository;
        this.productOrderService = productOrderService;
    }
    public OrderDto process(Order order) {
        boolean orderAccepted = productOrderService.order(order.getUser(), order.getOrderDate(), order.getBucketList());

        if (orderAccepted) {
            orderInformationService.sendConfirmationEmail(order.getUser());
            orderRepository.putOrderInRepository(order.getUser(), order.getOrderDate(), order.getBucketList());
            return new OrderDto(order.getUser(), true);
        } else {
            return new OrderDto(order.getUser(), false);
        }
    }
}
