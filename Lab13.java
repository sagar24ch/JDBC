package com.coursecube.jdbc;

import java.sql.*;													//Callable statement example

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab13 {

	public static void main(String[] args) {
		Connection con=null;
	    CallableStatement cs=null;
	   
	    int mysid=101;
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL="{call findGrade2(?)}";
			
			cs=con.prepareCall(SQL);
			cs.setInt(1,mysid);
			
			cs.execute();
		
			System.out.println("Done- Call Completed");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(cs,con);
		}
	}
}
