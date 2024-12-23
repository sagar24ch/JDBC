package com.coursecube.jdbc;

import java.sql.*;

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab4 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			
			con=JDBCUtil.getConnection();
			
			//step 3- Prepare SQL statement
			String SQL="select * from mycustomers" ;
			
			//step 4- Create the JDBC statement
			st=con.createStatement();
			
			//step 5-Submit SQL to DB
			rs=st.executeQuery(SQL);
			
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
			JDBCUtil.cleanup(rs, st,con);

		}
		

	}

}