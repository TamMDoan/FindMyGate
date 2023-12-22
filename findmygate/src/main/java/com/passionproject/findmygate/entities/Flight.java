package com.passionproject.findmygate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    int id;
    String airlineCode;
    String flightNumber;
    String destinationGate;
    String departureGate;

    // TODO: Maybe have a time factor in the app later


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestinationGate() {
        return destinationGate;
    }

    public void setDestinationGate(String destinationGate) {
        this.destinationGate = destinationGate;
    }

    public String getDepartureGate() {
        return departureGate;
    }

    public void setDepartureGate(String departureGate) {
        this.departureGate = departureGate;
    }
}
