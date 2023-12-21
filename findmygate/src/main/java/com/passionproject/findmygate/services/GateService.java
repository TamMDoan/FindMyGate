package com.passionproject.findmygate.services;

import com.passionproject.findmygate.entities.Gate;
import com.passionproject.findmygate.repositories.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GateService {

    private final GateRepository gateRepository;

    @Autowired
    public GateService(GateRepository gateRepository){
        this.gateRepository = gateRepository;
    }

    public void testPrint(){
        System.out.println("Hello!");
    }

    private boolean BFS(String src, String dest, Map<String, String> pred, Map<String, Integer> dist){
        return false;
    }

    public Gate getGate(String gateName) {
       // Gate gate = gateRepository.findGateByName(gateName);
//        String formatterString = "Gate is: %s\nTerminal is: %s";
//        System.out.printf(formatterString, gate.getName(), gate.getTerminal());

        return gateRepository.findGateByName(gateName);
    }
}
