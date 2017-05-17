package by.htp.shop.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;
import by.htp.shop.service.exception.ServiceException;
import by.htp.shop.service.factory.ServiceFactory;
import by.htp.shop.service.impl.RemoveRentedItemService;

public class ReturnItem implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		RemoveRentedItemService removeRentedItemService = serviceFactory.getRemoveRentedItemService();
		
		int equipmentId = Integer.parseInt(request.getParameter("equipment_id"));
		int clientId = Integer.parseInt(request.getParameter("client_id"));
	
		try {
			removeRentedItemService.removeRentedItem(clientId, equipmentId);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
}