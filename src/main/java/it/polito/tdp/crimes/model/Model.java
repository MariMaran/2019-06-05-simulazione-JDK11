package it.polito.tdp.crimes.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	EventsDao dao;
	Graph<Integer, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao=new EventsDao();
	}
	
	public void creaGrafo(int anno) {
		grafo=new SimpleWeightedGraph(DefaultWeightedEdge.class);
		List<Integer> vertici=dao.getDistretto();
		for(Integer i: vertici) {
			grafo.addVertex(i);
		}
		List<VerticeEPosizione> list=dao.getPos(anno);
		for(VerticeEPosizione v1: list) {
			for(VerticeEPosizione v2: list) {
				double d=LatLngTool.distanceInRadians(v1.pos, v2.pos);
				if(!v1.equals(v2)) {
				grafo.addEdge(v1.id, v2.id);
				grafo.setEdgeWeight(v1.id, v2.id, d);
				}
			}
		}
		
	}
	
	public String getRes() {
		String res="";
		List<VerticeEPeso> list=new ArrayList();
		List<Integer> vertici=new ArrayList(grafo.vertexSet());
		for(Integer i: vertici) {
			res=res+"Vertice "+i+"\n";
			for(DefaultWeightedEdge e: grafo.edgesOf(i)) {
				list.add(new VerticeEPeso(Graphs.getOppositeVertex(grafo, e, i),grafo.getEdgeWeight(e)));
			}
			Collections.sort(list);
			for(VerticeEPeso v: list) {
				res=res+v.id+" "+v.peso+"\n";
			}
			list.clear();
			res=res+"\n";
		}
		return res;
	}
	
}
