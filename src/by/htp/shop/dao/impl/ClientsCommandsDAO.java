package by.htp.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.exception.DAOException;

public class ClientsCommandsDAO implements ClientsDAO {

	@Override
	public int countClients(String login, String password) throws DAOException {
		SQLConn conn = new SQLConn();
		Connection con = null;

		final String request = "SELECT COUNT(*) AS TotalUsers FROM clients WHERE login=? AND password=?";

		try {
			con = conn.getConnection();
			PreparedStatement ps = con.prepareStatement(request);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return Integer.parseInt(rs.getString(1));

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
	public ClientData formClientData(String login, String password) throws DAOException {
		SQLConn conn = new SQLConn();
		Connection con = null;

		System.out.println(login + " " + password);

		final String request = "SELECT * FROM clients WHERE login='" + login + "' AND password='" + password + "'";

		try {
			con = conn.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(request);
			rs.next();
			ClientData clientData = new ClientData.ClientDataBuilder(
					rs.getString(2), 
					rs.getString(3), 
					rs.getString(4),
					rs.getString(5), 
					rs.getString(6), 
					rs.getString(7), 
					rs.getString(8)).id(rs.getInt(1)).build();

			return clientData;

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
	public void addNewClient(ClientData clientData) throws DAOException {
		SQLConn conn = new SQLConn();
		Connection con = null;

		final String update = "INSERT INTO clients (name,surname,email,phone,login,password,status) VALUES (?,?,?,?,?,?,?)";

		try {
			con = conn.getConnection();
			
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, clientData.getName());
			ps.setString(2, clientData.getSurname());
			ps.setString(3, clientData.getEmail());
			ps.setString(4, clientData.getPhone());
			ps.setString(5, clientData.getLogin());
			ps.setString(6, clientData.getPassword());
			ps.setString(7, "user");
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

}