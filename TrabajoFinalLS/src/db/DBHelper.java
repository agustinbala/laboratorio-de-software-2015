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
	
	public void closeConnection() throws SQLException {
		try {
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			throw e;
		}
	}
	
	public Boolean createDB() {	
		Boolean isNewDB = false;
		try {
			openConnection();
			ResultSet rs = stmt.executeQuery( "SELECT name FROM sqlite_master WHERE type='table';" );
			isNewDB = !rs.next();
			if(isNewDB){
				initTables();				
			}			
		    rs.close();
		    closeConnection();		    
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Opened database successfully");
		return isNewDB;
	}
	
	private void initTables() throws SQLException{
		 String sqlNotification = "CREATE TABLE  NOTIFICATION " +
                 "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                 " CONTENT           INTEGER    NOT NULL, " + 
                 " CONTEXT            INTEGER     NOT NULL, " + 
                 " CATEGORY        INTEGER, " + 
                 " CHILD         INTEGER,"+ 
                 " DATE_SENT     DATE DEFAULT (datetime('now','localtime')))"; 
		 stmt.executeUpdate(sqlNotification);
		 
		 String sqlLabel = "CREATE TABLE  LABEL "+
				 "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				   "NAME TEXT NOT NULL)";
		 stmt.executeUpdate(sqlLabel);
		 
		 String sqlCategory = "CREATE TABLE  CATEGORY"+
				 "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				   "NAME TEXT NOT NULL)";
		 stmt.executeUpdate(sqlCategory);
		 
		 String sqlContext = "CREATE TABLE  CONTEXT"+
				 "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				   "NAME TEXT NOT NULL)";
		 stmt.executeUpdate(sqlContext);
		 
		 String sqlChild = "CREATE TABLE  CHILD"+
				 "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				   "NAME TEXT NOT NULL)";
		 stmt.executeUpdate(sqlChild);
		 
		 String sqlContent = "CREATE TABLE  CONTENT"+
				 "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				   "NAME TEXT NOT NULL)";
		 stmt.executeUpdate(sqlContent);
		 
		 String sqlLabelNotification = "CREATE TABLE  LABELNOTIFICATION"+
				 "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				   "ID_LABEL int NOT NULL," + "ID_NOTIFICATION int NOT NULL" +")";
		 stmt.executeUpdate(sqlLabelNotification);
		
		 System.out.println("Tables created successfully");
	}
	
	public ResultSet executeQuery(String query){
		ResultSet result = null;
		try {
			openConnection();
			result = stmt.executeQuery(query);			
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
