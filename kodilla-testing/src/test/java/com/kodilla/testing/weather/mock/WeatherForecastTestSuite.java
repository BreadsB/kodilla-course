package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private static Temperatures temperaturesMock;

    @DisplayName("Start test suite")
    @BeforeAll
    static void beforeAll() {
        System.out.println("Testing started");
    }

    @DisplayName("Finish test suite")
    @AfterAll
    static void afterAll() {
        System.out.println("Testing finished");
    }

    @DisplayName("Test - checking the quantity of sensors, using Mock")
    @Test
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Cieszyn", 25.0);
        temperaturesMap.put("Krakow", 26.0);
        temperaturesMap.put("Wroclaw", 27.0);
        temperaturesMap.put("Katowice", 28.0);
        temperaturesMap.put("Rzeszow", 29.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @DisplayName("Test - calculating average temperature using Mock")
    @Test
    void testCalculateAverageTemperature() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Cieszyn", 25.0);
        temperaturesMap.put("Krakow", 26.0);
        temperaturesMap.put("Wroclaw", 27.0);
        temperaturesMap.put("Katowice", 28.0);
        temperaturesMap.put("Rzeszow", 29.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        Double temperatureAverage = weatherForecast.calculateAverageTemperature();

        //Then
        Assertions.assertEquals(27.0, temperatureAverage);
    }

    @DisplayName("Test - calculating median from odd number of temperatures measurement")
    @Test
    void testCalculateOddsTemperatureMedian() {
        //GIVEN
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Cieszyn", 25.0);
        temperaturesMap.put("Krakow", 26.0);
        temperaturesMap.put("Wroclaw", 27.0);
        temperaturesMap.put("Katowice", 28.0);
        temperaturesMap.put("Rzeszow", 29.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //WHEN
        double median = weatherForecast.calculateTemperatureMedian();

        //THEN
        Assertions.assertEquals(27.0, median);
    }

    @DisplayName("Test - calculating median from even number of temperatures measurement")
    @Test
    void testCalculateEvenTemperaturesMedian() {
        //GIVEN
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Cieszyn", 25.0);
        temperaturesMap.put("Krakow", 26.0);
        temperaturesMap.put("Wroclaw", 27.0);
        temperaturesMap.put("Katowice", 28.0);
        temperaturesMap.put("Rzeszow", 29.0);
        temperaturesMap.put("Warszawa", 30.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //WHEN
        double median = weatherForecast.calculateTemperatureMedian();

        //THEN
        Assertions.assertEquals(27.5, median);
    }
}