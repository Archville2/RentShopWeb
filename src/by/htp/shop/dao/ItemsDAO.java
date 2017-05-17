package by.htp.shop.dao;

import java.util.List;

import by.htp.shop.bean.Item;
import by.htp.shop.dao.exception.DAOException;

public interface ItemsDAO {

	void removeRentedItem(int clientId, int equipmentId) throws DAOException;
	void resetIsRented (int equipmentId) throws DAOException;
	void setIsRented (int equipmentId) throws DAOException;
	List<Item> getMyItems (int clientId) throws DAOException;
	void addRentedItem(int clientId, int equipmentId, int days) throws DAOException;
	List<Item> getCartItems(List<Integer> cart) throws DAOException;
	List<Item> getItemList() throws DAOException;
	List<String> getFolderElements() throws DAOException;
	
}
