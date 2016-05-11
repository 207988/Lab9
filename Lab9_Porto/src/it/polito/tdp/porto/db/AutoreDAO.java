package it.polito.tdp.porto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import it.polito.tdp.porto.model.Autore;

public class AutoreDAO {
	
	public List<Autore> trovaAutori(){
			
			List<Autore>elencoAutori=new ArrayList<Autore>();		
			Connection conn;
			try {
				conn = DBConnect.getConnection();
				String sql= "SELECT * FROM creator;";			
				
				PreparedStatement st = conn.prepareStatement(sql);				
				
				ResultSet res=st.executeQuery();
				
				while(res.next()){
					Autore a= new Autore(res.getInt("id_creator"),res.getString("family_name"),res.getString("given_name"));
					elencoAutori.add(a);
				}				
				res.close();				
				return elencoAutori;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
			
		}

}
