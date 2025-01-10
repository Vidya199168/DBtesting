package org.ictkerala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalHRsalary {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema","root","Vid1998ya#");
        String query="select sum(Salary) as total_salary from employee_table where Department='HR'" ;
		PreparedStatement st=con.prepareStatement(query);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			double totalSalary=rs.getInt("total_salary");
			System.out.println("Total salary paid to HR department employee:"+ totalSalary);
		}
		else
		{
			System.out.println("No Data found for HR department");
		}
	}

}
