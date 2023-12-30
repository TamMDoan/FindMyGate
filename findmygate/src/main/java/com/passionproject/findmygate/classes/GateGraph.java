package com.passionproject.findmygate.classes;

import com.passionproject.findmygate.entities.Gate;

import java.util.*;

/*
 *
 * GateGraph of the gates. Traversal is done within this class.
 */
public final class GateGraph {
//    private static class GateNode {
//
//        String gate;
//        // might turn this into a map of GateNode + position in respect to this
//        // for later, to add directions (go left/right/straight/etc)
//        // also means probably have to change what's being returned in shortestPath
//        // another map there too maybe
//        List<GateNode> adjacentGates;
//
//        public GateNode(String gate) {
//            this.gate = gate;
//            adjacentGates = new ArrayList<>();
//        }
//        // method for getting adjacent gates
//        // to be used later for traversal maybe?
//        public List<GateNode> getAdjacentGates(){
//            return this.adjacentGates;
//        }
//    }

    private static Map<String, Gate> gates = new HashMap<>();

    public GateGraph() {
        gates = new HashMap<>();
    }

    public static Gate getGate(String gateName){
        return gates.get(gateName);
    }

    public static void addGate(Gate gate) {
        GateGraph.gates.put(gate.getName(), gate);
    }

    public static void addAdjacentGate(Gate gate, Gate adjacentGate){
        GateGraph.gates.get(gate.getName()).getAdjacentGates().add(adjacentGate);
        GateGraph.gates.get(adjacentGate.getName()).getAdjacentGates().add(gate);
    }

    public int getNumberOfGates(){
        return GateGraph.gates.size();
    }

    public static List<Gate> getAdjacentGates(String gateName){
        return GateGraph.gates.get(gateName).getAdjacentGates();
    }

    // graph traversal will be in here
    // so that graphnodes won't be exposed
    public static List<Gate> getShortestPath(String s, String dest)
    {
        // these two maps will be used in bfs to get
        // nodes + their parents as well as distance

        // map of gate and it's predecessor
        Map<Gate, Gate> pred = new HashMap<>();
        // map of gate and how far it is from src gate
        Map<Gate, Integer> dist = new HashMap<>();

        if (!BFS(s, dest, pred, dist)) {
            System.out.println("Given source and destination" +
                    "are not connected");
            return null;
        }

        // LinkedList to store path (it'll be reverse)
        LinkedList<Gate> path = new LinkedList<>();
        // var used to move along the shortest route
        // to save to path
        Gate crawl = GateGraph.gates.get(dest);
        path.add(crawl);
        while (!pred.get(crawl).getName().equals(s)) {
            path.add(pred.get(crawl));
            crawl = pred.get(crawl);
        }
        path.add(GateGraph.gates.get(s));

        /*
        // Print distance
        System.out.println("Shortest path length is: " + path.size());

        // Print path */
        //System.out.println("Path is :");
        List<Gate> correctPathOrder = new LinkedList<>();
        for (int i = path.size() - 1; i >= 0; i--) {
            correctPathOrder.add(path.get(i));
        }
        return correctPathOrder;
    }

    // a modified version of BFS that stores predecessor
    // of each node in map pred
    // and its distance from source in map dist
    private static boolean BFS(String src, String dest, Map<Gate, Gate> pred, Map<Gate, Integer> dist)
    {
        // queue to keep track of nodes that need to
        // have their adjacent nodes looked at
        LinkedList<Gate> queue = new LinkedList<>();

        // Map<String, Boolean> which stores the
        // information whether gateNode is reached
        // at least once in the BFS
        Map<String,Boolean> visited = new HashMap<>();

        // initially all nodes are unvisited
        // so setting values to false
        for(String key : GateGraph.gates.keySet()) {
            visited.put(key, false);
        }

        // src is first to be visited
        // putting src into queue to go through adjacentNodes
        // distance from source to itself should be 0
        visited.put(src, true);
        dist.put(GateGraph.gates.get(src), 0);
        queue.add(GateGraph.gates.get(src));

        // bfs Algorithm
        // while there's something in the queue
        while (!queue.isEmpty()) {
            // take the next node in the queue
            Gate vertex = queue.remove();
            // pull up all it's adjacent nodes to go through them
            for (Gate g : vertex.getAdjacentGates()) {
                // if we haven't visited this adjacent node yet
                if (!visited.get(g.getName())) {
                    // add it to visited
                    visited.put(g.getName(), true);

                    // put the distance of this adjacent
                    // node from the src into a map
                    dist.put(g, dist.get(vertex) + 1);

                    // add adjacent node into pred map
                    // to keep track of it's predecessor
                    pred.put(g, vertex);

                    // add the adjacent node into queue to
                    // look at it's adjacent nodes later
                    queue.add(g);

                    // stopping condition (when we find
                    // our destination)
                    if (g.getName().equals(dest))
                        return true;
                }
            }
        }
        return false;
    }
}

