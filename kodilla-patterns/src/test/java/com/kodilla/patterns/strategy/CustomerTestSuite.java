package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.AggresivePredictor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTestSuite {

    @Test
    void testDefaultInvenstingStrategies() {
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new CorporateCustomer("Kodilla");

        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should buy: " + stevenShouldBuy);

        String johnShouldBuy = john.predict();
        System.out.println("John should buy: " + johnShouldBuy);

        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should buy: " + kodillaShouldBuy);

        Assertions.assertEquals("[Conservative Predictor] Buy debentures of XYZ", stevenShouldBuy);
        Assertions.assertEquals("[Aggresive predictor] Buy stock of XYZ",johnShouldBuy);
        Assertions.assertEquals("[Balanced predictor] Buy shared units of Fund XYZ",kodillaShouldBuy);
    }

    @Test
    void testIndividualInvestingStrategy() {
        Customer steven = new IndividualCustomer("Steven Links");

        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should buy: " + stevenShouldBuy);
        steven.setBuyingStrategy(new AggresivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven chose to buy: " + stevenShouldBuy);

        Assertions.assertEquals("[Aggresive predictor] Buy stock of XYZ", stevenShouldBuy);
    }
}
