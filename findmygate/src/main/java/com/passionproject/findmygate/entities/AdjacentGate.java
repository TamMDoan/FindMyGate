package com.passionproject.findmygate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class AdjacentGate {

    @EmbeddedId
    PositionKey positionKey;

    @JsonIgnore
    @ManyToOne
    @MapsId("gateId")
    @JoinColumn(name = "gate_id")
    Gate gate;

    @JsonIgnore
    @ManyToOne
    @MapsId("adjacentId")
    @JoinColumn(name = "adjacent_id")
    Gate adjacentGate;

    String position;

    public AdjacentGate(Gate gate, Gate adjacentGate, String position) {
        this.gate = gate;
        this.adjacentGate = adjacentGate;
        this.position = position;
    }

    public AdjacentGate(){}

    public String getName(){
        return adjacentGate.getName();
    }

    public Gate getGate(){
        return adjacentGate;
    }

}
