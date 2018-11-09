package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe per la connessione al DB, viene creata una variabile statica per la connessione che viene poi 
 * condivisa per tutte le richieste successive
 * @author fedeg
 *
 */
public class ConnectDB {

	private static final String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=fede&serverTimezone=UTC";
	private static Connection conn;
	
	public static Connection getConnection ()
	{
		try
		{
			if(conn == null || conn.isClosed())
				conn = DriverManager.getConnection(jdbcURL);
		} 
		catch (SQLException e) 
		{
			System.err.println("Errore di connessione al DB");
			throw new RuntimeException(e);
		} 
	
		return conn;
	}
	
}
