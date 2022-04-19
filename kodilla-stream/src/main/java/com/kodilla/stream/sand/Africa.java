package com.kodilla.stream.sand;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Africa implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        return new BigDecimal("999999123812592385735");
    }
}
