package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;

public class LogOutClient implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		HttpSession session = request.getSession(true);
		session.removeAttribute("user");
		session.setAttribute("url", "index.jsp");
		
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			throw new ControllerException("log out problems", e);
		}
	}
}
