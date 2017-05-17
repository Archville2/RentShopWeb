package by.htp.shop.service.impl;

import by.htp.shop.dao.ItemsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class AddRentedItemService {

	public void addRentedItem(int clientId, int equipmentId, int days) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ItemsDAO itemsDAO = daoObjectFactory.getItemsCommandsDAO();

		try {
			itemsDAO.addRentedItem(clientId, equipmentId, days);
			itemsDAO.setIsRented(equipmentId);
		} catch (DAOException e) {
			throw new ServiceException("cant rent item", e);
		}
	}

}
