package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {
    private User user;
    private boolean orderAccepted;

    public OrderDto(final User user, boolean orderAccepted) {
        this.user = user;
        this.orderAccepted = orderAccepted;
    }

    public User getUser() {
        return user;
    }

    public boolean getOrderAccepted() {
        return orderAccepted;
    }
}
