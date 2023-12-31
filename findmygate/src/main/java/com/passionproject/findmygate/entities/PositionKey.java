package com.passionproject.findmygate.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class PositionKey implements Serializable{

    @Column(name = "gate_id")
    int gateId;

    @Column(name = "adjacent_id")
    int adjacentId;

    public PositionKey(int gateId, int adjacentId) {
        this.gateId = gateId;
        this.adjacentId = adjacentId;
    }

    public PositionKey(){}

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getAdjacentId() {
        return adjacentId;
    }

    public void setAdjacentId(int adjacentId) {
        this.adjacentId = adjacentId;
    }


}
