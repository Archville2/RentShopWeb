package by.htp.shop.service.impl;

import by.htp.shop.bean.ClientData;

public class SelectPageService {
	public String selectPage(ClientData clientData) {

		if (clientData == null) {
			System.out.println("invalid login");
			return "/WEB-INF/jsp/warning.jsp";
		}

		if (clientData.getStatus().equals("user")) {
			System.out.println("you are user");
			return "/WEB-INF/jsp/client_page.jsp";
		}
		if (clientData.getStatus().equals("admin")) {
			System.out.println("you are admin");
			return "/WEB-INF/jsp/admin_page.jsp";
		}

		return "/WEB-INF/jsp/warning.jsp";
	}
}
