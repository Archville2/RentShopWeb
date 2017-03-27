package by.htp.shop.dao.factory;

import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.ItemsDAO;
import by.htp.shop.dao.impl.ClientsCommandsDAO;
import by.htp.shop.dao.impl.ItemsCommandsDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final ClientsDAO clientsDAO = new ClientsCommandsDAO();
	private final ItemsDAO itemsDAO = new ItemsCommandsDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public ClientsDAO getClientsCommandsDAO() {
		return clientsDAO;
	}

	public ItemsDAO getItemsCommandsDAO() {
		return itemsDAO;
	}

}
