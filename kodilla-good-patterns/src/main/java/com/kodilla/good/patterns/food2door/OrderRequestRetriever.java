package com.kodilla.good.patterns.food2door;

public class OrderRequestRetriever {

    public OrderRequest orderFromExtraFoodShop() {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        String product = "French Fries";
        double quantity = 1.7;
        System.out.println("Retrieving order from Extra Food Shop");

        return new OrderRequest(extraFoodShop, product, quantity);
    }

    public OrderRequest orderFromGlutenFreeShop() {
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        String product = "Gluten Free BreadRolls";
        double quantity = 7.0;
        System.out.println("Order from GlutenFreeShop retrieved");

        return new OrderRequest(glutenFreeShop, product, quantity);
    }

    public OrderRequest orderFromHealthyShop() {
        HealthyShop healthyShop = new HealthyShop();
        String product = "Chicken Salad";
        double quantity = 2.5;
        System.out.println("Order from HealthyShop retrieved");

        return new OrderRequest(healthyShop, product, quantity);
    }
}
