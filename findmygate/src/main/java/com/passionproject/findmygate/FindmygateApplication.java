package com.passionproject.findmygate;

import com.passionproject.findmygate.classes.Graph;
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
		String gate1 = "A1";
		String gate2 = "A2";
		String gate3 = "A3";
		String gate4 = "A4";
		String gate5 = "A5";
		String gate6 = "A6";
		String gate7 = "A7";
		Graph.addGate(gate1);
		Graph.addGate(gate2);
		Graph.addGate(gate3);
		Graph.addGate(gate4);
		Graph.addGate(gate5);
		Graph.addGate(gate6);
		Graph.addGate(gate7);
		Graph.addAdjacentGate(gate1, gate2);
		Graph.addAdjacentGate(gate1, gate7);
		Graph.addAdjacentGate(gate1, gate3);
		Graph.addAdjacentGate(gate2, gate3);
		Graph.addAdjacentGate(gate3, gate5);
		Graph.addAdjacentGate(gate4, gate5);
		Graph.addAdjacentGate(gate4, gate7);
		Graph.addAdjacentGate(gate5, gate6);
	}
}
