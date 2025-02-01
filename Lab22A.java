package com.coursecube.jdbc;

import java.sql.*;
import com.coursecube.jdbc.util.JDBCUtil;		

class AccountService{
	void fundsTransfer(int saccno,int daccno,double amt)
	{
		Connection con=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		ResultSet rs=null;
		
		try {
			
			con=JDBCUtil.getConnection();
			String SQL1="select bal from myaccounts where accno=?";
			String SQL2="update myaccounts set bal=? where accno=?";
			ps1=con.prepareStatement(SQL1);
			ps2=con.prepareStatement(SQL2);
			
			//Deposit
		
			ps1.setInt(1, daccno);//102
			rs=ps1.executeQuery();
			if(rs.next()) {
				double bal=rs.getInt(1);
				bal=bal+amt;
				
				ps2.setDouble(1, bal);
				ps2.setInt(2, daccno);
				ps2.executeUpdate();
			}else {
				throw new InvalidAccountNumberException();
			}
			//Withdraw
			
			ps1.setInt(1, saccno);//101
			rs=ps1.executeQuery();
			if(rs.next()) {
				double bal=rs.getInt(1);
				if(bal>=amt){
				bal=bal-amt;
				
				ps2.setDouble(1, bal);
				ps2.setInt(2, saccno);
				ps2.executeUpdate();
				}else {
					throw new NoFundsException();
				}
			}else {
				throw new InvalidAccountNumberException();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		finally {
			JDBCUtil.cleanup(null,con);
		}
	}
}
public class Lab22A {
	
	public static void main(String[] args) {
		AccountService as=new AccountService();
		as.fundsTransfer(101,102,50000);
		}
	}

