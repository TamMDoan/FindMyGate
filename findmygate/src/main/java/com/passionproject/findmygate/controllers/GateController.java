package com.passionproject.findmygate.controllers;

import com.passionproject.findmygate.entities.Gate;
import com.passionproject.findmygate.services.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/gate")
    public Gate getGate(@RequestParam(value = "gate") String gateName){
        return gateService.getGate(gateName);
    }
}
