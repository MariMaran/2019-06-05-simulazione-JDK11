package it.polito.tdp.crimes.model;

import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;

public class TestModel {

	public static void main(String[] args) {
		Model m=new Model();
		m.creaGrafo(2015);
		Set<DefaultWeightedEdge> s=m.grafo.edgeSet();
		for(DefaultWeightedEdge d: s)
			System.out.println(m.grafo.getEdgeWeight(d));
		//System.out.println(m.getRes());
	}

}
