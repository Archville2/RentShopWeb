package by.htp.shop.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.bean.ClientData;
import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;

public class AddToCart implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		String id = request.getParameter("cart");
		
		HttpSession session = request.getSession(true);
		ClientData clientData = (ClientData) session.getAttribute("user");
		clientData.setCartValue(Integer.parseInt(id));
		
		System.out.println(id);
		
	}
}
