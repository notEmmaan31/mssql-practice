// // /*
//  * To change this license header, choose License Headers in Project Properties.
//  * To change this template file, choose Tools | Templates
//  * and open the template in the editor.
//  */

// package test;
// import java.sql.*;
// /**
//  *
//  * @author lawrence
//  */
// public class TestDB {
//   public static void main (String args[]) {
//     try {
//       // Load the Driver
     
//       String driver ="org.apache.derby.jdbc.ClientDriver";
//       Class.forName(driver);
//       System.out.println("LOADED DRIVER  ---> " + driver);

//       // Create the "url"
//       // assume database server is running on the localhost
//       String url = "jdbc:derby://localhost:1527/PersonDB";
//       // Connect to the database represented by url
//       // with username PUBLIC and password PUBLIC
//       Connection con =
//       DriverManager.getConnection (url, "app", "app");
//       System.out.println("CONNECTED TO   ---> "+ url);

//       // Use the Connection to create a Statement object
//       Statement stmt = con.createStatement ();

//       // Execute query using Statement, receive the ResultSet
//       String qry ="SELECT * FROM PERSON_INFO order by name asc";
//       ResultSet rs = stmt.executeQuery(qry);
//       System.out.println("EXECUTED QUERY ---> " + qry);

//       // Print the results, row by row
//       System.out.println("\nPROCESSING RESULTS:\n");
//       while (rs.next()) {
//         System.out.println("  NAME: " + 
//         rs.getString("NAME").trim());
       
//         System.out.println("  Age: " + 
//         rs.getString("AGE").trim());
        
//         System.out.println("");
//       }
//       rs.close();
//       stmt.close();
//       con.close();
//     } catch (SQLException e) {
//       e.printStackTrace();
//     } catch (ClassNotFoundException e) {
//       e.printStackTrace();
//     }
//   }

// }
