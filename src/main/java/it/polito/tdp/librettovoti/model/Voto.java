package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

//il commento fatto come sotto lo si legge passando col mouse su Voto di public class
/**
 * Memorizza il risultato di un esame
 * @author Leo Volpe
 *
 */
public class Voto {
	
	private String nome;
	private int voto; //30L rappresento come?
	private LocalDate data; //data superamento esame
	
	public Voto(String nome, int voto, LocalDate data) {
		//super();
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Esame "+ nome + " superato con "+voto+" il "+data;
	}
	
	
	
}
