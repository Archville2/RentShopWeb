package by.htp.shop.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;
import by.htp.shop.service.exception.ServiceException;
import by.htp.shop.service.factory.ServiceFactory;
import by.htp.shop.service.impl.AddRentedItemService;

public class RentItem implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AddRentedItemService addRentedItemService = serviceFactory.getAddRentedItemService();

		int equipmentId = Integer.parseInt(request.getParameter("equipment_id"));
		int clientId = Integer.parseInt(request.getParameter("client_id"));
		int days = Integer.parseInt(request.getParameter("days"));

		try {
			addRentedItemService.addRentedItem(clientId, equipmentId, days);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
}