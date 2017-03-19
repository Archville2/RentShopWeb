package by.htp.shop.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.provider.ClientProvider;

public class ClientsCommandsDAO implements ClientsDAO {
	ClientProvider clientProvider = ClientProvider.getInstance();

	@Override
	public void formClientData(ClientData clientData) throws DAOException {
		Connection con = null;
		String login = clientData.getLogin();
		String request = "SELECT * FROM clients WHERE login='" + login + "'";

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sportshop?useSSL=false", "root", "leevth");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(request);

			if (!rs.next()) {
				throw new DAOException("can't find client");
			} else {
				clientData.setId(rs.getInt(1));
				clientData.setName(rs.getString(2));
				clientData.setSurname(rs.getString(3));
				clientData.setEmail(rs.getString(4));
				clientData.setPhone(rs.getString(5));
				clientData.setPassword(rs.getString(7));
				clientData.setStatus(rs.getString(8));
			}

		} catch (ClassNotFoundException e) {
			throw new DAOException("Class not found", e);
		} catch (SQLException e) {
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
	public boolean checkClientLoginPassword(String login, String password) throws DAOException {
		Connection con = null;

		String request = "SELECT login, password FROM clients WHERE login='" + login + "' AND password='" + password
				+ "'";

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sportshop?useSSL=false", "root", "leevth");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(request);

			if (!rs.next()) {
				return false;
			} else {
				return true;
			}

		} catch (ClassNotFoundException e) {
			throw new DAOException("Class not found", e);
		} catch (SQLException e) {
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
	public void addNewClient(ClientData clentData) throws DAOException {
		Connection con = null;

		String update = "INSERT INTO clients (name,surname,email,phone,login,password,status) " + "VALUES ('"
				+ clentData.getName() + "', '" + clentData.getSurname() + "', '" + clentData.getEmail() + "','"
				+ clentData.getPhone() + "', '" + clentData.getLogin() + "', '" + clentData.getPassword() + "','user')";

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sportshop?useSSL=false", "root", "leevth");
			Statement st = con.createStatement();

			st.executeUpdate(update);

		} catch (ClassNotFoundException e) {
			throw new DAOException("Class not found", e);
		} catch (SQLException e) {
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