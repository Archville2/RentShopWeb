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
import by.htp.shop.service.impl.RegClientService;

public class RegNewClient implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		RegClientService regClientService = serviceFactory.getRegClientService();
		
		ClientData clientData = new ClientData(
				0,
				request.getParameter("name"),
				request.getParameter("surname"), 
				request.getParameter("email"),
				request.getParameter("phone"),
				request.getParameter("login"), 
				request.getParameter("password"), 
				"user");

		try {
			String message = regClientService.regClient(clientData);
			request.setAttribute("message", message);
			request.setAttribute("client", clientData);
			RequestDispatcher diapatcher = request.getRequestDispatcher("/WEB-INF/jsp/reg_client.jsp");
			
			HttpSession session = request.getSession(true);
			System.out.println(clientData.getId());
			if (clientData.getId() != 0){
				session.setAttribute("user", clientData);
			}
			request.setAttribute("user", clientData);
			
			diapatcher.forward(request, response);

		} catch (ServiceException | IOException | ServletException e) {
			throw new ControllerException("can't register new client", e);
		}
	}
}
