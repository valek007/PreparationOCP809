package main.identify_required_components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Test {
	
	/*
	 The DriverManager class provides a basic service for managing a set of JDBC drivers
	 
	 When a connection is required, the DriverManager class locates an appropriate driver
	 based on the given JDBC URL, then attempts to establish a connection via the connect
	 method of the retrieved Driver instance.
	 
	 Connection getConnection(String url) throws SQLException
	 Connection getConnection(String url, String used, String password) throws SQLException
	 Connection getConnection(String url, Properties info) throws SQLException
	 
	 A JDBC URL is a String that your DBMS JDBC driver uses to connect to a database
	 
	 The syntax of a JDBC URL depends on the databse in use, normally starting with jdbc
	 URL syntax examples:
	 
	 Java DB: jdbc.derby:[subsubprotocol:][databaseName][;attribute=value]*
	 MySQL: jdbc:mysql://[host][mfailoverhost...][:port]/[database]
	 			[?propertyName1][=propertyValue1][&propertyName2][=propertyValue2]*
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		Properties props = new Properties();
		props.put("user", "root");
		props.put("password","myPass");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/whizlabs",props);
	}

}
