package com.passionproject.findmygate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    @GetMapping
    public Object getFlightData(@RequestParam(value = "flightCode") String flightCode){
        // TODO: figure out how to call outside API, what we're returning (probably a flight),
        //  and how to hold JSON/response object + parse it into a flight entity (in the service)
        // calling outside api: WebClient
        // TODO: create a class for flight data, use that to put data into flight

        return null;
    }
}
