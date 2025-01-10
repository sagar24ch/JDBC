package com.coursecube.jdbc;

import java.sql.*;													//Callable statement example

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab17 {

	public static void main(String[] args) {
		Connection con=null;
	    PreparedStatement ps=null;
	   
	    	try {
	    		
	    		Object [][]mycustomers= {
	    				{118,"ee","ee@jlc",8970,"pune"},
	    				{119,"ff","ff@gmail",9089,"hyd"},
	    				{120,"gg","gg@jlc",99900,"pune"}
	    		};
			
			con=JDBCUtil.getConnection();
			
			String SQL="insert into mycustomers values(?,?,?,?,?)";
			
			
			ps=con.prepareStatement(SQL);
			
			for(Object []mycust:mycustomers)
			{
				int paramNum=1;
				for(Object obj:mycust)
				{
					ps.setObject(paramNum++, obj);
				}
				ps.addBatch();
			}
			int result[]=ps.executeBatch();
			for(int x:result) {
				System.out.println(x);
			}
			
			
			System.out.println("Done- Call Completed");
		
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(ps,con);
		}
	}
}
