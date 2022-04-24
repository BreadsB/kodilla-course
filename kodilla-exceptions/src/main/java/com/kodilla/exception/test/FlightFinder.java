package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    private static Map<String, Boolean> flightMap = new HashMap<>();

    public void addFlight(Flight flight) {
        flightMap.put(flight.getArrivalAirport(), true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        System.out.println("We are looking for your flight. Please wait...");
        if (flightMap.containsKey(flight.getArrivalAirport()) && flightMap.get(flight.getArrivalAirport())) {
            System.out.println("Flight to: " + flight.getArrivalAirport() + " from: " + flight.getDepartureAirport() + ", has been found!");
        } else {
            throw new RouteNotFoundException();
        }
    }

    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        flightFinder.addFlight(new Flight("Frankfurt", "Warsaw"));
        flightFinder.addFlight(new Flight("Berlin", "Madrit"));
        flightFinder.addFlight(new Flight("Paris", "Warsaw"));

        try {
            Flight testFlight = new Flight("London", "Warsaw");
            flightFinder.findFlight(testFlight);
        } catch (RouteNotFoundException e) {
            System.out.println("Error - Flight not found!");
        } finally {
            System.out.println("Searching finished");
        }

        try {
            Flight testFlight2 = new Flight("Warsaw", "Berlin");
            flightFinder.findFlight(testFlight2);
        } catch (RouteNotFoundException e) {
            System.out.println("Error - Flight not found!");
        } finally {
            System.out.println("Searching finished");
        }
    }
}
