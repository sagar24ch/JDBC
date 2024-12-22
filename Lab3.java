package com.coursecube.jdbc;

import java.sql.*;

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab3 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		
		try {
			
			con=JDBCUtil.getConnection();
			
			//step 3- Prepare SQL statement
			String SQL="insert into mycustomers values(107,'srgorai','scg@gmail.com',1234567,'mlore')";
			
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
			JDBCUtil.cleanup(st,con);
		}
	}
}
