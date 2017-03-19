package by.htp.shop.service.impl;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ClientNameError;
import by.htp.shop.service.exception.ServiceException;

public class RegClientService {

	public void regClient(ClientData clientData) throws ServiceException, ClientNameError {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ClientsDAO clientsDAO = daoObjectFactory.getClientsCommandsDAO();

		if (clientData.getName().equals("")) {
			throw new ClientNameError("client name error");
		}

		try {
			clientsDAO.addNewClient(clientData);
		} catch (DAOException e) {

		}

	}
}
