package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

	private Connection connection = null;
	private Statement stmt = null;
	
	private void openConnection() throws Exception{
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:hermes.db");
			stmt = connection.createStatement();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			throw e;
		}
	}
	
	private void closeConnection() throws SQLException {
		try {
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			throw e;
		}
	}
	
	public void createDB() {		
		try {
			openConnection();
			ResultSet rs = stmt.executeQuery( "SELECT name FROM sqlite_master WHERE type='table';" );
			if(!rs.next()){
				initTables();
			}			
		    rs.close();
		    closeConnection();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Opened database successfully");
	}
	
	private void initTables() throws SQLException{
		 String sqlNotification = "CREATE TABLE  NOTIFICATION " +
                 "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                 " CONTENT           TEXT    NOT NULL, " + 
                 " CONTEXT            TEXT     NOT NULL, " + 
                 " CATEGORY        TEXT, " + 
                 " CHILD         TEXT,"+ 
                 " DATE_SENT     DATE)"; 
		 stmt.executeUpdate(sqlNotification);
		 String sqlLabel = "CREATE TABLE  LABEL "+
				 "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				   "NAME TEXT NOT NULL)";
		 stmt.executeUpdate(sqlLabel);
		 String sqlRelationship = "CREATE TABLE  NOTIFICATION_LABEL "+
				 "(ID_NOTIFICATION INT NOT NULL," +
				   "ID_LABEL INT NOT NULL)";
		 stmt.executeUpdate(sqlRelationship);
		 System.out.println("Tables created successfully");
	}
	
	public ResultSet executeQuery(String query){
		ResultSet result = null;
		try {
			openConnection();
			result= stmt.executeQuery(query);
			closeConnection();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}
	
	public void executeUpdate(String query) throws Exception{
		try {
			openConnection();
			stmt.executeUpdate(query);
			closeConnection();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}
