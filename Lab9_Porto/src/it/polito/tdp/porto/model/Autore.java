package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.List;

public class Autore implements Comparable<Autore> {

	private int id;
	private String cognome;
	private String nome;
	private List<Articolo> elencoArticoli = new ArrayList<Articolo>();
	
	public Autore(int id, String cognome, String nome) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public List<Articolo> getElencoArticoli() {
		return elencoArticoli;
	}
	
	public void aggiungiArticolo(Articolo a){
		elencoArticoli.add(a);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cognome+" "+nome;
	}

	@Override
	public int compareTo(Autore o) {
		int res=this.cognome.compareTo(o.cognome);
		if(res==0)
			res=this.nome.compareTo(o.nome);
		return res;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autore other = (Autore) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

	
	
	

}
