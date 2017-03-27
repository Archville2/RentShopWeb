package by.htp.shop.dao;

import java.util.List;

import by.htp.shop.dao.exception.DAOException;

public interface ItemsDAO {

	List<String> getFolderElements() throws DAOException;
	
}
