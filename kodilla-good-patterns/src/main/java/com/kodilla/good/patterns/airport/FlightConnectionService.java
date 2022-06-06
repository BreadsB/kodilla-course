package com.kodilla.good.patterns.airport;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightConnectionService {

    private final Set<Flight> flightRepository;

    public FlightConnectionService(final FlightRepository flightRepository) {
        this.flightRepository = flightRepository.getFlights();
    }

    public Set<Flight> findConnectionFrom(String airportName) {

        System.out.println("Find all flights from airport " + airportName);

        return flightRepository.stream()
            .filter(flight -> flight.getFlightFrom().equals(airportName))
            .collect(Collectors.toSet());
    }

    public Set<Flight> findConnectionTo(String airportName) {

        System.out.println("Find all flights to airport " + airportName);

        return flightRepository.stream()
            .filter(flight -> flight.getFlightTo().equals(airportName))
            .collect(Collectors.toSet());
    }

    public Set<Flight> findConnectionBetween(String airportFrom, String airportTo) {

        System.out.println("Find flights between "+ airportFrom + " and " + airportTo);

        Set<Flight> flightListTo = flightRepository.stream()
            .filter(flight -> flight.getFlightTo().equals(airportTo))
            .filter(flight -> flightRepository.stream()
                    .filter(flight1 -> flight1.getFlightFrom().equals(airportFrom))
                    .anyMatch(flight1 -> flight1.getFlightTo().equals(flight.getFlightFrom())))
            .collect(Collectors.toSet());

        Set<Flight> flightListFrom = flightRepository.stream()
            .filter(flight -> flight.getFlightFrom().equals(airportFrom))
            .filter(flight -> flightListTo.stream()
                    .anyMatch(flightTo -> flightTo.getFlightFrom().equals(flight.getFlightTo())))
            .collect(Collectors.toSet());

        return combineFlightLists(flightListFrom, flightListTo);
    }

    public Set<Flight> combineFlightLists(Set<Flight> flightList1, Set<Flight> flightList2) {

        Set<Flight> result = new HashSet<>();

        result.addAll(flightList1);
        result.addAll(flightList2);

        return result;
    }
}
