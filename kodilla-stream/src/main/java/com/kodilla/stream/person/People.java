package com.kodilla.stream.person;

import java.util.ArrayList;
import java.util.List;

public final class People {
    public static List<String> getList() {
        final List<String> theList = new ArrayList<>();
        theList.add("Marek Trebusz");
        theList.add("Jordan Mathew");
        theList.add("Blaze Brick");
        theList.add("Tony Parker");
        theList.add("Ronald Wesley");
        theList.add("Tonny Smith");
        theList.add("Robin Jersey");
        theList.add("David Beckham");
        theList.add("Mark Walberg");
        theList.add("Vin Disel");
        theList.add("Anna Hathway");

        return new ArrayList<>(theList);
    }
}
