package com.coursecube.jdbc.util;

import java.sql.*;

public class JDBCUtil {
	public static Connection getConnection() {
		
		Connection con=null; 
		try {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbcdb", "root", "system");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

					public static void cleanup( Statement st,Connection con)
					{
						try {
							if(st!=null)
								st.close();
							if(con!=null)
								con.close();
							     }
							catch(Exception e) {
								e.printStackTrace();
							}
					}
					public static void cleanup(ResultSet rs,Statement st,Connection con)
					{
						try {
								if(rs!=null)	
								rs.close();
							if(st!=null)
								st.close();
							if(con!=null)
								con.close();
							     }
							catch(Exception e) {
								e.printStackTrace();
							}
					}
}
