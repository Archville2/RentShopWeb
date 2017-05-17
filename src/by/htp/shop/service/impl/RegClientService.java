package by.htp.shop.service.impl;

import by.htp.shop.bean.ClientData;
import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class RegClientService {

	public String regClient(ClientData clientData) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ClientsDAO clientsDAO = daoObjectFactory.getClientsCommandsDAO();

		if (clientData.getName().equals("") | 
				clientData.getSurname().equals("") |
				clientData.getEmail().equals("") |
				clientData.getPhone().equals("") |
				clientData.getLogin().equals("") |
				clientData.getPassword().equals("")) {
			return "Все поля должны быть заполнены";
		}

		try {
			int count = clientsDAO.countClients(clientData.getLogin());
			
			if (count!=0) {
				return "Логин занят. Выберите другой.";
			}
			clientsDAO.addNewClient(clientData);
			return "Регистрация успешно завершена";
			
		} catch (DAOException e) {
			throw new ServiceException("cant reg client", e);
		}
	}
}
