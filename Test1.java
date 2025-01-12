package com.coursecube.jdbc;

import java.sql.*;													//use of different methods

import com.coursecube.jdbc.util.JDBCUtil;

public class Test1 {

	public static void main(String[] args) {
		Connection con=null;
	   Statement st=null;
	   ResultSet rs=null;
	   
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL="select * from mycustomers";
			
		    st=con.createStatement();
		   
		    rs=st.executeQuery(SQL);
			
			System.out.println("          Records in forward dir-           ");
			while(rs.next()) {
				int cid=rs.getInt("cid");
				String cname=rs.getString("cname");
				String email=rs.getString("email");
				int phone=rs.getInt("phone");
				String city=rs.getString("city");
				
				System.out.println(cid+"\t"+cname+"\t"+email+"\t"+phone+"\t"+city);
			}
			
			System.out.println("--------------Done- Call Completed---------------");
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
