package org.ictkerala;



import java.sql.*;



public class ActiveStatus {
       public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load MySQL JDBC Driver

    	//Validate that the salary of all employees is greater than 400000&Active yes or no
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema", "root", "Vid1998ya#");

        String salaryQuery = "SELECT * FROM employee_table WHERE salary <= 400000";

        String activeStatusQuery = "SELECT * FROM employee_table WHERE Active NOT IN ('Yes', 'No')";

        

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(salaryQuery);

        while (rs.next()) {

            System.out.println("ID: " + rs.getInt(1));

            System.out.println("Employee Name: " + rs.getString(2));

            System.out.println("Department: " + rs.getString(3));

            System.out.println("Designation: " + rs.getString(4));

            System.out.println("Date of Joining: " + rs.getDate(5));

            System.out.println("Salary: " + rs.getInt(6));

            System.out.println("City: " + rs.getString(7));

            System.out.println("Active Status: " + rs.getString(8));

        }

        

        ResultSet activeResult = stmt.executeQuery(activeStatusQuery);

        boolean invalidActiveFound = false;

        while (activeResult.next()) {

            String activeStatus = activeResult.getString("Active");

            if (!"Yes".equals(activeStatus) && !"No".equals(activeStatus)) {

                invalidActiveFound = true;

                System.out.println("Warning: Invalid 'Active' status found. Active Status: " + activeStatus);

            }

        }



        if (!invalidActiveFound) {

            System.out.println("All employees have a valid 'Active' status.");

        }



        rs.close();

        activeResult.close();

        stmt.close();

        con.close();

    }

}