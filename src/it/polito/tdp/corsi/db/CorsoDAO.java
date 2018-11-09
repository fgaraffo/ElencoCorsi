package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {

	/**
	 * Ritorna tutti gli elementi della tabella CORSO
	 * @return
	 */
	public List<Corso> listAll()
	{
		String sql = " SELECT codins,crediti,nome,pd " + 
				"FROM corso;";
		
		List <Corso> result = new ArrayList <Corso> ();
		
		try {
			Connection conn = ConnectDB.getConnection();
		
			PreparedStatement st = conn.prepareStatement(sql);
		
			ResultSet res = st.executeQuery();
		
			while(res.next())
			{
				Corso c = new Corso(res.getString("codins"),
									res.getInt("crediti"),
									res.getString("nome"),
									res.getInt("pd"));
				result.add(c);
			}
		
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
			//return null;
		}
		
		return result;
	}

	/**
	 * Ritorna i corsi che hanno questo periodo didattico {@code pd}
	 * @param pd
	 * @return
	 */
	public List<Corso> listByPD(int pd) 
	{
		String sql = "SELECT codins,crediti,nome,pd " + 
				"FROM corso " + 
				"WHERE pd=?;";
		
		List <Corso> result = new ArrayList <Corso> ();
		
		try {
			Connection conn = ConnectDB.getConnection();
		
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, pd);
		 
			ResultSet res = st.executeQuery();
		
			while(res.next())
			{
				Corso c = new Corso(res.getString("codins"),
									res.getInt("crediti"),
									res.getString("nome"),
									res.getInt("pd"));
				result.add(c);
			}
		
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
			//return null; 
		}
		
		return result;
		
	}

}
