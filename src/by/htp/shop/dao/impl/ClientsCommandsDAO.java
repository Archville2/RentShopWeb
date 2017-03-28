package by.htp.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.SQLConn;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.provider.ConnectionPoolProvider;

public class ClientsCommandsDAO implements ClientsDAO {
	ConnectionPoolProvider poolProvider = ConnectionPoolProvider.getInstance();
	SQLConn sqlConnection = poolProvider.getSQLConn();

	final String COUNT_CLIENTS = "SELECT COUNT(*) AS TotalUsers FROM clients WHERE login=? AND password=?";
	final String FORM_CLIENTS = "SELECT * FROM clients WHERE login=? AND password=?";
	final String ADD_CLIENT = "INSERT INTO clients (name,surname,email,phone,login,password,status) VALUES (?,?,?,?,?,?,?)";

	@Override
	public int countClients(String login, String password) throws DAOException {
		final int LOGIN = 1;
		final int PASSWORD = 2;
		Connection con = null;

		try {
			con = sqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(COUNT_CLIENTS);
			ps.setString(LOGIN, login);
			ps.setString(PASSWORD, password);
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
		final int LOGIN = 1;
		final int PASSWORD = 2;
		Connection con = null;

		try {
			con = sqlConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(FORM_CLIENTS);
			ps.setString(LOGIN, login);
			ps.setString(PASSWORD, password);
			ResultSet rs = ps.executeQuery();
			rs.next();

			ClientData clientData = new ClientData.ClientDataBuilder(
					rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), 
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
		final int NAME = 1;
		final int SURNAME = 2;
		final int EMAIL = 3;
		final int PHONE = 4;
		final int LOGIN = 5;
		final int PASSWORD = 6;
		final int STATUS = 7;
		Connection con = null;

		try {
			con = sqlConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(ADD_CLIENT);
			ps.setString(NAME, clientData.getName());
			ps.setString(SURNAME, clientData.getSurname());
			ps.setString(EMAIL, clientData.getEmail());
			ps.setString(PHONE, clientData.getPhone());
			ps.setString(LOGIN, clientData.getLogin());
			ps.setString(PASSWORD, clientData.getPassword());
			ps.setString(STATUS, "user");
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