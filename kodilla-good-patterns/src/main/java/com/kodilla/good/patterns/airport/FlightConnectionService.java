package com.kodilla.good.patterns.airport;

import java.util.Set;
import java.util.stream.Collectors;

public class FlightConnectionService {

    private final Set<Flight> flightRepository;

    public FlightConnectionService(final FlightRepository flightRepository) {
        this.flightRepository = flightRepository.getFlights();
    }

    public void findConnectionFrom(String airportName) {
        System.out.println("Find all flights from airport " + airportName);

        flightRepository.stream()
            .filter(flight -> flight.getFlightFrom().equals(airportName))
            .forEach(flight -> System.out.println("Flight from " + airportName + " to " + flight.getFlightTo()));
    }

    public void findConnectionTo(String airportName) {
        System.out.println("Find all flights to airport " + airportName);

        flightRepository.stream()
                .filter(flight -> flight.getFlightTo().equals(airportName))
                .forEach(flight -> System.out.println("Flight from " + flight.getFlightFrom() + " to " + flight.getFlightTo()));
    }

    public void findConnectionBetween(String airportFrom, String airportTo) {

        System.out.println("Find flights between "+ airportFrom + " and " + airportTo);

        Set<Flight> flightListTo = flightRepository.stream()
                        .filter(flight -> flight.getFlightTo().equals(airportTo))
                        .collect(Collectors.toSet());

        flightRepository.stream()
                .filter(flight -> flight.getFlightFrom().equals(airportFrom))
                .filter(flight -> flightListTo.stream()
                        .anyMatch(flightTo -> flightTo.getFlightFrom().equals(flight.getFlightTo())))
                .forEach(flight -> System.out.println("Found flight through: " + flight.getFlightTo()));
    }
}
