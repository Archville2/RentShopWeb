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
import by.htp.shop.service.exception.ClientNameError;
import by.htp.shop.service.exception.ServiceException;
import by.htp.shop.service.factory.ServiceFactory;
import by.htp.shop.service.impl.RegClientService;

public class RegNewClient implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		RegClientService regClientService = serviceFactory.getRegClientService();

		HttpSession session = request.getSession(true);
		ClientData clientData = (ClientData)session.getAttribute ("regClientData");
		if (clientData == null) {
			clientData = new ClientData();
		    session.setAttribute("regClientData", clientData);
		}
		
		//RegClientData regClientData = new RegClientData();

		clientData.setName(request.getParameter("name"));
		clientData.setSurname(request.getParameter("surname"));
		clientData.setEmail(request.getParameter("email"));
		clientData.setPhone(request.getParameter("phone"));
		clientData.setLogin(request.getParameter("login"));
		clientData.setPassword(request.getParameter("password"));

		try {
			regClientService.regClient(clientData);
		} catch (ServiceException e2) {
			throw new ControllerException("error", e2);
		} catch (ClientNameError e2) {
			request.setAttribute("err_name", "#ff0000");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("reg_client.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// dispatcher = request.getRequestDispatcher("error.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
			}
		}

	}
}
