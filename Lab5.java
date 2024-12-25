package com.coursecube.jdbc;

import java.sql.*;

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab5 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		
		int mycid=109;
		String mycname="bbb";
		String myemail="bb@gmail.com";
		int myph=62000;
		String mycity="hyd";
		
		try {
			
			con=JDBCUtil.getConnection();
			
			//step 3- Prepare SQL statement
			String SQL=String.format("insert into mycustomers values(%d,'%s','%s',%d,'%s')", mycid,mycname,myemail,myph,mycity);
			System.out.println(SQL);
			
			st=con.createStatement();
			
			int x=st.executeUpdate(SQL);
			
			if(x==1) {
				System.out.println("Customer record is inserted succesfully");
			}
			else {
				System.out.println("Sorry customer record is not inserted");
			}

		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(st,con);
		}
	}
}
