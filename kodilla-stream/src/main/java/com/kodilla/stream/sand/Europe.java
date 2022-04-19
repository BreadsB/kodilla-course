package com.kodilla.stream.sand;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Europe implements SandStorage {

    @Override
    public BigDecimal getSandBeansQuantity() {
        return new BigDecimal("12345678901234567890");
    }
}
