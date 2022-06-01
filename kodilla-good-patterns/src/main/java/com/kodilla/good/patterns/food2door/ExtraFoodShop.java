package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements ShopSupplier {
    String shopName = "Extra Food Shop";

    public String getShopName() {
        return shopName;
    }

    public OrderDto process(OrderRequest orderRequest) {

        System.out.println("Processing order from " + getShopName());
        OrderRepository extraFoodShopOrderRepository = new OrderRepository();
        extraFoodShopOrderRepository.putOrderInRepository();
        System.out.println("Order added to Extra Food Shop repository");
        InformationService informationService = new InformationService();
        informationService.sendConfirmation(getShopName());

        return new OrderDto(orderRequest.getSupplier(), orderRequest.getProduct(), orderRequest.getQuantity());
    }
}
