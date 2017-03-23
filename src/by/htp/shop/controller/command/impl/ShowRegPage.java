package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;

public class ShowRegPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {

		HttpSession session = request.getSession(true);
		session.setAttribute("url", "/SportEquipmentWeb/Controller?command=show_reg_page");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reg_client.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new ControllerException("cant run reg_client.jsp", e);
		}

	}
}
