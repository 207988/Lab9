package it.polito.tdp.porto.model;

public class Proprieta {
	private int id;
	private long articolo;
	private int coautore;
	public Proprieta(int id, long articolo, int coautore) {
		super();
		this.id = id;
		this.articolo = articolo;
		this.coautore = coautore;
	}
	public int getId() {
		return id;
	}
	public long getArticolo() {
		return articolo;
	}
	public int getCoautore() {
		return coautore;
	}
	
	
}
