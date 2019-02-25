package com.sqlsamples;

import java.sql.Connection;
//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.DriverManager;

public class App {

	static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=PersonDB;user=sa;password=123";
	static String name = null;
	static int age = 0;
	static String que = null;
	static int option = 0;
	static String oldName = null;
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("Choose a number: \n\n1) Add name\n2) Update name\n3) Remove Name \n4) Print Selected Query \n5) Exit\n\n Choose an option: ");
		option = s.nextInt();
		
		
		switch (option) {
			case 1:
				System.out.print("Enter a name: ");
				name = s.next();
				System.out.print("Enter an age: ");
				age = s.nextInt();
				addRecord(name, age);
				System.out.println("Record successfully added.");
				doQuery("all", "all");
				break;
			case 2:
				System.out.print("Enter a name to be changed: ");
				oldName = s.next();
				System.out.print("Enter new name: ");
				name = s.next();
				updateName(oldName, name);
				System.out.println("Record updated.");
				doQuery("all", "all");
				break;
			case 3: 
				System.out.print("Enter a name to be removed from the record: ");
				name = s.next();
				deleteName(name);
				System.out.println("Record deleted.");
				doQuery("all", "all");
				break;
			case 4:
				System.out.print("Choose an option: \n 1) Display all with corresponding name \n 2) Display all with corresponding age \n 3) Print all records \n Choose option: ");
				option = s.nextInt();
				if (option == 1) {

					que = "name";
					System.out.print("Enter Name: ");
					name = s.next();
					doQuery(que, name);
				} else if (option == 2) {

					que = "age";
					System.out.print("Enter Age: ");
					name = s.next();
					doQuery(que, name);
				} else if (option == 3){
					que = "all";
					name = "all";
					System.out.println("Printing all");
					doQuery(que, name);
				}
				break;
			
			}
		
		s.close();
	}
	


	
	

	public static void addRecord(String name, int age) {
		try(Connection connection = DriverManager.getConnection(connectionUrl)){
		String queryStr = "INSERT PERSON_INFO (name,age) VALUES (?,?); ";
      	PreparedStatement ps = connection.prepareStatement(queryStr);
		ps.setString(1, name);
		ps.setString(2, Integer.toString(age)); 
		ps.executeUpdate();
		ps.close();
		connection.close();
		}
		  catch(Exception e){
			e.printStackTrace();
		  }
	}

	public static void updateName(String oldName, String newName) {
		try(Connection connection = DriverManager.getConnection(connectionUrl)){

		
		String queryStr = "UPDATE PERSON_INFO SET name = ? where name = ?; ";
      	PreparedStatement ps = connection.prepareStatement(queryStr);
		ps.setString(2, oldName);
		ps.setString(1, newName); 
		ps.executeUpdate();
		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	

	public static void deleteName(String name){
		try(Connection connection = DriverManager.getConnection(connectionUrl)){
		String queryStr = "DELETE FROM PERSON_INFO WHERE name = ?";
      	PreparedStatement ps = connection.prepareStatement(queryStr);
		ps.setString(1, name); 
		ps.executeUpdate();
		ps.close();
		connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void doQuery(String que, String name) {
		try(Connection connection = DriverManager.getConnection(connectionUrl)){
		if (que.equalsIgnoreCase("name")){
			String queryStr = "SELECT * FROM PERSON_INFO WHERE name = ?" ;
			PreparedStatement ps = connection.prepareStatement(queryStr);
			ps.setString(1, name); 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				System.out.println("  NAME: " + 
				rs.getString("name").trim());
			   
				System.out.println("  AGE: " + 
				rs.getString("age").trim());
				
				System.out.println("");
			  }
			rs.close();
			ps.close();
		}
		else if (que.equalsIgnoreCase("age")){
			String queryStr = "SELECT * FROM PERSON_INFO WHERE age = ?" ;
			PreparedStatement ps = connection.prepareStatement(queryStr);
			ps.setString(1, name); 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				System.out.println("  NAME: " + 
				rs.getString("name").trim());
			   
				System.out.println("  AGE: " + 
				rs.getString("age").trim());
				
				System.out.println("");
			  }
			rs.close();
			ps.close();
		}
		else if(que.equalsIgnoreCase("all")){
			String queryStr = "SELECT * FROM PERSON_INFO" ;
			PreparedStatement ps = connection.prepareStatement(queryStr);
			
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				System.out.println("  NAME: " + 
				rs.getString("name").trim());
			   
				System.out.println("  AGE: " + 
				rs.getString("age").trim());
				
				System.out.println("");
			  }
			rs.close();
			ps.close();
		}
		
		
		connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	    //Update the username and password below
		
	// 	try {
	// 		// Load SQL Server JDBC driver and establish connection.
	// 		System.out.print("Connecting to SQL Server ... ");
	// 		try  {
	// 			System.out.println("Done.");

	// 			// Create a sample database
				
	// 			 String sql = null;
				
	// 			// // INSERT demo
	// 			// System.out.print("Inserting a new row into table, press ENTER to continue...");
	// 			// System.in.read();
	// 			// sql = new StringBuilder().append("INSERT Employees (Name, Location) ").append("VALUES (?, ?);")
	// 			// 		.toString();
	// 			// try (PreparedStatement statement = connection.prepareStatement(sql)) {
	// 			// 	statement.setString(1, "Jake");
	// 			// 	statement.setString(2, "United States");
	// 			// 	int rowsAffected = statement.executeUpdate();
	// 			// 	System.out.println(rowsAffected + " row(s) inserted");
	// 			// }

	// 			// // UPDATE demo
	// 			// String userToUpdate = "Nikita";
	// 			// System.out.print("Updating 'Location' for user '" + userToUpdate + "', press ENTER to continue...");
	// 			// System.in.read();
	// 			// sql = "UPDATE Employees SET Location = N'United States' WHERE Name = ?";
	// 			// try (PreparedStatement statement = connection.prepareStatement(sql)) {
	// 			// 	statement.setString(1, userToUpdate);
	// 			// 	int rowsAffected = statement.executeUpdate();
	// 			// 	System.out.println(rowsAffected + " row(s) updated");
	// 			// }

	// 			// // DELETE demo
	// 			// String userToDelete = "Jared";
	// 			// System.out.print("Deleting user '" + userToDelete + "', press ENTER to continue...");
	// 			// System.in.read();
	// 			// sql = "DELETE FROM Employees WHERE Name = ?;";
	// 			// try (PreparedStatement statement = connection.prepareStatement(sql)) {
	// 			// 	statement.setString(1, userToDelete);
	// 			// 	int rowsAffected = statement.executeUpdate();
	// 			// 	System.out.println(rowsAffected + " row(s) deleted");
	// 			// }

	// 			// READ demo
	// 			// System.out.print("Reading data from table, press ENTER to continue...");
	// 			// System.in.read();
	// 			// sql = "SELECT uid,name,age FROM PERSON_INFO;";
	// 			// try (Statement statement = connection.createStatement();
	// 			// 		ResultSet resultSet = statement.executeQuery(sql)) {
	// 			// 	while (resultSet.next()) {
	// 			// 		System.out.println(
	// 			// 				resultSet.getInt(1) + " " + resultSet.getString(2).trim() + " " + resultSet.getString(3).trim());
	// 			// 	}
	// 			// }







	// 			//connection.close();
	// 			System.out.println("All done.");
	// 		}
	// 	} catch (Exception e) {
	// 		System.out.println();
	// 		e.printStackTrace();
	// 	}

}