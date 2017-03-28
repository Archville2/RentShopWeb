package by.htp.shop.service.impl;

import java.util.List;

import by.htp.shop.bean.Item;
import by.htp.shop.dao.ClientsDAO;
import by.htp.shop.dao.ItemsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class FormItemListService {

	public List<Item> formItemList() throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ItemsDAO itemsDAO = daoObjectFactory.getItemsCommandsDAO();

		try {
			List<Item> itemList = itemsDAO.getItemList();
			return itemList;
		} catch (DAOException e) {
			throw new ServiceException("problem with items list", e);
		}

	}
}
