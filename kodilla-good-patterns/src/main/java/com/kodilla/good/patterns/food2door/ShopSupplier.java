package com.kodilla.good.patterns.food2door;

public interface ShopSupplier {

    OrderDto process(OrderRequest orderRequest);
    String getShopName();
    InformationService informationService = new InformationService();

    default OrderDto checkRequest(OrderRequest orderRequest) {

        System.out.println("Checking request for " + getShopName());
        boolean orderAccepted = orderRequest.getSupplier() != null & !orderRequest.getProduct().isBlank() & orderRequest.getQuantity() != 0.0;

        if (orderAccepted) {
            informationService.sendConfirmation(getShopName());
            return process(orderRequest);
        } else {
            return new OrderDto(null, null, 0.0);
        }
    }
}
