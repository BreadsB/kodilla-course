package com.kodilla.good.patterns.food2door;

public class ShopService {

    public static void main(String[] args) {

        OrderRequestRetriever orderRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRetriever.orderFromGlutenFreeShop();
        orderRequest.getSupplier().checkRequest(orderRequest);
    }
}
