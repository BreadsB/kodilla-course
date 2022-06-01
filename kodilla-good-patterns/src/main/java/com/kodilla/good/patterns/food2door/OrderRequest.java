package com.kodilla.good.patterns.food2door;

public class OrderRequest {
    private ShopSupplier supplier;
    private String product;
    private double quantity;

    public OrderRequest(final ShopSupplier supplier, final String product, final double quantity) {
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }

    public ShopSupplier getSupplier() {
        return supplier;
    }

    public String getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }
}
