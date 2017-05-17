package by.htp.shop.service.impl;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.LoginException;
import by.htp.shop.service.exception.ServiceException;

public class LoginClientService {
	public ClientData loginClient(String login, String password) throws ServiceException, LoginException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ClientsDAO clientsDAO = daoObjectFactory.getClientsCommandsDAO();

		try {
			int count = clientsDAO.countClients(login);

			if (count == 0) {
				throw new LoginException("incorrect l/p");
			}

			ClientData clientData = clientsDAO.formClientData(login, password);
			return clientData;

		} catch (DAOException e) {
			throw new ServiceException("can't form client data", e);
		}
	}
}
