package by.htp.shop.dao.provider;

import by.htp.shop.dao.SQLConn;

public class ConnectionPoolProvider {
	public static final ConnectionPoolProvider instance = new ConnectionPoolProvider();
	public static SQLConn sqlConn = new SQLConn();

	public static ConnectionPoolProvider getInstance() {
		return instance;
	}

	public SQLConn getSQLConn() {
		return sqlConn;
	}
}
