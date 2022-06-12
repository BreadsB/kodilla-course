package com.kodilla.patterns.strategy.predictors;

import com.kodilla.patterns.strategy.BuyPredictor;

public class AggresivePredictor implements BuyPredictor {

    @Override
    public String predictWhatToBuy() {
        return "[Aggresive predictor] Buy stock of XYZ";
    }
}
