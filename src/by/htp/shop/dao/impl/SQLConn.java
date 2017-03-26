package by.htp.shop.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SQLConn {
	
	private InitialContext ic;
	private DataSource ds;
	
	public Connection getConnection() throws SQLException, NamingException	{
		ic = new InitialContext();
		ds = (DataSource) ic.lookup("java:/comp/env/jdbc/sportshop");
		return ds.getConnection();
	}
 
}
