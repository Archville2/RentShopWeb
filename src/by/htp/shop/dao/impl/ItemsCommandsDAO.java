package by.htp.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import by.htp.shop.bean.Item;
import by.htp.shop.dao.ItemsDAO;
import by.htp.shop.dao.SQLConn;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.provider.ConnectionPoolProvider;

public class ItemsCommandsDAO implements ItemsDAO {
	ConnectionPoolProvider poolProvider = ConnectionPoolProvider.getInstance();
	SQLConn sqlConnection = poolProvider.getSQLConn();
	
	final String FORM_EQUIPMENT_DATA = "SELECT * FROM equipment";
	final String FORM_FOLDER_DATA = "SELECT DISTINCT folder FROM types";
	final String FORM_CART_LIST = "SELECT * FROM equipment WHERE id=?";	
	final String ADD_RENTED_ITEM = "INSERT INTO rented_items (clients_id, equipment_id, date, length) VALUES (?,?,?,?)";
	final String SET_IS_RENTED = "UPDATE equipment SET is_rented=1 WHERE id=?";
	final String RESET_IS_RENTED = "UPDATE equipment SET is_rented=0 WHERE id=?";
	final String MY_ITEMS = "SELECT * FROM equipment WHERE id IN (SELECT equipment_id FROM rented_items WHERE clients_id=?)";
	final String REMOVE_RENTED_ITEM = "DELETE FROM rented_items WHERE clients_id=? AND equipment_id=?";
		
	@Override
	public void removeRentedItem (int clientId, int equipmentId) throws DAOException {
		final int CLIENTS_ID = 1;
		final int EQUIPMENT_ID = 2;
		
		Connection con = null;
		
		try{
			con = sqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(REMOVE_RENTED_ITEM);
			ps.setInt(CLIENTS_ID, clientId);
			ps.setInt(EQUIPMENT_ID, equipmentId);
			ps.executeUpdate();
			
		} catch (NamingException | SQLException e) {
			throw new DAOException("SQL problems", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException("SQL close problems", e);
				}
			}
		}
	}
	
	@Override
	public void resetIsRented (int equipmentId) throws DAOException {
		final int EQUIPMENT_ID = 1;
		
		Connection con = null;
		
		try {
			con = sqlConnection.getConnection();
						
			PreparedStatement ps = con.prepareStatement(RESET_IS_RENTED);
			ps.setInt(EQUIPMENT_ID, equipmentId);
			ps.executeUpdate();
			
		} catch (NamingException | SQLException e) {
			throw new DAOException("SQL problems", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException("SQL close problems", e);
				}
			}
		}
	}
	
	@Override
	public void setIsRented (int equipmentId) throws DAOException {
		final int EQUIPMENT_ID = 1;
		
		Connection con = null;
		
		try {
			con = sqlConnection.getConnection();
						
			PreparedStatement ps = con.prepareStatement(SET_IS_RENTED);
			ps.setInt(EQUIPMENT_ID, equipmentId);
			ps.executeUpdate();
			
		} catch (NamingException | SQLException e) {
			throw new DAOException("SQL problems", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException("SQL close problems", e);
				}
			}
		}
	}
	
	@Override
	public List<Item> getMyItems(int clientId) throws DAOException {
		final int ID = 1;
		final int TYPE = 2;
		final int NAME = 3;
		final int DESCRIPTION = 4;
		final int MANUFACTURER = 5;
		final int COST = 6;
		final int IS_RENTED = 7;
		final int IMG = 8;
		
		List<Item> myItems = new ArrayList<>();
		Connection con = null;
		
		try {
			con = sqlConnection.getConnection();
						
			PreparedStatement ps = con.prepareStatement(MY_ITEMS);
			ps.setInt(ID, clientId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Item item = new Item.ItemBuilder(
						rs.getInt(ID),
						rs.getString(NAME), 
						rs.getString(TYPE), 
						rs.getString(DESCRIPTION),
						rs.getString(MANUFACTURER), 
						rs.getInt(COST), 
						rs.getBoolean(IS_RENTED), 
						rs.getString(IMG)).build();
				myItems.add(item);
			}
			return myItems;

		} catch (NamingException | SQLException e) {
			throw new DAOException("SQL problems", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException("SQL close problems", e);
				}
			}
		}
	}
	
	@Override
	public void addRentedItem (int clientId, int equipmentId, int days) throws DAOException {
		final int CLIENTS_ID = 1;
		final int EQUIPMENT_ID = 2;
		final int DATE = 3;
		final int LENGTH = 4;
		
		Connection con = null;
		
		try {
			con = sqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(ADD_RENTED_ITEM);
			ps.setInt(CLIENTS_ID, clientId);
			ps.setInt(EQUIPMENT_ID, equipmentId);
			ps.setDate(DATE, new java.sql.Date(System.currentTimeMillis()));
			ps.setInt(LENGTH, days);
			ps.executeUpdate();

		} catch (NamingException | SQLException e) {
			throw new DAOException("SQL problems", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException("SQL close problems", e);
				}
			}
		}
		
	}
	
	@Override
	public List<Item> getCartItems(List<Integer> cart) throws DAOException{
		final int ID = 1;
		final int TYPE = 2;
		final int NAME = 3;
		final int DESCRIPTION = 4;
		final int MANUFACTURER = 5;
		final int COST = 6;
		final int IS_RENTED = 7;
		final int IMG = 8;
		
		List<Item> items = new ArrayList<>();
		Connection con = null;
		
		try {
			con = sqlConnection.getConnection();
			
			for (Integer id:cart){
			PreparedStatement ps = con.prepareStatement(FORM_CART_LIST);
			ps.setInt(ID, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Item item = new Item.ItemBuilder(
						rs.getInt(ID),
						rs.getString(NAME), 
						rs.getString(TYPE), 
						rs.getString(DESCRIPTION),
						rs.getString(MANUFACTURER), 
						rs.getInt(COST), 
						rs.getBoolean(IS_RENTED), 
						rs.getString(IMG)).build();
				items.add(item);
				}
			}
			return items;

		} catch (NamingException | SQLException e) {
			throw new DAOException("SQL problems", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException("SQL close problems", e);
				}
			}
		}
	}
	
	@Override
	public List<Item> getItemList() throws DAOException {
		final int ID = 1;
		final int TYPE = 2;
		final int NAME = 3;
		final int DESCRIPTION = 4;
		final int MANUFACTURER = 5;
		final int COST = 6;
		final int IS_RENTED = 7;
		final int IMG = 8;
		
		List<Item> items = new ArrayList<>();
		Connection con = null;

		try {
			con = sqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(FORM_EQUIPMENT_DATA);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Item item = new Item.ItemBuilder(
						rs.getInt(ID),
						rs.getString(NAME), 
						rs.getString(TYPE), 
						rs.getString(DESCRIPTION),
						rs.getString(MANUFACTURER), 
						rs.getInt(COST), 
						rs.getBoolean(IS_RENTED), 
						rs.getString(IMG)).build();
				items.add(item);
			}

			return items;

		} catch (NamingException | SQLException e) {
			throw new DAOException("SQL problems", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException("SQL close problems", e);
				}
			}
		}
	}

	@Override
	public List<String> getFolderElements() throws DAOException {
		final int TYPE = 1;
		List<String> folderElements = new ArrayList<>();
		Connection con = null;

		try {
			con = sqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(FORM_FOLDER_DATA);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				folderElements.add(rs.getString(TYPE));
			}

			return folderElements;

		} catch (NamingException | SQLException e) {
			throw new DAOException("SQL problems", e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new DAOException("SQL close problems", e);
				}
			}
		}
	}
}
