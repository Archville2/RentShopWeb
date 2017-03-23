package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;

public class ShowMainPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {

		try {
			HttpSession session = request.getSession(true);
			
			session.removeAttribute("url");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new ControllerException("cant run index.jsp", e);
		}

	}
}
