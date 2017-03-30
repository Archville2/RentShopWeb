package by.htp.shop.service.impl;

import java.util.List;

import by.htp.shop.bean.Item;
import by.htp.shop.dao.ItemsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class FormCartItemsService {

	public List<Item> formCartItems (List<Integer> cart) throws ServiceException{
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ItemsDAO itemsDAO = daoObjectFactory.getItemsCommandsDAO();
				
		try {
			return itemsDAO.getCartItems(cart);
		} catch (DAOException e) {
			throw new ServiceException("cant form cart items", e);
		}
	}
}
