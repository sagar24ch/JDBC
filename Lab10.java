package com.coursecube.jdbc;

import java.sql.*;													

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab10 {

	public static void main(String[] args) {
		Connection con=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    
	    String SQL1="insert into mycustomers values (111,'saagar','srr@jlc',62045,'Pune')";
	    String SQL2="update mycustomers set phone=99315 where phone=1234567";
	    String SQL3="select * from mycustomers";
		
	    	try {
			
			con=JDBCUtil.getConnection();
			
			ps=con.prepareStatement(SQL3);
			
			boolean b=ps.execute();
			
			if(b==false) {
				int x=ps.getUpdateCount();
				System.out.println("Total records updated="+x);
			}
			else {
				rs=ps.getResultSet();
				System.out.println("Retrieve records are=");
				while(rs.next())
				{
					int cid=rs.getInt(1);
					String cname=rs.getString(2);
					String email=rs.getString(3);
					int ph=rs.getInt(4);
					String ct=rs.getString(5);
					
					System.out.println(cid+"\t"+cname+"\t"+email+"\t"+ph+"t"+ct);
				}
			}

		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(rs,ps,con);
		}
	}
}
