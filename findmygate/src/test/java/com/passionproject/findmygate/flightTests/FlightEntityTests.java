package com.passionproject.findmygate.flightTests;

import com.passionproject.findmygate.entities.Flight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlightEntityTests {

    @Test
    public void testFlightNullConstructor(){
        Flight flight = new Flight();
        assertNotNull(flight);
    }

}
