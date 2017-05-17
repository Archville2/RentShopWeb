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

public class ShowMainPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		RequestDispatcher dispatcher = null;
		try {
			HttpSession session = request.getSession(true);
			session.setAttribute("url", "index.jsp");
			dispatcher = request.getRequestDispatcher("index.jsp");
			
			if(session.getAttribute("user") != null){
				ClientData clientData = (ClientData) session.getAttribute("user");
				String login = clientData.getLogin();
				String password = clientData.getPassword();
				dispatcher = request.getRequestDispatcher("Controller?command=Login_Client&login="+login+"&password="+password);
			}

			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new ControllerException("cant run index.jsp", e);
		}

	}
}
