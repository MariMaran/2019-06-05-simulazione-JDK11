package it.polito.tdp.crimes.model;

import com.javadocmd.simplelatlng.LatLng;

public class VerticeEPosizione {
	
Integer id;
LatLng pos;

public VerticeEPosizione(int id, double lat, double longi) {
	this.id=id;
	pos=new LatLng(lat, longi);
}
}
