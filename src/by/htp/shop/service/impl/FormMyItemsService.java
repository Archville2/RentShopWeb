package by.htp.shop.service.impl;

import java.util.List;

import by.htp.shop.bean.Item;
import by.htp.shop.dao.ItemsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class FormMyItemsService {

	public List<Item> formMyItems(int clientId) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ItemsDAO itemsDAO = daoObjectFactory.getItemsCommandsDAO();

		try {
			return itemsDAO.getMyItems(clientId);
		} catch (DAOException e) {
			throw new ServiceException("cant get my items", e);
		}

	}
}
