package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order {

    private User user;
    private List<BucketElement> bucketList;
    private LocalDate orderDate;

    public Order(User user, LocalDate orderDate, List<BucketElement> bucketList) {
        this.user = user;
        this.orderDate = orderDate;
        this.bucketList = bucketList;
    }

    public User getUser() {
        return user;
    }

    public List<BucketElement> getBucketList() {
        return bucketList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(user, order.user) && Objects.equals(bucketList, order.bucketList) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, bucketList, orderDate);
    }
}
