package by.htp.shop.dao;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.exception.DAOException;

public interface ClientsDAO {

	void formClientData(ClientData clientData) throws DAOException;
	
	boolean checkClientLoginPassword(String login, String password) throws DAOException;
	
	void addNewClient(ClientData clientData) throws DAOException;
}