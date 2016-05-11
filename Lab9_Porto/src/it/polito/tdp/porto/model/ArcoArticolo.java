package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.graph.DefaultEdge;

public class ArcoArticolo extends DefaultEdge {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8294984538945480439L;
	
	private List<Articolo>elencoArticoli=new ArrayList<Articolo>();
	public List<Articolo> getArticoli() {
		return elencoArticoli;
	}
	public void aggiungiArticolo(Articolo a) {
		if(!elencoArticoli.contains(a))
			elencoArticoli.add(a);
	}



	

}
