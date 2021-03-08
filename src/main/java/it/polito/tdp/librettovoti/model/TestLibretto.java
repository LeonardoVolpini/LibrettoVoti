package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.*;

public class TestLibretto {

	public static void main(String[] args) {
		
		System.out.println("Test metodi di Libretto:");
		Libretto libretto = new Libretto();

		Voto voto1 = new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15));
		libretto.add(voto1);
		libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 2)));
		libretto.add(new Voto("Informatica", 23, LocalDate.of(2019, 9, 1)));
		libretto.add(new Voto("Algebra", 20, LocalDate.of(2019, 2, 1)));
		libretto.add(new Voto("Chimica", 25, LocalDate.of(2019, 8, 21)));
		libretto.add(new Voto("Fisica 2", 25, LocalDate.of(2020, 9, 11)));
		System.out.println(libretto);
		
		//se uso metodo con listaVoti
		//List<Voto> venticinque = libretto.listaVotiUguali(25);
		//System.out.println(venticinque);
		
		//se uso metodo che return libretto
		Libretto libventicinque = libretto.votiUguali(25);
		System.out.println(libventicinque);
	}

}
