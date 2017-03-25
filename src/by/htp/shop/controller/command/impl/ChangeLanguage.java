package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;

public class ChangeLanguage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		request.getSession(true).setAttribute("locale", request.getParameter("locale"));

		String url = (String) request.getSession(true).getAttribute("url");

		try {
			if (url == null) {
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect(url);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
