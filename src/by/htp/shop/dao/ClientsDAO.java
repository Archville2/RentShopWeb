package by.htp.shop.dao;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.exception.DAOException;

public interface ClientsDAO {

	ClientData formClientData(String login, String password) throws DAOException;
	
	int countClients(String login, String password) throws DAOException;
	
	void addNewClient(ClientData clientData) throws DAOException;
}