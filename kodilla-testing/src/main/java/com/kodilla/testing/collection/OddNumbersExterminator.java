package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbersList) {

        List<Integer> newList = new ArrayList<Integer>();

        if(numbersList.size()==0) {
            System.out.println("Empty List");
            return null;
        } else {
            for (Integer numbers : numbersList
            ) {
                if (numbers % 2 == 0) {
                    newList.add(numbers);
                }
            }
        }
        return newList;
    }
}
