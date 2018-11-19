package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Studente;

public class StudenteDAO {

	public Studente getStudenteByMatricola (int m)
	{
		String sql = "SELECT cognome,nome,CDS " + 
				"FROM studente " + 
				"WHERE matricola=?";
		
		Studente result = null;
		
		try {
			Connection conn = ConnectDBCP.getConnection();
		
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, m);
			
			ResultSet res = st.executeQuery();
		
			if(res.next())
			{
				result = new Studente(m,
										res.getString("cognome"),
										res.getString("nome"),
										res.getString("CDS"));
			}
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
			//return null;
		}
		
		return result;
	}
	
	
	
}
