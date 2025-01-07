package com.coursecube.jdbc;

import java.sql.*;													//Callable statement example

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab14 {

	public static void main(String[] args) {
		Connection con=null;
	    CallableStatement cs=null;
	   
	    int mysid=104;
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL="{call findMyGrade3(?,?,?,?,?)}";
			
			cs=con.prepareCall(SQL);
			
			cs.setInt(1,mysid);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.DOUBLE);
			cs.registerOutParameter(4, Types.CHAR);
			cs.registerOutParameter(5, Types.CHAR);
			
			cs.execute();
		
			System.out.println("Done- Call Completed");
			
			//collected out parameters
			int total=cs.getInt(2);
			double avg=cs.getDouble(3);
			String status=cs.getString(4);
			String grade=cs.getString(5);
			
			//out parameter displayed
			
			System.out.println("Total=\t"+total);
			System.out.println("Average=\t"+avg);
			System.out.println("Status=\t"+status);
			System.out.println("Grade=\t"+grade);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(cs,con);
		}
	}
}
