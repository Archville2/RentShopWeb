package by.htp.shop.service.impl;

import java.util.List;

import by.htp.shop.dao.ItemsDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.exception.ServiceException;

public class FormFolderListService {

	public List<String> getFolderElementList() throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ItemsDAO itemsDAO = daoObjectFactory.getItemsCommandsDAO();

		try {
			List<String> folderList = itemsDAO.getFolderElements();
			return folderList;

		} catch (DAOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
