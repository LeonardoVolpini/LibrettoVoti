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
	
	public List<Voto> listaVotiUguali (int punteggio) {
		//restituisco solo i voti uguali al criterio
		List<Voto> ris= new ArrayList<Voto>();
		for (Voto v : this.voti)
			if (v.getVoto()==punteggio)
				ris.add(v);
		return ris;		
	}
	
	public Libretto votiUguali(int punteggio) {
		//restituisco solo i voti uguali al criterio
		Libretto ris = new Libretto();
		for (Voto v : this.voti) {
			if (v.getVoto()==punteggio) {
				ris.add(v);
			}
		}
		return ris;
	}
	
	public String toString() {
		String s="";
		for (Voto v : this.voti) {
			s = s + v.toString() + "\n";
		}
		return s; 
	}
}
