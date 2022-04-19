package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country implements Residents{
    private final String countryName;
    private final BigDecimal countryResidentsQuantity;

    public Country(final String countryName, final BigDecimal countryResidentsQuantity) {
        this.countryName = countryName;
        this.countryResidentsQuantity = countryResidentsQuantity;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getPeopleQuantity() {
        return countryResidentsQuantity;
    }
}
