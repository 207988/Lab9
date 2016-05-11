package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.List;

public class Articolo {
	private long id;
	private int anno;
	private String titolo;
	private List<Autore>elencoAutori=new ArrayList<Autore>();
	
	public Articolo(long id, int anno, String titolo) {
		super();
		this.id = id;
		this.anno = anno;
		this.titolo = titolo;
	}
	public long getId() {
		return id;
	}
	public int getAnno() {
		return anno;
	}
	public String getTitolo() {
		return titolo;
	}
	
	public void aggiungiAutore(Autore a){
		elencoAutori.add(a);
	}
	public List<Autore> getElencoAutori() {
		return elencoAutori;
	}
	
	

}
