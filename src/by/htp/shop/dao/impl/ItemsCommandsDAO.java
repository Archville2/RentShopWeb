package by.htp.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import by.htp.shop.dao.ItemsDAO;
import by.htp.shop.dao.exception.DAOException;

public class ItemsCommandsDAO implements ItemsDAO {

	@Override
	public List<String> getFolderElements() throws DAOException {
		List<String> folderElements = new ArrayList<>();
		SQLConn conn = new SQLConn();
		Connection con = null;

		final String request = "SELECT DISTINCT folder FROM types";

		try {
			con = conn.getConnection();
			PreparedStatement ps = con.prepareStatement(request);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				folderElements.add(rs.getString(1));
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
