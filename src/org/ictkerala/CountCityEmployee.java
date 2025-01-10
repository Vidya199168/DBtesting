package org.ictkerala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountCityEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema","root","Vid1998ya#");
		Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select City,count(*)as employeecount from employee_table group by City");
        while(rs.next())
        {
        	String city=rs.getString("City");
        	int count=rs.getInt("employeecount");
        	System.out.printf("City:%s,Count:%d%n",city,count);
        }


		
		


	}

}
