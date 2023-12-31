package com.passionproject.findmygate.services;

import com.passionproject.findmygate.classes.GateGraph;
import com.passionproject.findmygate.entities.AdjacentGate;
import com.passionproject.findmygate.entities.Gate;
import com.passionproject.findmygate.repository.AdjacentGateRepository;
import com.passionproject.findmygate.repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class GateService {

    private GateRepository gateRepository;
    private AdjacentGateRepository adjacentGateRepository;

    @Autowired
    public GateService(GateRepository gateRepository, AdjacentGateRepository adjacentGateRepository){
        this.gateRepository = gateRepository;
        this.adjacentGateRepository = adjacentGateRepository;
    }

    public void testPrint(){
        System.out.println("Hello!");
    }

    public Gate getGate(String gate){
        return this.gateRepository.findByName(gate);
    }

    // TODO: Gates are stored in memory now... TBA Gates stored in database?
    public List<AdjacentGate> getAdjacentGates(String gateName){
        return GateGraph.getAdjacentGates(gateName);
    }

    public List<Gate> getShortestPath(String startGate, String destGate){
        Gate start = this.gateRepository.findByName(startGate);
        Gate dest = this.gateRepository.findByName(destGate);
        return calculate(start, dest);
    }

    private List<Gate> calculate(Gate s, Gate dest)
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
        Gate crawl = dest;//GateGraph.gates.get(dest);
        path.add(crawl);
        while (!pred.get(crawl).equals(s)) {
            path.add(pred.get(crawl));
            crawl = pred.get(crawl);
        }
        path.add(s);

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

    private boolean BFS(Gate src, Gate dest, Map<Gate, Gate> pred, Map<Gate, Integer> dist)
    {
        // queue to keep track of nodes that need to
        // have their adjacent nodes looked at
        LinkedList<Gate> queue = new LinkedList<>();

        // Map<String, Boolean> which stores the
        // information whether gateNode is reached
        // at least once in the BFS
        Map<Gate,Boolean> visited = new HashMap<>();

        // initially all nodes are unvisited
        // so setting values to false
        for(Gate key : this.gateRepository.findAll()/*GateGraph.gates.keySet()*/) {
            visited.put(key, false);
        }

        // src is first to be visited
        // putting src into queue to go through adjacentNodes
        // distance from source to itself should be 0
        visited.put(src, true);
        dist.put(src, 0);
        queue.add(src);

        // bfs Algorithm
        // while there's something in the queue
        while (!queue.isEmpty()) {
            // take the next node in the queue
            Gate vertex = queue.remove();
            // pull up all it's adjacent nodes to go through them
            for (AdjacentGate g : vertex.getAdjacentGates()) {
                // if we haven't visited this adjacent node yet
                if (!visited.get(g.getGate())) {
                    // add it to visited
                    visited.put(g.getGate(), true);

                    // put the distance of this adjacent
                    // node from the src into a map
                    dist.put(g.getGate(), dist.get(vertex) + 1);

                    // add adjacent node into pred map
                    // to keep track of it's predecessor
                    pred.put(g.getGate(), vertex);

                    // add the adjacent node into queue to
                    // look at it's adjacent nodes later
                    queue.add(g.getGate());

                    // stopping condition (when we find
                    // our destination)
                    if (g.getGate().equals(dest))
                        return true;
                }
            }
        }
        return false;
    }
}
