package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>(); //non serve ripetere <Voto>
	}
	
	public void add(Voto v) {
		this.voti.add(v);
	}
	
	public String toString() {
		String s="";
		for (Voto v : this.voti) {
			s = s + v.toString() + "\n";
		}
		return s; 
	}
}
