package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements ShopSupplier {

    String shopName = "Gluten Free Shop";

    public String getShopName() {
        return shopName;
    }

    public OrderDto process(OrderRequest orderRequest) {
        OrderRepository glutenFreeShopOrderRepository = new OrderRepository();
        glutenFreeShopOrderRepository.putOrderInRepository();

        InformationService informationService = new InformationService();
        informationService.sendConfirmation(orderRequest.getSupplier().getShopName());

        return new OrderDto(orderRequest.getSupplier(), orderRequest.getProduct(), orderRequest.getQuantity());
    }
}
