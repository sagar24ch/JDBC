package com.coursecube.jdbc;

import java.sql.*;													 
public class Lab19 {
	
	public static void displayRaw(ResultSet rs) throws Exception{
		int cid=rs.getInt(1);
		String cn=rs.getString(2);
		String em=rs.getString(3);
		int ph=rs.getInt(4);
		String ct=rs.getString(5);
		System.out.println(cid+"\t"+cn+"\t"+em+"\t"+ph+"\t"+ct);
		}

	public static void main(String[] args) {
		Connection con=null;
	   Statement st=null;
	   ResultSet rs=null;
	   
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL="select * from mycustomers";
			
		    st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		   
		    rs=st.executeQuery(SQL);
		    
		    System.out.println("ResultSet Type="+st.getResultSetType());
		    System.out.println("Result Set Updatablity="+st.getResultSetConcurrency());
		    System.out.println("Result Set Holdablity="+st.getResultSetHoldability());
			
		    System.out.println(rs.isBeforeFirst());
		    System.out.println(rs.isAfterLast());
		    
		    System.out.println("           result in forward direction             ");
			while(rs.next())
				displayRaw(rs);
			
		    rs.first();
		    System.out.println(rs.isFirst());
		   rs.absolute(5);
		   rs.relative(2);
		   rs.relative(-3);
			System.out.println("          4th record           ");
			displayRaw(rs);
			
			rs.relative(2);
			System.out.println("6th record");
			displayRaw(rs);
			
			rs.first();
			
			rs.moveToInsertRow();
			
			rs.updateInt(1,114);
			rs.updateString(2,"sumit");
			rs.updateString(3,"Smt@jlc");
			rs.updateInt(4, 034);
			rs.updateString(5,"pune");
			
			rs.insertRow();
			rs.first();
			System.out.println("records with inserted row");
			while(rs.next());
			displayRaw(rs);

			rs.absolute(11);
			rs.updateString(2, "Sajan");
			rs.updateString(5," blore");
			rs.updateRow();
			
			rs.absolute(12);
			rs.deleteRow();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(rs,st,con);
		}
	}
}
