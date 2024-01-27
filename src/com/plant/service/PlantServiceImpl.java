package com.plant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.plant.entity.Plant;
import com.plant.utility.DBConnection;

public class PlantServiceImpl implements PlantService {

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sql=null;
	
	@Override
	public boolean addPlant(Plant p) {
		
		con=DBConnection.establishConnection();
		sql="insert into plant values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, p.getPlantId());
			ps.setString(2, p.getPlantName());
			ps.setString(3, p.getPlantType());
			ps.setString(4, p.getPlantCategory());
			ps.setString(5, p.getSeason());
			ps.setDouble(6, p.getPrice());
			ps.setInt(7, p.getQuantityInStock());
			
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
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean updatePlant(Plant p) {
		try {
			
			con=DBConnection.establishConnection();
			sql="update plant set plantName=?, plantType=?, plantCategory=?, season=?, price=?, quantityInStock=? where plantId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, p.getPlantName());
			ps.setString(2, p.getPlantType());
			ps.setString(3, p.getPlantCategory());
			ps.setString(4, p.getSeason());
			ps.setDouble(5, p.getPrice());
			ps.setInt(6, p.getQuantityInStock());
			ps.setString(7, p.getPlantId());
			
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
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean deletePlant(String plantId) {
		try {
			con=DBConnection.establishConnection();
			sql="delete from plant where plantId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, plantId);
			
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
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public Plant getPlantById(String PlantId) {
		try {
			con=DBConnection.establishConnection();
			sql="select * from plant where plantId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, PlantId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				Plant p=new Plant();
				
				p.setPlantId(rs.getString("plantId"));
				p.setPlantName(rs.getString("plantName"));
				p.setPlantType(rs.getString("plantType"));
				p.setPlantCategory(rs.getString("plantCategory"));
				p.setSeason(rs.getString("season"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantityInStock(rs.getInt("quantityInStock"));
				
				return p;
				
			}
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<Plant> showAllPlant() {
		try {
			con=DBConnection.establishConnection();
			sql="select * from plant";
			
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			List<Plant> plist=new ArrayList<Plant>();
			
			while(rs.next()) {
				Plant p=new Plant();
				
				p.setPlantId(rs.getString("plantId"));
				p.setPlantName(rs.getString("plantName"));
				p.setPlantType(rs.getString("plantType"));
				p.setPlantCategory(rs.getString("plantCategory"));
				p.setSeason(rs.getString("season"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantityInStock(rs.getInt("quantityInStock"));
				
				plist.add(p);
			}	
			return plist;
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<Plant> getPlantByCategory(String plantCategory) {
		try {
			con=DBConnection.establishConnection();
			sql="select * from plant where plantCategory=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, plantCategory);
			
			rs=ps.executeQuery();
			List<Plant> plist=new ArrayList<Plant>();
			
			while(rs.next()) {
				Plant p=new Plant();
				
				p.setPlantId(rs.getString("plantId"));
				p.setPlantName(rs.getString("plantName"));
				p.setPlantType(rs.getString("plantType"));
				p.setPlantCategory(rs.getString("plantCategory"));
				p.setSeason(rs.getString("season"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantityInStock(rs.getInt("quantityInStock"));
				
				plist.add(p);
			}
			return plist;
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<Plant> getPlantByType(String plantType) {
		try {
			con=DBConnection.establishConnection();
			sql="select * from plant where plantType=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, plantType);
			
			rs=ps.executeQuery();
			List<Plant> plist=new ArrayList<Plant>();
			
			while(rs.next()) {
				Plant p=new Plant();
				
				p.setPlantId(rs.getString("plantId"));
				p.setPlantName(rs.getString("plantName"));
				p.setPlantType(rs.getString("plantType"));
				p.setPlantCategory(rs.getString("plantCategory"));
				p.setSeason(rs.getString("season"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantityInStock(rs.getInt("quantityInStock"));
				
				plist.add(p);
			}
			return plist;
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<Plant> getPlantBySeason(String season) {
		try {
			con=DBConnection.establishConnection();
			sql="select * from plant where season=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, season);
			
			rs=ps.executeQuery();
			List<Plant> plist=new ArrayList<Plant>();
			
			while(rs.next()) {
				Plant p=new Plant();
				
				p.setPlantId(rs.getString("plantId"));
				p.setPlantName(rs.getString("plantName"));
				p.setPlantType(rs.getString("plantType"));
				p.setPlantCategory(rs.getString("plantCategory"));
				p.setSeason(rs.getString("season"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantityInStock(rs.getInt("quantityInStock"));
				
				plist.add(p);
			}
			return plist;
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
