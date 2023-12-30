package com.passionproject.findmygate.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="gate")

public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String terminal;

    /*
    * REREAD THIS! LOTS OF GOOD INFO YOU CAN PROBABLY USE,
    * ESPECIALLY WHEN YOU START ADDING POSITIONAL DATA
    * https://www.baeldung.com/jpa-many-to-many
     */
    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "adjacentGates",
            joinColumns = { @JoinColumn(name = "gate_id")},
            inverseJoinColumns = { @JoinColumn(name = "adjacent_id")}
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
    public List<Gate> getAdjacentGates() {
        return adjacentGates;
    }

    public void setAdjacentGates(List<Gate> adjacentGates) {
        this.adjacentGates = adjacentGates;
    }
    public void addAdjacentGate(Gate gate){
        this.adjacentGates.add(gate);
    }
}
