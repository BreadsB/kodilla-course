package com.kodilla.good.patterns.airport;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        FlightRepository flightRepository = new FlightRepository();
        flightRepository.createRepository();
        FlightConnectionService flightConnectionService = new FlightConnectionService(flightRepository);

        flightConnectionService.findConnectionFrom("Krakow");

        flightConnectionService.findConnectionTo("Gdansk");

        flightConnectionService.findConnectionBetween("Krakow", "Gdansk");

    }
}
