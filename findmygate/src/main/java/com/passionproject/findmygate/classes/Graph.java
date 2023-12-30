//package com.passionproject.findmygate.classes;
//
//import java.util.*;
//
///*
// *
// * Graph of the gates. Traversal is done within this class.
// */
//public final class Graph {
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
//
//    private static Map<String, GateNode> gates = new HashMap<>();
//
//    public Graph() {
//        gates = new HashMap<>();
//    }
//
//    public static void addGate(String gate) {
//        GateNode newGate = new GateNode(gate);
//        Graph.gates.put(gate, newGate);
//    }
//
//    public static void addAdjacentGate(String gate, String adjacentGate){
//        Graph.gates.get(gate).adjacentGates.add(new GateNode(adjacentGate));
//        Graph.gates.get(adjacentGate).adjacentGates.add(new GateNode(gate));
//    }
//
//    public int getNumberOfGates(){
//        return Graph.gates.size();
//    }
//
//    public static List<String> getAdjacentGates(String gateName){
//        List<String> adjacentGatesNames = new ArrayList<>();
//        Graph.gates.get(gateName).adjacentGates.forEach(g -> adjacentGatesNames.add(g.gate));
//        return adjacentGatesNames;
//    }
//
//    // graph traversal will be in here
//    // so that graphnodes won't be exposed
//    public static List<String> getShortestPath(String s, String dest)
//    {
//        // these two maps will be used in bfs to get
//        // nodes + their parents as well as distance
//
//        // map of gate and it's predecessor
//        Map<String, String> pred = new HashMap<>();
//        // map of gate and how far it is from src gate
//        Map<String, Integer> dist = new HashMap<>();
//
//        if (!BFS(s, dest, pred, dist)) {
//            System.out.println("Given source and destination" +
//                    "are not connected");
//            return null;
//        }
//
//        // LinkedList to store path
//        LinkedList<String> path = new LinkedList<>();
//        // string used to move along the shortest route
//        // to save to path
//        String crawl = dest;
//        path.add(crawl);
//        while (!pred.get(crawl).equals(s)) {
//            path.add(pred.get(crawl));
//            crawl = pred.get(crawl);
//        }
//        path.add(s);
//
//        /*
//        // Print distance
//        System.out.println("Shortest path length is: " + path.size());
//
//        // Print path */
//        //System.out.println("Path is :");
//        List<String> correctPathOrder = new LinkedList<>();
//        for (int i = path.size() - 1; i >= 0; i--) {
//            correctPathOrder.add(path.get(i));
//        }
//        return correctPathOrder;
//    }
//
//    // a modified version of BFS that stores predecessor
//    // of each node in map pred
//    // and its distance from source in map dist
//    private static boolean BFS(String src, String dest, Map<String, String> pred, Map<String, Integer> dist)
//    {
//        // queue to keep track of nodes that need to
//        // have their adjacent nodes looked at
//        LinkedList<String> queue = new LinkedList<>();
//
//        // Map<String, Boolean> which stores the
//        // information whether gateNode is reached
//        // at least once in the BFS
//        Map<String,Boolean> visited = new HashMap<>();
//
//        // initially all nodes are unvisited
//        // so setting values to false
//        for(String key : Graph.gates.keySet()) {
//            visited.put(key, false);
//        }
//
//        // src is first to be visited
//        // putting src into queue to go through adjacentNodes
//        // distance from source to itself should be 0
//        visited.put(src, true);
//        dist.put(src, 0);
//        queue.add(src);
//
//        // bfs Algorithm
//        // while there's something in the queue
//        while (!queue.isEmpty()) {
//            // take the next node in the queue
//            String vertex = queue.remove();
//            // pull up all it's adjacent nodes to go through them
//            for (GateNode g : Graph.gates.get(vertex).getAdjacentGates()) {
//                // if we haven't visited this adjacent node yet
//                if (!visited.get(g.gate)) {
//                    // add it to visited
//                    visited.put(g.gate, true);
//
//                    // put the distance of this adjacent
//                    // node from the src into a map
//                    dist.put(g.gate, dist.get(vertex) + 1);
//
//                    // add adjacent node into pred map
//                    // to keep track of it's predecessor
//                    pred.put(g.gate, vertex);
//
//                    // add the adjacent node into queue to
//                    // look at it's adjacent nodes later
//                    queue.add(g.gate);
//
//                    // stopping condition (when we find
//                    // our destination)
//                    if (g.gate.equals(dest))
//                        return true;
//                }
//            }
//        }
//        return false;
//    }
//}
