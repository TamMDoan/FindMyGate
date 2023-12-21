package com.passionproject.findmygate.gateTests;

import com.passionproject.findmygate.entities.Gate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class gateEntityTests {

    @Test
    public void testGateNullConstructor(){
        Gate gate = new Gate();
        assertNotNull(gate);
    }

    @Test
    public void testGateNameConstructor(){
        Gate gate = new Gate("A1");
        assertNotNull(gate);
        assertTrue(gate.getName().equals("A1"));
    }

    @Test
    public void testGateFullConstructor(){
        String gateName = "A1";
        String terminal = "A";
        List<String> adjacentGates = new ArrayList<>();
        Gate gate = new Gate(gateName, terminal, adjacentGates);

        assertNotNull(gate);
        assertEquals(gateName, gate.getName());
        assertEquals(terminal, gate.getTerminal());
        assertEquals(adjacentGates, gate.getAdjacentGates());
    }

    @Test
    public void testGateGetName(){
        String gateName = "A1";
        Gate gate = new Gate(gateName);
        assertTrue(gate.getName().equals(gateName));
    }

    @Test
    public void testGataeGetAdjacentGates(){
        String gateName = "A1";
        String terminal = "A";
        String gateNeighbor = "A2";
        List<String> adjacentGates = new ArrayList<>();
        adjacentGates.add(gateNeighbor);
        Gate gate = new Gate(gateName, terminal, adjacentGates);

        assertEquals(adjacentGates.size(), gate.getAdjacentGates().size());
        assertEquals(adjacentGates, gate.getAdjacentGates());
    }
}
