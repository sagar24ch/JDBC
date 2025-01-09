package com.coursecube.jdbc;

import java.sql.*;													//Callable statement example

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab16 {

	public static void main(String[] args) {
		Connection con=null;
	    PreparedStatement ps=null;
	   
	    	try {
	    		
	    		Object [][]mycustomers= {
	    				{115,"bbb","bb@jlc",8970,"pune"},
	    				{116,"ccc","cc@gmail",9089,"hyd"},
	    				{117,"dd","dd@jlc",99900,"pune"}
	    		};
			
			con=JDBCUtil.getConnection();
			
			String SQL="insert into mycustomers values(?,?,?,?,?)";
			
			
			ps=con.prepareStatement(SQL);
			
			for(Object []mycust:mycustomers)
			{
				ps.setInt(1, (int)mycust[0]);
				ps.setString(2,(String) mycust[1]);
				ps.setString(3,(String) mycust[2]);
				ps.setInt(4,(int) mycust[3]);
				ps.setString(5,(String) mycust[4]);
				
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
