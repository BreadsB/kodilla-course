package com.kodilla.good.patterns.airport;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        FlightRepository flightRepository = new FlightRepository();
        flightRepository.createRepository();
        FlightConnectionService flightConnectionService = new FlightConnectionService(flightRepository);

        Set<Flight> flightList1 = flightConnectionService.findConnectionFrom("Krakow");

        Set<Flight> flightList2 = flightConnectionService.findConnectionTo("Gdansk");

        Set<Flight> flightList3 = flightConnectionService.findConnectionBetween("Krakow", "Gdansk");
        System.out.println(flightList3);
    }
}
