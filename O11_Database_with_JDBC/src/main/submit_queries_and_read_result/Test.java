package main.submit_queries_and_read_result;

public class Test {
	
		/*
		PreparedStatement interface is a subtype of the Statement interface, representing precompiled
		Sql statements; this interface allows for the efficient execution of a statement multiple times
		
		A PreparedStatement can be created by calling the Connection::prepareStatement method
		Parameters of a prepared statement are denoted by question mark placeholders and can be set by
		suitable setter methods, such as setInt, setString, or the like
		
		General statement:
		Statement statement = connection.createStatement();
		
		Prepared statement:
		String query = "SELECT * FROM MEMBERS WHERE NAME=? AND AGE=?;
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, "John");
		preparedStatement.setInt(2,30);
		
		In order to retrieve a ResultSet from a database, you must call the executeQuery method on a Statement
		
		General Statement:
		ResultSet resultSet = Statement.executeQuery(query);
		
		Prepared statement:
		Resultset resultSet = preparedStatement.executeQuery();
		
		You can acces data in a ResultSet object through a cursor, wich is a pointer
		pointing to one row of data in the resul set
		
		The ResultSet::next method moves the cursor to the next row
		this method returns false if the cursor is positioned after the last row, and true otherwise
		
		Iterating over a result set:
		
		while(resultSet.next()){
			// do something with the current row
		}
		
		ResultSet, Statement and Connection objects are all JDBC resources,
		withc can be closed by invoking the close method:
		
		resultSet.close(); statement.close(); connection.close();
		
		Given a MySql database table, named MEMBERS, with two records:
		
		ID		NAME
		1		John
		2		Jane
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/whizlabs","root","myPass");
		String query = "SELECT * FROM MEMBERS"
		try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)){
			while(resultSet.next()){
				int id = resultSet.getInt("ID");
				String name = resultSet.getString("NAME");
				System.out.println("Id: "+id+"- Name"+name);
			}
		} finally { if(connection!=null) connection.close();}
		//console output: "Id 1-Name: John" and "Id:2-Name: Jane"
		 */
}
