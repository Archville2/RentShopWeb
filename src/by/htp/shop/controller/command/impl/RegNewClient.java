package by.htp.shop.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.shop.bean.ClientData;
import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;
import by.htp.shop.service.exception.ServiceException;
import by.htp.shop.service.factory.ServiceFactory;
import by.htp.shop.service.impl.RegClientService;

public class RegNewClient implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		RegClientService regClientService = serviceFactory.getRegClientService();

		ClientData clientData = new ClientData.ClientDataBuilder(request.getParameter("name"),
				request.getParameter("surname"), request.getParameter("email"), request.getParameter("phone"),
				request.getParameter("login"), request.getParameter("password"), "user").build();

		try {
			regClientService.regClient(clientData);
		} catch (ServiceException e) {
			throw new ControllerException("can't register new client", e);
		}
	}
}
