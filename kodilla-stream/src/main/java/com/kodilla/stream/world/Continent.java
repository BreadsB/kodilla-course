package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final String continentName;
    private final List<Country> countryList = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public void addCountry(Country country) {
        if(country!=null) {
            countryList.add(country);
        }
        else {
            System.out.println("Country is null");
        }
    }

    public boolean removeCountry(Country country) {
        if(countryList.contains(country)) {
            return countryList.remove(country);
        } else {
            System.out.println("No such country in continent");
            return false;
        }
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
