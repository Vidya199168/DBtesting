package org.ictkerala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ITDepartment {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema","root","Vid1998ya#");
		Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from employee_table where Department='IT'&&active='Yes'&&Salary>60000");
        while(rs.next())
        {
        	System.out.println("ID:"+rs.getInt(1)+",");
        	System.out.println("Employee Name  :"+rs.getString(2)+",");
        	System.out.println("Department :"+rs.getString(3)+",");
        	System.out.println("Designation :"+ rs.getString(4)+",");
        	System.out.println("Date of joining :"+ rs.getDate(5)+",");
        	System.out.println("Salary is :"+rs.getInt(6)+",");
        	System.out.println("City is :"+rs.getString(7)+",");
        	System.out.println("active status is :"+rs.getString(8)+",");


        }




	}

}
