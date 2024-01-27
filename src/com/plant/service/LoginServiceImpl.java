package com.plant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.plant.utility.DBConnection;

public class LoginServiceImpl implements LoginService {

	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	

	@Override
	public boolean adminLogin(String username, String password) {
		try {
			
			con=DBConnection.establishConnection();
			sql="select * from admin where adminUser=? && adminPassword=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				rs.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean forgetCustPassword(String username, String customerId, String newPassword) {
		try {
			con=DBConnection.establishConnection();
			sql="update customer set password=? where custEmailId=? && customerId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, username);
			ps.setString(3, customerId);
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean forgetAdminPassword(String username, String adminId, String newPassword) {
		try {
			con=DBConnection.establishConnection();
			sql="update customer set password=? where adminUser=? && adminId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, username);
			ps.setString(3, adminId);
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean customerLogin(String username, String password) {
		try {
			
			con=DBConnection.establishConnection();
			sql="select * from customer where custEmailId=? && password=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				rs.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}



}
