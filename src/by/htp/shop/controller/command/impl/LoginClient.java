package by.htp.shop.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;
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
import by.htp.shop.service.impl.FormFolderListService;
import by.htp.shop.service.impl.FormItemListService;
import by.htp.shop.service.impl.LoginClientService;
import by.htp.shop.service.impl.SelectPageService;

public class LoginClient implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LoginClientService loginClientService = serviceFactory.getLoginClientService();
		SelectPageService selectPageService = serviceFactory.getSelectPageService();
		FormFolderListService formFolderListService = serviceFactory.getFormFolderListService();
		FormItemListService formItemListService = serviceFactory.getFormItemListService();

		RequestDispatcher dispatcher = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		try {
			ClientData clientData = loginClientService.loginClient(login, password);
			String page = selectPageService.selectPage(clientData);

			if (clientData != null) {
				List<String> folderList = new ArrayList<>();
				List<Item> itemList = new ArrayList<>();

				itemList = formItemListService.formItemList();
				folderList = formFolderListService.getFolderElementList();
				request.setAttribute("c_name", clientData.getName());
				request.setAttribute("folder", folderList);
				request.setAttribute("items", itemList);

				HttpSession session = request.getSession(true);
				session.setAttribute("user", clientData);
				session.setAttribute("url", "Controller?command=login_client&login=" + login + "&password=" + password);
			}
			dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);

		} catch (ServiceException e) {
			throw new ControllerException("login problems", e);
		} catch (ServletException | IOException e1) {
			// log
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e2) {
				// log
			}

		}
	}
}
