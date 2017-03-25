package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;

public class GoTo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		String page = request.getParameter("go_to_page");
		HttpSession session = request.getSession(true);
		
		String query = request.getQueryString();
		String uri = request.getRequestURI();
	
		session.setAttribute("url", uri+"?"+query);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/"+page);

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new ControllerException("cant run reg_client.jsp", e);
		}
	}
}
