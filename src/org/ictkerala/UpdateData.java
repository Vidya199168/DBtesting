package org.ictkerala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema","root","Vid1998ya#");
		String result="update employee_table set Salary=70000 where Emp_ID=101";
        PreparedStatement prpt=con.prepareStatement(result);
        int resultaffe=prpt.executeUpdate();
        if(resultaffe>0)
        {
        	System.out.println("successfully updated");
        }
        else
        {
        	System.out.println("not updated");
        }

        con.close();
	}

}