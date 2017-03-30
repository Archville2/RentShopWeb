package by.htp.shop.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.bean.ClientData;
import by.htp.shop.bean.Item;
import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;
import by.htp.shop.service.exception.ServiceException;
import by.htp.shop.service.factory.ServiceFactory;
import by.htp.shop.service.impl.FormCartItemsService;

public class ShowCart implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		FormCartItemsService formCartItemsService = serviceFactory.getFormCartItemsService();
		HttpSession session = request.getSession(true);
		ClientData clientData = (ClientData) session.getAttribute("user");
		List<Integer> cart = clientData.getCart();
		RequestDispatcher dispatcher = null;
		
		try {
			List<Item> cartItems = formCartItemsService.formCartItems(cart);
			session.setAttribute("cart", cartItems);
			
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/show_cart.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
