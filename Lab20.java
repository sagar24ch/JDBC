package com.coursecube.jdbc;

import java.sql.*;

import com.coursecube.jdbc.util.JDBCUtil;													 
public class Lab20 {
	

	public static void main(String[] args) {
		Connection con=null;
	   Statement st=null;
	   ResultSet rs=null;
	   
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL="select * from mycustomers";
			
		    st=con.createStatement();
		   
		    rs=st.executeQuery(SQL);
		   
		    ResultSetMetaData rsmd=rs.getMetaData();
		    
		    int cc=rsmd.getColumnCount();
		    System.out.println("Col Count="+cc);
		    
		    rs.first();
		    for(int i=1;i<=cc;i++)
		    {
		    	String colName=rsmd.getColumnName(i);
		    	System.out.println(colName);
		    	
		    	String colLabel=rsmd.getColumnLabel(i);
		    	System.out.println(colLabel);
		    	
		    	String colType=rsmd.getColumnTypeName(i);
		    	System.out.println(colType);
		    	
		    	String colClsName=rsmd.getColumnClassName(i);
		    	System.out.println(colClsName);
		    	
		    	String tabName=rsmd.getTableName(i);
		    	System.out.println(tabName);
		    	
		    	String catName=rsmd.getCatalogName(i);
		    	System.out.println(catName);
		    	
		    	System.out.println("----------------------");
		    }
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(rs,st,con);
		}
	}
}
