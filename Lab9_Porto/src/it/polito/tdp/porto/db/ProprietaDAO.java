package it.polito.tdp.porto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.porto.model.Proprieta;


public class ProprietaDAO {
	
	public List<Proprieta> trovaProprieta(){
			
			List<Proprieta>elencoProprieta=new ArrayList<Proprieta>();		
			Connection conn;
			try {
				conn = DBConnect.getConnection();
				String sql= "SELECT * FROM authorship;";			
				
				PreparedStatement st = conn.prepareStatement(sql);				
				
				ResultSet res=st.executeQuery();
				
				while(res.next()){
					Proprieta p=new Proprieta(res.getInt("id_authorship"),res.getLong("eprintid"),res.getInt("id_creator"));
					elencoProprieta.add(p);
				}				
				res.close();				
				return elencoProprieta;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
			
		}
}