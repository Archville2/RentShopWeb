package by.htp.shop.dao;

import java.util.List;

import by.htp.shop.bean.Item;
import by.htp.shop.dao.exception.DAOException;

public interface ItemsDAO {

	List<Item> getCartItems(List<Integer> cart) throws DAOException;
	List<Item> getItemList() throws DAOException;
	List<String> getFolderElements() throws DAOException;
	
}
