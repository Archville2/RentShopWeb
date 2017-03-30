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
