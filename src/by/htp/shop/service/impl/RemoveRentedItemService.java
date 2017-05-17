package by.htp.shop.service.impl;

import by.htp.shop.dao.ItemsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class RemoveRentedItemService {
	public void removeRentedItem(int clientId, int equipmentId) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ItemsDAO itemsDAO = daoObjectFactory.getItemsCommandsDAO();
		
		try {
			itemsDAO.removeRentedItem(clientId, equipmentId);
			itemsDAO.resetIsRented(equipmentId);
		} catch (DAOException e) {
			throw new ServiceException("cant remove rented item", e);
		}
	}
}
