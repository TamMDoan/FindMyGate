package com.passionproject.findmygate;

import com.passionproject.findmygate.classes.GateGraph;
import com.passionproject.findmygate.classes.Graph;
import com.passionproject.findmygate.entities.Gate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FindmygateApplication {

	public static void main(String[] args) {

		buildGraph();

		SpringApplication.run(FindmygateApplication.class, args);
	}

	public static void buildGraph(){
		//Graph Graph = new Graph();
		Gate gate1 = new Gate("A1");
		Gate gate2 = new Gate("A2");
		Gate gate3 = new Gate("A3");
		Gate gate4 = new Gate("A4");
		Gate gate5 = new Gate("A5");
		Gate gate6 = new Gate("A6");
		Gate gate7 = new Gate("A7");

		GateGraph.addGate(gate1);
		GateGraph.addGate(gate2);
		GateGraph.addGate(gate3);
		GateGraph.addGate(gate4);
		GateGraph.addGate(gate5);
		GateGraph.addGate(gate6);
		GateGraph.addGate(gate7);
		GateGraph.addAdjacentGate(gate1, gate2);
		GateGraph.addAdjacentGate(gate1, gate7);
		GateGraph.addAdjacentGate(gate1, gate3);
		GateGraph.addAdjacentGate(gate2, gate3);
		GateGraph.addAdjacentGate(gate3, gate5);
		GateGraph.addAdjacentGate(gate4, gate5);
		GateGraph.addAdjacentGate(gate4, gate7);
		GateGraph.addAdjacentGate(gate5, gate6);
	}
}
