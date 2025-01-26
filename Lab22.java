package com.coursecube.jdbc;

import java.sql.*;
class Account{
	
}

import com.coursecube.jdbc.util.JDBCUtil;													 
public class Lab22 {
	

	public static void main(String[] args) {
		Connection con=null;
	   
	    	try {
			
			con=JDBCUtil.getConnection();
			
		   DatabaseMetaData dbmd=con.getMetaData();
		    
		    System.out.println(dbmd.getDatabaseProductName());
		    System.out.println(dbmd.getDatabaseProductVersion());
		    System.out.println(dbmd.getDatabaseMajorVersion());
		    System.out.println(dbmd.getDatabaseMinorVersion());
		    System.out.println(dbmd.getDefaultTransactionIsolation());
		    System.out.println(dbmd.getDriverName());
		    System.out.println(dbmd.getJDBCMajorVersion());
		    System.out.println(dbmd.getJDBCMinorVersion());
		    
		    System.out.println(dbmd.supportsBatchUpdates());
		    System.out.println(dbmd.supportsFullOuterJoins());
		    System.out.println(dbmd.supportsTransactions());
		    System.out.println(dbmd.supportsGroupBy());
		    System.out.println(dbmd.supportsMultipleTransactions());
		    System.out.println(dbmd.supportsMultipleResultSets());
		    	
		    	System.out.println("----------------------");
		    
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		/*finally {
			JDBCUtil.cleanup(con);*/
		}
	}

