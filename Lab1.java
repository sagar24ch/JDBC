package com.coursecube.jdbc;

import java.sql.*;

public class Lab1 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		
		try {
			
			//step 1- Load the Driver Class
			Class.forName("com.mysql.jdbc.Driver");
			
			//step 2- Open the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbcdb", "root", "system");
			
			//step 3- Prepare SQL statement
			String SQL="insert into mycustomers values(106,'rgorai','g@gmail.com',1234567,'mlore')";
			
			//step 4- Create the JDBC statement
			st=con.createStatement();
			
			//step 5-Submit SQL to DB
			int x=st.executeUpdate(SQL);
			
			//step 6- Process Result
			if(x==1) {
				System.out.println("Customer record is inserted succesfully");
			}
			else {
				System.out.println("Sorry customer record is not inserted");
			}

		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		//step 7- Close the Resources
		finally {
			try {
				if(st!=null)
						st.close();
				if(con!=null)
						con.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
