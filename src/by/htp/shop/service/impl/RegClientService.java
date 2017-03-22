package by.htp.shop.service.impl;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class RegClientService {

	public void regClient(ClientData clientData) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ClientsDAO clientsDAO = daoObjectFactory.getClientsCommandsDAO();

		if (clientData.getName().equals("")) {
			throw new ServiceException("100");
		}

		try {
			clientsDAO.addNewClient(clientData);
		} catch (DAOException e) {

		}

	}
}
