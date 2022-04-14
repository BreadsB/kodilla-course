package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }

        return resultMap;
    }

    public double calculateAverageTemperature() {
        Double averageTemperatureSum = 0.0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            averageTemperatureSum += temperature.getValue();
        }
        return averageTemperatureSum / temperatures.getTemperatures().size();
    }

    public double calculateTemperatureMedian() {
        List<Double> listOfTemperatures = new ArrayList<>();
        for ( Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            listOfTemperatures.add(temperature.getValue());
        }
        Collections.sort(listOfTemperatures);
        int l = listOfTemperatures.size();
        if (listOfTemperatures.size()%2==0) {
            double a = listOfTemperatures.get(l/2);
            double b = listOfTemperatures.get(((l/2)-1));
            return (a+b)/2;
        } else {
            return listOfTemperatures.get((l-1)/2);
        }
    }
}