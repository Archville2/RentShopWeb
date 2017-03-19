package by.htp.shop.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;
import by.htp.shop.service.exception.ServiceException;
import by.htp.shop.service.factory.ServiceFactory;
import by.htp.shop.service.impl.FormClientDataService;
import by.htp.shop.service.impl.LoginClientService;

public class LoginClient implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LoginClientService loginClientService = serviceFactory.getLoginClientService();
		FormClientDataService formClientDataService = serviceFactory.getFormClientDataService();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		try {
			loginClientService.loginClient(login, password);
			System.out.println("login ok");
			formClientDataService.formClientData(login);
			System.out.println("form data ok");
		} catch (ServiceException e) {
			throw new ControllerException("login problems", e);
		}
	}
}
