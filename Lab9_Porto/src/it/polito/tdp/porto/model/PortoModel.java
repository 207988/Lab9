package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.alg.EulerianCircuit;
import org.jgrapht.alg.HamiltonianCycle;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import com.mchange.v2.c3p0.stmt.GooGooStatementCache;

import it.polito.tdp.porto.db.ArticoloDAO;
import it.polito.tdp.porto.db.AutoreDAO;
import it.polito.tdp.porto.db.ProprietaDAO;

public class PortoModel {
	private boolean debug=true;
	private Map<Integer,Autore> elencoAutori=new HashMap<Integer,Autore>();
	private Map<Long,Articolo>elencoArticoli=new HashMap<Long,Articolo>();
	private List<Proprieta>elencoProprieta;
	private Multigraph<Autore,DefaultEdge> graph=new Multigraph<Autore,DefaultEdge>(DefaultEdge.class);
	//private Multigraph<Autore,ArcoArticolo> graph=new Multigraph<Autore,ArcoArticolo>(ArcoArticolo.class);
			
	public void caricaGrafo(){
		AutoreDAO audao=new AutoreDAO();
		ArticoloDAO ardao=new ArticoloDAO();
		ProprietaDAO prodao=new ProprietaDAO();
		
		//ottengo autori,articoli e proprieta
		for(Autore a:audao.trovaAutori())
			elencoAutori.put(a.getId(), a);
		for(Articolo a:ardao.trovaArticoli())
			elencoArticoli.put(a.getId(), a);		
		elencoProprieta=prodao.trovaProprieta();
		
		//aggiungo autori a grafo
		for(Autore a:elencoAutori.values()){
			graph.addVertex(a);
		}
		
		//collego autori ed articoli
		for(Proprieta p:elencoProprieta){
			Autore aut=elencoAutori.get(p.getCoautore());
			Articolo art=elencoArticoli.get(p.getArticolo());
			aut.aggiungiArticolo(art);
			art.aggiungiAutore(aut);
		}
		
		//aggiungo archi
		for(Articolo art:elencoArticoli.values()){
			for(Autore a1:art.getElencoAutori()){
				for(Autore a2:art.getElencoAutori()){
					if(a1!=a2){
						if(!graph.containsEdge(a1, a2))
							graph.addEdge(a1, a2);
						/*
						if(!graph.containsEdge(a1, a2)){					
							//graph.addEdge(a1, a2);
							ArcoArticolo dwe=graph.addEdge(a1, a2);
							dwe.aggiungiArticolo(art);						
						}
						else{
							ArcoArticolo arco=graph.getEdge(a1, a2);
							arco.aggiungiArticolo(art);
						}
						*/
					}
						
				}
			}
		}
		if(debug){
			System.out.println("Vertici: "+graph.vertexSet().size());
			System.out.println("Archi: "+graph.edgeSet().size());
		}
		
		
	}
	
	public List<Autore>getAutori(){
		List<Autore> temp= new ArrayList<Autore>(elencoAutori.values());		
		Collections.sort(temp);
		temp.add(0, new Autore(-1,"SELEZIONE","VUOTA"));		
		return temp;
	}
	
	public List<Autore> visualizzaCoautori(Autore aut){
		List<Autore>elencoAutori=new ArrayList<Autore>();
		for(Autore a:Graphs.neighborListOf(graph, aut))
			elencoAutori.add(a);
		if(debug)
			System.out.println(elencoAutori.size());
		return elencoAutori;
	}
	
	public String trovaCluster(){
		String s="";
		int nCluster=0;
		//grafo di appoggio
		Multigraph<Autore,DefaultEdge> graphTemp=graph;
		GraphIterator<Autore,DefaultEdge> visit;
		
		for(Autore a:elencoAutori.values()){
			if(graphTemp.containsVertex(a)){
				visit=new DepthFirstIterator<Autore,DefaultEdge>(graphTemp,a);
				s+="Cluster "+ ++nCluster+"\n\n";
				while(visit.hasNext()){
					Autore temp=visit.next();
					s+=temp.toString()+"\n";
					graphTemp.removeVertex(temp);
				}
				s+="-----------\n";
				if(debug)
					System.out.println(graphTemp.vertexSet().size());
				
			}
		}
		
		
		return s;
	}

}
