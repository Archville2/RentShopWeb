package by.htp.shop.dao.factory;

import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.impl.ClientsCommandsDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ClientsDAO clientsDAO = new ClientsCommandsDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public ClientsDAO getClientsCommandsDAO() {
		return clientsDAO;
	}

}
