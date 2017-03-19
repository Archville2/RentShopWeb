package by.htp.shop.service.impl;

import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class LoginClientService {
	public void loginClient(String login, String password) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ClientsDAO clientsDAO = daoObjectFactory.getClientsCommandsDAO();

		try {
			if (clientsDAO.checkClientLoginPassword(login, password)) {
				System.out.println("Succefully login");
			} else {
				System.out.println("No such client");
			}
			
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
