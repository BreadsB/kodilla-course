package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.List;

public class OrderRepository {


    public void putOrderInRepository(User user, LocalDate orderDate, List<BucketElement> bucketElementList) {

        String bucketElements = bucketElementList.stream()
                        .map(node -> node.getElementName() + ", quantity: " + node.getElementQuantity())
                        .reduce("", (partialString, sum) -> partialString+sum+"\n");

        System.out.println("Added order in repository. \nUser: " + user.getFullName()
                + " | Order date: " + orderDate
                + " | Bucket list: " + bucketElements);
    }
}
