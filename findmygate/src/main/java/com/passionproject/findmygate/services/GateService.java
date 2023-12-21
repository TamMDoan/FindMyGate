package com.passionproject.findmygate.services;

import com.passionproject.findmygate.classes.Graph;
import com.passionproject.findmygate.entities.Gate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GateService {

    public void testPrint(){
        System.out.println("Hello!");
    }

    public List<String> getAdjacentGates(String gateName){
        //return adjacentGateRepository.findAllByNameIs(gateName);
        //return gateRepository.findGateByName(gateName).getAdjacentGates();
        return Graph.getAdjacentGates(gateName);
    }

    public List<String> getShortestPath(String startGate, String destGate){
        return Graph.getShortestDistance(startGate, destGate);
    }
}
