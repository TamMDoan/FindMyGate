package com.passionproject.findmygate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Gate {
    @Id
    private String name;
    private String terminal;
    private List<String> adjacentGates;

    public Gate(){
        this.name = "";
        this.terminal = "";
        this.adjacentGates = new ArrayList<>();
    }

    public Gate(String name){
        this.name = name;
        this.adjacentGates = new ArrayList<>();
    }

    public Gate(String name, String terminal, List<String> adjacentGates){
        this.name = name;
        this.terminal = terminal;
        this.adjacentGates = adjacentGates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public List<String> getAdjacentGates() {
        return adjacentGates;
    }

    public void setAdjacentGates(List<String> adjacentGates) {
        this.adjacentGates = adjacentGates;
    }
}
