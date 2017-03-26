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

public class CheckSession implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		HttpSession session = request.getSession(true);
		ClientData clientData = (ClientData) session.getAttribute("user");

		System.out.println("checksession");

		try {
			if (clientData != null) {

				String login = clientData.getLogin();
				String password = clientData.getPassword();
				RequestDispatcher dispatcher = request.getRequestDispatcher(
						"Controller?command=login_client&login=" + login + "&password=" + password);
				dispatcher.forward(request, response);
			}
			//response.sendRedirect("Controller?command=show_main_page");
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
