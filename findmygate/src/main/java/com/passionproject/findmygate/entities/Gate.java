package com.passionproject.findmygate.entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="gate")

public class Gate {
    @Id
    private String name;
    private String terminal;

    @ManyToMany(cascade =  { CascadeType.ALL })
    @JoinTable(
            name = "adjacentGates",
            joinColumns = { @JoinColumn(name = "name")},
            inverseJoinColumns = { @JoinColumn(name = "gateName")}
    )
    private List<Gate> adjacentGates;

    public Gate(){
        this.name = "";
        this.terminal = "";
        this.adjacentGates = new ArrayList<>();
    }

    public Gate(String name){
        this.name = name;
        this.adjacentGates = new ArrayList<>();
    }

    public Gate(String name, String terminal, List<Gate> adjacentGates){
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

    // TODO: figure out whether it's better to have getAdjacentGates here or if you
    // TODO: should use the repository to get adjacent gates
    public List<Gate> getAdjacentGates() {
        return adjacentGates;
    }

    public void setAdjacentGates(List<Gate> adjacentGates) {
        this.adjacentGates = adjacentGates;
    }
}
