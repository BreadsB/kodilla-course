package com.kodilla.stream.sand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SandStorageTestSuite {
    @Test
    void testGetSandBeansQuantity() {
        Europe europe = new Europe();
        Asia asia = new Asia();
        Africa africa = new Africa();
        List<SandStorage> continentsList = new ArrayList<>();
        continentsList.add(europe);
        continentsList.add(asia);
        continentsList.add(africa);

        BigDecimal totalSand = BigDecimal.ZERO;
        for (SandStorage continent : continentsList) {
            totalSand = totalSand.add(continent.getSandBeansQuantity());
        }

        BigDecimal expectedSand = new BigDecimal("1111110234815061521515");
        Assertions.assertEquals(expectedSand, totalSand);
    }

    @Test
    void testGetSandBeansQuantityByReduce() {
        Europe europe = new Europe();
        Asia asia = new Asia();
        Africa africa = new Africa();
        List<SandStorage> continentsList = new ArrayList<>();
        continentsList.add(europe);
        continentsList.add(asia);
        continentsList.add(africa);

        BigDecimal totalSand = continentsList.stream()
                .map(SandStorage::getSandBeansQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        BigDecimal expectedSand = new BigDecimal("1111110234815061521515");
        Assertions.assertEquals(expectedSand, totalSand);
    }
}
