package com.plant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.plant.utility.DBConnection;
import com.plant.entity.Customer;
import com.plant.entity.Plant;

public class CustomerServiceImpl implements CustomerService{

	Connection con=null;
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	
	List<Plant> plist=new ArrayList<Plant>();
	
	@Override
	public boolean addCustomerDetails(Customer c) {
		try {
			con=DBConnection.establishConnection();
			sql="insert into Customer values(?, ?, ?, ?, ?, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getCustomerId());
			ps.setString(2, c.getCustomerName());
			ps.setString(3, c.getCustEmailId());
			ps.setLong(4, c.getCustPhnNo());
			ps.setString(5, c.getHomeAddress());
			ps.setString(6, c.getPincode());
			ps.setString(7, c.getDropAddress());
			ps.setString(8, c.getPassword());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			finally {
				try {
					
					ps.close();
					con.close();
					
				}
				catch(Exception e){
					
					e.printStackTrace();
				}
			}
			
		return false;
	}

	@Override
	public boolean deleteCustomerDetails(String customerId) {
		try {
		con=DBConnection.establishConnection();
		sql="delete from Customer where customerId=?";
		
		ps=con.prepareStatement(sql);
		ps.setString(1, customerId);	
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean updateCustomerDetails(Customer c) {
		try {
			con=DBConnection.establishConnection();
			sql="update Customer set customerName=?, custEmailId=?, custPhnNo=?, homeAddress=?,"
					+ " pincode=?, password=? where customerId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustEmailId());
			ps.setLong(3, c.getCustPhnNo());
			ps.setString(4, c.getHomeAddress());
			ps.setString(5, c.getPincode());
			ps.setString(6, c.getPassword());
			ps.setString(7, c.getCustomerId());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public Customer getDetailsByEmail(String custEmailId) {
		try {
			con=DBConnection.establishConnection();
			sql="select * from customer where custEmailId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, custEmailId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Customer c=new Customer();
				
				c.setCustomerId(rs.getString("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustEmailId(rs.getString("custEmailId"));
				c.setCustPhnNo(rs.getLong("custPhnNo"));
				c.setHomeAddress(rs.getString("homeAddress"));
				c.setPincode(rs.getString("pincode"));
				c.setPassword(rs.getString("password"));
				
				return c;
				
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
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public Customer getDetailsById(String customerId) {
		try {
			con=DBConnection.establishConnection();
			sql="select * from customer where customerId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Customer c=new Customer();
				
				c.setCustomerId(rs.getString("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustEmailId(rs.getString("custEmailId"));
				c.setCustPhnNo(rs.getLong("custPhnNo"));
				c.setHomeAddress(rs.getString("homeAddress"));
				c.setPincode(rs.getString("pincode"));
				c.setPassword(rs.getString("password"));
				
				return c;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
