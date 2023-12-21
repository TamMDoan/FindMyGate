package com.passionproject.findmygate.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@EntityScan
public class Gate {
    private String name;
    private List<String> adjacentGates;

    public Gate(String name){
        this.name = name;
    }

    public Gate(String name, List<String> adjacentGates){
        this.name = name;
        this.adjacentGates = adjacentGates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAdjacentGates() {
        return adjacentGates;
    }

    public void setAdjacentGates(List<String> adjacentGates) {
        this.adjacentGates = adjacentGates;
    }
}
