package com.coursecube.jdbc;

import java.sql.*;													//Result Set methods	

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab18B {

	public static void main(String[] args) {
		Connection con=null;
	   Statement st=null;
	   ResultSet rs=null;
	   
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL="select * from mycustomers";
			
		    st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.CLOSE_CURSORS_AT_COMMIT);
		   
		    rs=st.executeQuery(SQL);
		    
		    System.out.println("ResultSet Type="+st.getResultSetType());
		    System.out.println("Result Set Updatablity="+st.getResultSetConcurrency());
		    System.out.println("Result Set Holdablity="+st.getResultSetHoldability());
			
		    System.out.println(rs.isBeforeFirst());
		    System.out.println(rs.isAfterLast());
		    rs.first();
		    System.out.println(rs.isFirst());
		   rs.absolute(5);
		   rs.relative(2);
		   rs.relative(-3);
			System.out.println("          4th record           ");
			
				int cd=rs.getInt(1);
				String cn=rs.getString(2);
				String em=rs.getString(3);
				int ph=rs.getInt(4);
				String ct=rs.getString(5);
			
				System.out.println(cd+"\t"+cn+"\t"+em+"\t"+ph+"\t"+ct);
			
			
		
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(rs,st,con);
		}
	}
}
