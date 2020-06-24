package it.polito.tdp.crimes.model;

public class VerticeEPeso implements Comparable<VerticeEPeso> {
Integer id;
Double peso;
public VerticeEPeso(Integer id, double peso) {
	super();
	this.id = id;
	this.peso = peso;
}
@Override
public int compareTo(VerticeEPeso o) {
	return this.peso.compareTo(o.peso);
}

}
