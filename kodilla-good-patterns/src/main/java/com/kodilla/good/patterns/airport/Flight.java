package com.kodilla.good.patterns.airport;

import java.util.Objects;

public class Flight {

    private String flightFrom;

    private String flightTo;

    public Flight(String inputFlightFrom, String inputFlightTo) {
        this.flightFrom = inputFlightFrom;
        this.flightTo = inputFlightTo;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightFrom, flight.flightFrom) && Objects.equals(flightTo, flight.flightTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightFrom, flightTo);
    }

    @Override
    public String toString() {
        return "Flight from: " + flightFrom + ", to: " + flightTo;
    }

}
