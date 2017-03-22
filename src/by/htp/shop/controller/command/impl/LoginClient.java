package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.bean.ClientData;
import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;
import by.htp.shop.service.exception.ServiceException;
import by.htp.shop.service.factory.ServiceFactory;
import by.htp.shop.service.impl.LoginClientService;
import by.htp.shop.service.impl.SelectPageService;

public class LoginClient implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LoginClientService loginClientService = serviceFactory.getLoginClientService();
		SelectPageService selectPageService = serviceFactory.getSelectPageService();

		RequestDispatcher dispatcher = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		try {
			ClientData clientData = loginClientService.loginClient(login, password);
			String page = selectPageService.selectPage(clientData);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("user", clientData);
			session.setAttribute("page", page);
			
			dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);

		} catch (ServiceException e) {
			throw new ControllerException("login problems", e);
		} catch (ServletException | IOException e1) {
			// log
			try {
				dispatcher.forward(request, response);
			} catch (ServletException |IOException e2) {
				//log
			}
			
		}
	}
}
