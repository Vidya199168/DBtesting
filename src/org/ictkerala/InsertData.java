package org.ictkerala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

public class InsertData {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establish the connection to the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema", "root", "Vid1998ya#");
        
        // SQL query with placeholders for the data
        String sql = "INSERT INTO employee_table (Emp_ID, Name, Department,Designation, Date_of_Joining, Salary, City, Active) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        // Prepare the statement
        PreparedStatement pst = con.prepareStatement(sql);
        
        // Create scanner for input
        Scanner scan = new Scanner(System.in);
        
        // Input data from the user
        System.out.println("Enter the ID");
        int ID = scan.nextInt();
        
        System.out.println("Enter the Name");
        String name = scan.next();
        
        System.out.println("Enter the Department");
        String dept = scan.next();
        System.out.println("Enter the Designation");
        String desig = scan.next();
        
        System.out.println("Enter the Date of Joining (YYYY-MM-DD format)");
        String dateString = scan.next();  // input as String
        Date date = Date.valueOf(dateString);  // convert String to java.sql.Date
        
        System.out.println("Enter the Salary");
        int salary = scan.nextInt();
        
        System.out.println("Enter the City");
        String city = scan.next();
        
        System.out.println("Enter the Activity (Active status)");
        String actv = scan.next();
        
        // Set parameters in the PreparedStatement
        pst.setInt(1, ID);
        pst.setString(2, name);
        pst.setString(3, dept);
        pst.setString(4, desig);
        pst.setDate(5, date);  // Use setDate to insert the Date object
        pst.setInt(6, salary);
        pst.setString(7, city);
        pst.setString(8, actv);
        
        // Execute the update
        int rowsAffected = pst.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Successfully inserted.");
        } else {
            System.out.println("Error occurred while inserting.");
        }
        
        // Close resources
        scan.close();
        con.close();
    }
}
