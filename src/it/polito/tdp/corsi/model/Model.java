package it.polito.tdp.corsi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {

	private List <Corso> corsi;
	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	
	public Model ()
	{
		this.corsoDAO = new CorsoDAO();
		this.studenteDAO = new StudenteDAO();
	}
	
	public List <Corso> listaCorsiSemestre (int pd)
	{
				
		// opzione 1: leggo tutto e filtro qui
/*		this.corsi = corsoDAO.listAll();
		List <Corso> risultato = new ArrayList<Corso>();
		
		for (Corso c : this.corsi)
		{
			if (c.getPd() == pd)
			{
				risultato.add(c);
			}
		}
		return risultato;
*/
		// opzione 2: lo fa il database
	
		List <Corso> risultato2 = corsoDAO.listByPD(pd);
		return risultato2;
	}

	public String getNomeCognomeByMatricola(int matricola) {
		
		Studente studente = studenteDAO.getStudenteByMatricola(matricola);
		if (studente==null)
		{
			return "Non ho trovato nessuno studente associato alla matricola "+matricola;
		}
		return studente.getNome()+" - "+studente.getCognome();
	}
	
	
}
