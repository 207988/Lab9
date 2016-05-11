package it.polito.tdp.porto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.porto.model.Articolo;


public class ArticoloDAO {
	
	public List<Articolo> trovaArticoli(){
			
			List<Articolo>elencoArticoli=new ArrayList<Articolo>();		
			Connection conn;
			try {
				conn = DBConnect.getConnection();
				String sql= "SELECT * FROM article;";			
				
				PreparedStatement st = conn.prepareStatement(sql);				
				
				ResultSet res=st.executeQuery();
				
				while(res.next()){
					Articolo a= new Articolo(res.getLong("eprintid"),res.getInt("year"),res.getString("title"));
					elencoArticoli.add(a);
				}				
				res.close();				
				return elencoArticoli;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
			
		}
}
