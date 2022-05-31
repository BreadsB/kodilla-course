package com.kodilla.good.patterns.challenges;

public class BucketElement {


    private String elementName;
    private int elementQuantity;
    public BucketElement(String elementName, int elementQuantity) {
        this.elementName = elementName;
        this.elementQuantity = elementQuantity;
    }

    public int getElementQuantity() {
        return elementQuantity;
    }

    public String getElementName() {
        return elementName;
    }
}
