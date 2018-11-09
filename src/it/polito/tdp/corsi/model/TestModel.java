package it.polito.tdp.corsi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model();
		
		List <Corso> corsi = m.listaCorsiSemestre(2);
		
		for (Corso c : corsi)
			System.out.println(c);

		int matricola = 172040;
		String result = m.getNomeCognomeByMatricola(matricola);
		System.out.println("Matricola: "+matricola+" - nome cognome: "+result);
		
		result = m.getNomeCognomeByMatricola(172089);
		System.out.println("Matricola: 172089 - nome cognome: "+result);
	}

}
