package com.coursecube.jdbc;

import java.sql.*;													//Callable statement example

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab12 {

	public static void main(String[] args) {
		Connection con=null;
	    CallableStatement cs=null;
	   
	    int mysid=105;
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL="{call findBalance(?,?)}";
			
			cs=con.prepareCall(SQL);
			cs.setInt(1,mysid);
			
			cs.registerOutParameter(2, Types.DOUBLE);
			
			cs.execute();
			
			double bal=cs.getDouble(2);
			
			System.out.println("MyBalance"+bal);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(cs,con);
		}
	}
}
