package com.coursecube.jdbc;

import java.sql.*;													//Callable statement example

import com.coursecube.jdbc.util.JDBCUtil;

public class Lab15 {

	public static void main(String[] args) {
		Connection con=null;
	    Statement st=null;
	   
	    	try {
			
			con=JDBCUtil.getConnection();
			
			String SQL1="insert into mycustomers values(112,'Amit','at@gmail',8976,'mlore')";
			String SQL2="insert into mycustomers values(113,'simit','sst@gmail',89766,'mlore')";
			String SQL3="insert into mycustomers values(114,'rimit','rt@gmail',89976,'Blore')";
			
			String SQL4="update mycustomers set phone=9876 where city='hyd'";
			String SQL5="update mycustomers set city='hyd' where city='pune'";
			
			String SQL6="delete from mycustomers where cname='bbb'";
			
			st=con.createStatement();
			
			st.addBatch(SQL1);
			st.addBatch(SQL2);
			st.addBatch(SQL3);
			st.addBatch(SQL4);
			st.addBatch(SQL5);
			st.addBatch(SQL6);
			
			int result[]=st.executeBatch();
			for(int x:result) {
				System.out.println(x);
			}
			
			System.out.println("Done- Call Completed");
		
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			JDBCUtil.cleanup(st,con);
		}
	}
}
