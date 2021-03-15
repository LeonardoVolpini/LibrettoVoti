package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	
	//svolge il ruolo di Model

	private List<Voto> voti;
	private Map<String,Voto> votiMap; //identity Map
	
	public Libretto() {
		this.voti = new ArrayList<>(); //non serve ripetere <Voto>
		this.votiMap= new HashMap<>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
	}
	
	/*public List<Voto> listaVotiUguali (int punteggio) {
		//restituisco solo i voti uguali al criterio
		List<Voto> ris= new ArrayList<Voto>();
		for (Voto v : this.voti)
			if (v.getVoto()==punteggio)
				ris.add(v);
		return ris;		
	}*/
	
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
	
	public Voto cercaCorso (String nomeCorso) {
		return this.votiMap.get(nomeCorso);
	}
	
	/**
	 * Verifica se nel libretto c'e' gia' un'esame di un corso con lo stesso voto
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		/*boolean trovato =false;
		for (Voto vo: this.voti)
			if (v.getNome().equals(vo.getNome()) && v.getVoto()==vo.getVoto()) {
				trovato=true;
				break;
			}
		return trovato;*/
		Voto trovato=this.votiMap.get(v.getNome());
		if (trovato==null)
			return false;
		if(v.getVoto()==trovato.getVoto())
			return true;
		else
			return false;
	}
	
	/**
	 * Verifica se nel libretto c'e' gia' un'esame di un corso ma con voto diverso
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
		Voto trovato=this.votiMap.get(v.getNome());
		if (trovato==null)
			return false;
		if(v.getVoto()!=trovato.getVoto())
			return true;
		else
			return false;
	}
	
	public String toString() {
		String s="";
		for (Voto v : this.voti) {
			s = s + v.toString() + "\n";
		}
		return s; 
	}
}
