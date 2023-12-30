package com.passionproject.findmygate.services;

import com.passionproject.findmygate.classes.GateGraph;
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

    public Gate getGate(String gate){
        return GateGraph.getGate(gate);
    }

    // TODO: Gates are stored in memory now... TBA Gates stored in database?
    public List<Gate> getAdjacentGates(String gateName){
        return GateGraph.getAdjacentGates(gateName);
    }

    public List<Gate> getShortestPath(String startGate, String destGate){
        return GateGraph.getShortestPath(startGate, destGate);
    }
}
