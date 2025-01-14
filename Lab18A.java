package com.coursecube.jdbc;

import java.sql.*;													//use of next() and previous() 

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab18A {

	public static void main(String[] args) {
		Connection con=null;
	   Statement st=null;
	   ResultSet rs=null;
	   
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL="select * from mycustomers";
			
		    st=con.createStatement();
		   
		    rs=st.executeQuery(SQL);
			
			System.out.println("          recors in reverse direction           ");
			
			while(rs.previous())
			{
				int cd=rs.getInt(1);
				String cn=rs.getString(2);
				String em=rs.getString(3);
				int ph=rs.getInt(4);
				String ct=rs.getString(5);
				
				System.out.println(cd+"\t"+cn+"\t"+em+"\t"+ph+"\t"+ct);
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(rs,st,con);
		}
	}
}
