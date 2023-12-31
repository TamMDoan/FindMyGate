package com.passionproject.findmygate.controllers;

import com.passionproject.findmygate.entities.AdjacentGate;
import com.passionproject.findmygate.entities.Gate;
import com.passionproject.findmygate.services.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gate")
@CrossOrigin(origins = "http://localhost:4200")
public class GateController {

    private final GateService gateService;

    @Autowired
    public GateController(GateService gateService){
        this.gateService = gateService;
    }

    // This is just a test method to see if api is working...
    @GetMapping("/path")
    public void getPathToGate(@RequestParam(value = "startGate") String startGate, @RequestParam(value = "destGate") String destGate){
        gateService.testPrint();
    }

    @GetMapping("/find")
    public Gate getGate(@RequestParam(value = "gate") String gate){
        return gateService.getGate(gate);
    }

    // Get list of adjacent gates as strings
    @GetMapping("/neighbors")
    public List<AdjacentGate> getAdjacentGates(@RequestParam(value = "gate") String gateName){
        return gateService.getAdjacentGates(gateName);
    }

    // Get list of gates (strings) leading from startGate to destGate
    @GetMapping("/navigation")
    public List<Gate> getShortestPath(@RequestParam(value = "startGate") String startGate, @RequestParam(value = "destGate") String destGate){
        return gateService.getShortestPath(startGate, destGate);
    }
}
