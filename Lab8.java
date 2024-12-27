package com.coursecube.jdbc;

import java.sql.*;

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab8 {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String mycity="mlore";
		try {
			
			con=JDBCUtil.getConnection();
			
			//step 3- Prepare SQL statement
			String SQL="select * from mycustomers where city=?" ;
			
		    ps=con.prepareStatement(SQL);
		    ps.setString(1, mycity);
			
			//step 5-Submit SQL to DB
			rs=ps.executeQuery();
			
			//step 6- Process Result
			while(rs.next()) {
				int cid=rs.getInt(1);
				String cn=rs.getString(2);
				String em=rs.getString(3);
				int ph=rs.getInt(4);
				String ct=rs.getString(5);
				
				System.out.println(cid +"\t"+cn+"\t"+em+"\t"+ph+"\t"+ct);
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		finally {
			JDBCUtil.cleanup(rs, ps,con);

		}
		

	}

}