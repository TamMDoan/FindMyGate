package com.passionproject.findmygate.controllers;

import com.passionproject.findmygate.entities.Gate;
import com.passionproject.findmygate.services.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GateController {

    private final GateService gateService;

    @Autowired
    public GateController(GateService gateService){
        this.gateService = gateService;
    }

    @GetMapping("/path")
    public void getPathToGate(@RequestParam(value = "startGate") String startGate, @RequestParam(value = "destGate") String destGate){
        gateService.testPrint();
    }

    @GetMapping("/neighbors")
    public List<String> getAdjacentGates(@RequestParam(value = "gate") String gateName){
        return gateService.getAdjacentGates(gateName);
    }

    @GetMapping("/navigation")
    public List<String> getShortestPath(@RequestParam(value = "startGate") String startGate, @RequestParam(value = "destGate") String destGate){
        return gateService.getShortestPath(startGate, destGate);
    }
}
