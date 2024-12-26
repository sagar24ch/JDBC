package com.coursecube.jdbc;

import java.sql.*;													//with prepared statement using placeholder

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab7 {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		
		int mycid=109;
		String mycname="bbb";
		String myemail="bb@gmail.com";
		int myph=62000;
		String mycity="hyd";
		
		try {
			
			con=JDBCUtil.getConnection();
			
			//step 3- Prepare SQL statement
			String SQL="insert into mycustomers values(?,?,?,?,?)";
			
			ps=con.prepareStatement(SQL);
			ps.setInt(1, mycid);
			ps.setString(2, mycname);
			ps.setString(3,myemail);
			ps.setInt(4, myph);
			ps.setString(5, mycity);
			
			int x=ps.executeUpdate();
			
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
			JDBCUtil.cleanup(ps,con);
		}
	}
}
