package com.coursecube.jdbc;

import java.sql.*;													//Callable statement example

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab11 {

	public static void main(String[] args) {
		Connection con=null;
	    CallableStatement cs=null;
	   
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL="{call p1(?,?,?,?)}";
			
			cs=con.prepareCall(SQL);
			cs.setInt(1,10);
			cs.setInt(2, 20);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.INTEGER);
			
			cs.execute();
			
			int sum=cs.getInt(3);
			int mul=cs.getInt(4);
			System.out.println("Sum="+sum);
			System.out.println("Diff="+mul);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(cs,con);
		}
	}
}
