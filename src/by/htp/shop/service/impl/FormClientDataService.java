package by.htp.shop.service.impl;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class FormClientDataService {
	public void formClientData(String login) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ClientsDAO clientsDAO = daoObjectFactory.getClientsCommandsDAO();

		ClientData clientData = new ClientData();
		clientData.setLogin(login);

		try {
			clientsDAO.formClientData(clientData);
		} catch (DAOException e) {
			throw new ServiceException("cant form client info", e);
		}
	}
}
