package com.plant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.plant.utility.DBConnection;
import com.plant.entity.Cart;
import com.plant.entity.Plant;

public class CartServiceImpl implements CartService {

	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public boolean addToCart(Cart c) {
		con=DBConnection.establishConnection();
		sql="insert into cart values(?, ?, ?, ?, ?, ?)";

		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getCartId());
			ps.setString(2, c.getPlantId());
			ps.setString(3, c.getCustomerId());
			ps.setInt(4, c.getQuantity());
			ps.setDouble(6, c.getSubTotal());
			ps.setDouble(5, c.getPrice());
			
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
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return false;
	}

	@Override
	public boolean updateQuantity(String cartId, Integer quantity) {

		try {
			con=DBConnection.establishConnection();
			sql="update cart set quantity=? where cartId=?";
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setString(2, cartId);
			
			int i=ps.executeUpdate();
			if(i>0) {
				
				sql="update cart set subTotal=price*quantity where cartId=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, cartId);
				
				i=ps.executeUpdate();
				if(i>0)
					return true;
				
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
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteFoodItemCart(String cartId) {
try {
			
			con=DBConnection.establishConnection();
			sql="delete from cart where cartId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, cartId);
			
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
	public boolean clearMyCart(String customerId) {
		try {
			
			con=DBConnection.establishConnection();
			sql="delete from cart where customerId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerId);
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
			
		}
		catch(Exception e){
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
	public List<Cart> showMyCart(String customerId) {
		try {
			
			con=DBConnection.establishConnection();
			sql="select * from cart where customerId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerId);
			
			rs=ps.executeQuery();
			List<Cart> clist=new ArrayList<Cart>();
			
			while(rs.next()) {
				
				Cart c=new Cart();
				c.setCartId(rs.getString("cartId"));
				c.setCustomerId(rs.getString("customerId"));
				c.setPlantId(rs.getString("plantId"));
				c.setPrice(rs.getDouble("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setSubTotal(rs.getDouble("subTotal"));
				
				Plant p=new PlantServiceImpl().getPlantById(rs.getString("plantId"));
				c.setP(p);
				
				clist.add(c);
				
			}
			
			return clist;
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
			
		return null;
	}

	@Override
	public List<Cart> showAllCart() {
		try {
			
			con=DBConnection.establishConnection();
			sql="select * from cart";
			
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			List<Cart> clist=new ArrayList<Cart>();
			
			while(rs.next()) {
				
				Cart c=new Cart();
				c.setCartId(rs.getString("cartId"));
				c.setCustomerId(rs.getString("customerId"));
				c.setPlantId(rs.getString("plantId"));
				c.setPrice(rs.getDouble("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setSubTotal(rs.getDouble("subTotal"));
				
				Plant p=new PlantServiceImpl().getPlantById(rs.getString("plantId"));
				c.setP(p);;
				
				clist.add(c);
				
			}
			
			return clist;
			
		}
		catch(Exception e) {
			
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
		
		return null;
	}

	@Override
	public Cart getCartById(String cartId) {
		try {
			
			con=DBConnection.establishConnection();
			sql="select * from cart where cartId=?";
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, cartId);
			rs=ps.executeQuery();
			
			
			if(rs.next()) {
				
				Cart c=new Cart();
				c.setCartId(rs.getString("cartId"));
				c.setCustomerId(rs.getString("customerId"));
				c.setPlantId(rs.getString("plantId"));
				c.setPrice(rs.getDouble("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setSubTotal(rs.getDouble("subTotal"));
				
				Plant p=new PlantServiceImpl().getPlantById(rs.getString("plantId"));
				c.setP(p);
				
			
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
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public boolean checkPlantItem(String customerId, String plantId) {
try {
			
			con=DBConnection.establishConnection();
			sql="select * from cart where customerId=? && plantId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerId);
			ps.setString(2, plantId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				
				Integer quantity=rs.getInt("quantity");
				quantity++;
				
				String cartId=rs.getString("cartId");
				
				boolean flag=updateQuantity(cartId, quantity);
				
				return flag;
				
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

}
