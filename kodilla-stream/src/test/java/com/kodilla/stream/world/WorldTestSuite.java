package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testPeopleQuantity() {

        //GIVEN
        World world = new World();

        //Continents
        Continent africa = new Continent("Africa");
        Continent northAmerica = new Continent("North America");
        Continent asia = new Continent("Asia");
        Continent europa = new Continent("Europa");

        //Europa Countries
        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country germany = new Country("Germany", new BigDecimal("80000000"));
        Country france = new Country("France", new BigDecimal("68000000"));
        Country spain = new Country("Spain", new BigDecimal("47000000"));

        //Asia Countries
        Country japan = new Country("Japan", new BigDecimal("125000000"));
        Country china = new Country("China", new BigDecimal("1402000000"));
        Country india = new Country("India", new BigDecimal("1380000000"));
        Country russia = new Country("Russia", new BigDecimal("144000000"));

        //Africa Countries
        Country egypt = new Country("Egypt", new BigDecimal("102000000"));
        Country kenia = new Country("Kenia", new BigDecimal("53000000"));
        Country algieria = new Country("Algieria", new BigDecimal("44000000"));
        Country angola = new Country("Angola", new BigDecimal("28000000"));

        //America Countries
        Country usa = new Country("USA", new BigDecimal("300000000"));
        Country canada = new Country("Canada", new BigDecimal("40000000"));
        Country mexico = new Country("Mexico", new BigDecimal("120000000"));

        africa.addCountry(egypt);
        africa.addCountry(kenia);
        africa.addCountry(algieria);
        africa.addCountry(angola);

        northAmerica.addCountry(usa);
        northAmerica.addCountry(canada);
        northAmerica.addCountry(mexico);

        europa.addCountry(poland);
        europa.addCountry(germany);
        europa.addCountry(france);
        europa.addCountry(spain);

        asia.addCountry(china);
        asia.addCountry(japan);
        asia.addCountry(russia);
        asia.addCountry(india);

        world.addContinent(africa);
        world.addContinent(northAmerica);
        world.addContinent(europa);
        world.addContinent(asia);

        //WHEN
        BigDecimal result = world.getPeopleQuantity();
        BigDecimal expected = new BigDecimal("3971000000");

        //THEN
        Assertions.assertEquals(expected, result);
    }
}
