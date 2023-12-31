package com.passionproject.findmygate.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="gate")
public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String terminal;

    /*
    * REREAD THIS! LOTS OF GOOD INFO YOU CAN PROBABLY USE,
    * ESPECIALLY WHEN YOU START ADDING POSITIONAL DATA
    * https://www.baeldung.com/jpa-many-to-many
     */
    @OneToMany(mappedBy = "gate")
    private List<AdjacentGate> adjacentGates;

    public Gate(){
        this.name = "";
        this.terminal = "";
        this.adjacentGates = new ArrayList<>();
    }

    public Gate(String name){
        this.name = name;
        this.adjacentGates = new ArrayList<>();
    }

    public Gate(String name, String terminal, List<AdjacentGate> adjacentGates){
        this.name = name;
        this.terminal = terminal;
        this.adjacentGates = adjacentGates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public List<AdjacentGate> getAdjacentGates() {
        return adjacentGates;
    }

    public void setAdjacentGates(List<AdjacentGate> adjacentGates) {
        this.adjacentGates = adjacentGates;
    }
    public void addAdjacentGate(AdjacentGate gate){
        this.adjacentGates.add(gate);
    }
}
