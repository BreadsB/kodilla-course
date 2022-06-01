package com.kodilla.good.patterns.food2door;

public final class OrderDto {

    private final ShopSupplier supplier;
    private final String productName;
    private final double quantity;

    public OrderDto(final ShopSupplier shopSupplier, final String productName, final double quantity) {
        this.supplier = shopSupplier;
        this.productName = productName;
        this.quantity = quantity;
    }

}
