package org.ictkerala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ValidateSalary {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//Class.forName("com.mysql.cj.jdbc.driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/campkerala_schema","root","Vid1998ya#");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema","root","Vid1998ya#");
		Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from employee_table where Salary>40000");
        while(rs.next())
		{
        	System.out.println("ID :"+ rs.getInt(1)+",");
        	System.out.println("Employee name is :"+rs.getString(2)+",");
        	System.out.println("Department is :"+rs.getString(3)+",");
        	System.out.println("Designation is :"+ rs.getString(4)+",");
        	System.out.println("Date of Joining :"+ rs.getDate(5)+",");
        	System.out.println("Salary is :"+ rs.getInt(6)+",");
        	System.out.println("city is:"+ rs.getString(7)+",");
        	System.out.println("active status is :"+ rs.getString(8)+",");
        }

	}

}
