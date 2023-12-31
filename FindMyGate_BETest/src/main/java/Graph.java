import java.util.*;

public class Graph {

    private class GateNode {

        String gate;
        List<GateNode> adjacentGates;

        public GateNode(String gate) {
            this.gate = gate;
            adjacentGates = new ArrayList<>();
        }
        // method for getting adjacent gates
        // to be used later for traversal maybe?
        public List<GateNode> getAdjacentGates(){
            return this.adjacentGates;
        }
    }

    Map<String, GateNode> gates;

    public Graph() {
        gates = new HashMap<>();
    }

    public List<String> getGates() {
        return new ArrayList<>(this.gates.keySet());
    }

    public void addGate(String gate) {
        GateNode newGate = new GateNode(gate);
        this.gates.put(gate, newGate);
    }

    public void addAdjacentGate(String gate, String adjacentGate){
        this.gates.get(gate).adjacentGates.add(new GateNode(adjacentGate));
        this.gates.get(adjacentGate).adjacentGates.add(new GateNode(gate));
    }

    public int getNumberOfGates(){
        return this.gates.size();
    }

    // graph traversal will be in here
    // so that graphnodes won't be exposed
    public void printShortestDistance(String s, String dest)
    {
        // these two maps will be used in bfs to get
        // nodes + their parents as well as distance

        // map of gate and it's predecessor
        Map<String, String> pred = new HashMap<>();
        // map of gate and how far it is from src gate
        Map<String, Integer> dist = new HashMap<>();

        if (!BFS(s, dest, pred, dist)) {
            System.out.println("Given source and destination" +
                    "are not connected");
            return;
        }

        // LinkedList to store path
        LinkedList<String> path = new LinkedList<>();
        // string used to move along the shortest route
        // to save to path
        String crawl = dest;
        path.add(crawl);
        while (!pred.get(crawl).equals(s)) {
            path.add(pred.get(crawl));
            crawl = pred.get(crawl);
        }
        path.add(s);

        // Print distance
        System.out.println("Shortest path length is: " + path.size());

        // Print path
        System.out.println("Path is :");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    // a modified version of BFS that stores predecessor
    // of each node in map pred
    // and its distance from source in map dist
    public boolean BFS(String src, String dest, Map<String, String> pred, Map<String, Integer> dist)
    {
        // queue to keep track of nodes that need to
        // have their adjacent nodes looked at
        LinkedList<String> queue = new LinkedList<>();

        // Map<String, Boolean> which stores the
        // information whether gateNode is reached
        // at least once in the BFS
        Map<String,Boolean> visited = new HashMap<>();

        // initially all nodes are unvisited
        // so setting values to false
        for(String key : this.gates.keySet()) {
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
            String vertex = queue.remove();
            // pull up all it's adjacent nodes to go through them
            for (GateNode g : this.gates.get(vertex).getAdjacentGates()) {
                // if we haven't visited this adjacent node yet
                if (!visited.get(g.gate)) {
                    // add it to visited
                    visited.put(g.gate, true);

                    // put the distance of this adjacent
                    // node from the src into a map
                    dist.put(g.gate, dist.get(vertex) + 1);

                    // add adjacent node into pred map
                    // to keep track of it's predecessor
                    pred.put(g.gate, vertex);

                    // add the adjacent node into queue to
                    // look at it's adjacent nodes later
                    queue.add(g.gate);

                    // stopping condition (when we find
                    // our destination)
                    if (g.gate.equals(dest))
                        return true;
                }
            }
        }
        return false;
    }

}
