package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        Bigmac doubleCheese = new Bigmac.BigmacBuilder()
                .bun("Bun with sesame")
                .sauce("standard")
                .burgers(2)
                .ingredient(Ingredients.CHEESE)
                .ingredient(Ingredients.CHEESE)
                .ingredient(Ingredients.ONION)
                .ingredient(Ingredients.CUCUMBER)
                .build();

        Assertions.assertEquals(2, doubleCheese.getBurgers());
        Assertions.assertTrue(doubleCheese.getIngredients().contains("Onion"));
        Assertions.assertEquals("standard", doubleCheese.getSauce());
        Assertions.assertEquals("Bun with sesame", doubleCheese.getBun());
    }
}
