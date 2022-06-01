package com.kodilla.good.patterns.food2door;

public class HealthyShop implements ShopSupplier {

    String shopName = "Healthy Shop";

    public String getShopName() {
        return shopName;
    }

    public OrderDto process(OrderRequest orderRequest) {
        OrderRepository healthyShopOrderRepository = new OrderRepository();
        InformationService informationService = new InformationService();
        healthyShopOrderRepository.putOrderInRepository();
        informationService.sendConfirmation(getShopName());

        return new OrderDto(orderRequest.getSupplier(), orderRequest.getProduct(), orderRequest.getQuantity());
    }
}
