package org.ictkerala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema","root","Vid1998ya#");
		String result="delete from employee_table where Emp_ID=103";
		 PreparedStatement prpt=con.prepareStatement(result);
	        int resultaffe=prpt.executeUpdate();
	        if(resultaffe>0)
	        {
	        	System.out.println("successfully deleted");
	        }
	        else
	        {
	        	System.out.println("not deleted");
	        }

	        
		}



	}


