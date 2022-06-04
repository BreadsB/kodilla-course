package com.kodilla.good.patterns.airport;

import java.util.HashSet;
import java.util.Set;

public class FlightRepository {

    private final Set<Flight> flights = new HashSet<>();
    private final String KATOWICE_AIRPORT = "Katowice";
    private final String KRAKOW_AIRPORT = "Krakow";
    private final String WARSZAWA_AIRPORT = "Warszawa";
    private final String GDANSK_AIRPORT = "Gdansk";
    private final String RZESZOW_AIRPORT = "Rzeszow";
    private final String WROCLAW_AIRPORT = "Wroclaw";

    public void createRepository() {

        Flight flight1 = new Flight(KATOWICE_AIRPORT, KRAKOW_AIRPORT);
        Flight flight2 = new Flight(KATOWICE_AIRPORT, WARSZAWA_AIRPORT);
        Flight flight3 = new Flight(KATOWICE_AIRPORT, WROCLAW_AIRPORT);
        Flight flight4 = new Flight(KRAKOW_AIRPORT, KATOWICE_AIRPORT);
        Flight flight5 = new Flight(KRAKOW_AIRPORT, RZESZOW_AIRPORT);
        Flight flight6 = new Flight(KRAKOW_AIRPORT, WARSZAWA_AIRPORT);
        Flight flight7 = new Flight(GDANSK_AIRPORT, WARSZAWA_AIRPORT);
        Flight flight8 = new Flight(RZESZOW_AIRPORT, GDANSK_AIRPORT);
        Flight flight9 = new Flight(WARSZAWA_AIRPORT, KRAKOW_AIRPORT);
        Flight flight10 = new Flight(WARSZAWA_AIRPORT, GDANSK_AIRPORT);
        Flight flight11 = new Flight(WROCLAW_AIRPORT, GDANSK_AIRPORT);

        this.flights.add(flight1);
        this.flights.add(flight2);
        this.flights.add(flight3);
        this.flights.add(flight4);
        this.flights.add(flight5);
        this.flights.add(flight6);
        this.flights.add(flight7);
        this.flights.add(flight8);
        this.flights.add(flight9);
        this.flights.add(flight10);
        this.flights.add(flight11);
    }

    public Set<Flight> getFlights() {
        return flights;
    }

}
