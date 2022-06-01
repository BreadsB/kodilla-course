package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRetriever {

    public Order retrieve() {
        User user1 = new User("Mike", "Tyson");
        LocalDate orderDate = LocalDate.of(2022,6,20);
        List<BucketElement> bucketList = new ArrayList<>();
        bucketList.add(new BucketElement("Socks", 3));
        bucketList.add(new BucketElement("Glasses", 8));
        bucketList.add(new BucketElement("T-shirt", 1));

        return new Order(user1, orderDate, bucketList);
    }
}
