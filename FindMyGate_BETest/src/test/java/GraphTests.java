import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class GraphTests {

    @Test
    public void testGraphConstructor() {
        Graph graph = new Graph();
        Assert.assertNotNull(graph);
    }

    @Test
    public void testGraphHasGatesWhenConstructed() {
        Graph graph = new Graph();
        Assert.assertNotNull(graph.getGates());
    }

    @Test
    public void testGraphAddGate() {
        String gate = "A1";
        Graph graph = new Graph();
        graph.addGate(gate);

        Assert.assertTrue(graph.getNumberOfGates() == 1);
    }

    @Test
    public void testGraphAddEdges() {
        Graph graph = new Graph();
        String gate = "A2";
        String adjGate = "A1";
        String adjGate2 = "A3";
    }

    @Test
    public void testBFS(){
        Graph graph = new Graph();
        String gate = "A1";
        String gate2 = "A2";
        String gate3 = "A3";
        String gate4 = "A4";
        String gate5 = "A5";
        String gate6 = "A6";
        String gate7 = "A7";
        graph.addGate(gate);
        graph.addGate(gate2);
        graph.addGate(gate3);
        graph.addGate(gate4);
        graph.addGate(gate5);
        graph.addGate(gate6);
        graph.addGate(gate7);
        graph.addAdjacentGate(gate, gate2);
        //graph.addAdjacentGate(gate, gate3);
        graph.addAdjacentGate(gate, gate7);
        graph.addAdjacentGate(gate2, gate3);
        graph.addAdjacentGate(gate3, gate5);
        graph.addAdjacentGate(gate4, gate5);
        graph.addAdjacentGate(gate4, gate7);
        graph.addAdjacentGate(gate5, gate6);
        Map<String, String> pred = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();

        //graph.BFS(gate6, gate, pred, dist);
        Assert.assertTrue(graph.BFS(gate6, gate, pred,dist));
        graph.printShortestDistance(gate6, gate);
    }

}
