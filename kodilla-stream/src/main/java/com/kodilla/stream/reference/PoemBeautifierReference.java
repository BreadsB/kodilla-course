package com.kodilla.stream.reference;

public class PoemBeautifierReference {
    public static String lowerCases(String a) {
        char[] listOfChars = a.toCharArray();
        for (int x=0; x < a.length(); x++) {
            listOfChars[x] = Character.toLowerCase(listOfChars[x]);
        }
        return new String(listOfChars);
    }
}
