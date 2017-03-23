package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;

public class ChangeLanguage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		request.getSession(true).setAttribute("locale", request.getParameter("locale"));

		String url = (String) request.getSession(true).getAttribute("url");
		System.out.println(url);
		try {
			if (url == null) {
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect(url);
			}
			// request.getRequestDispatcher("index.jsp").forward(request,
			// response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Override public void execute(HttpServletRequest request,
	 * HttpServletResponse response) throws ControllerException { //String
	 * page=null;
	 * 
	 * HttpSession session = request.getSession(true);
	 * session.setAttribute("locale", request.getParameter("locale"));
	 * 
	 * //RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	 * 
	 * String page = (String) session.getAttribute("page"); try { if (page !=
	 * null) { //response.sendRedirect(page); try {
	 * request.getRequestDispatcher(page).forward(request, response); } catch
	 * (ServletException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } else { response.sendRedirect("index.jsp"); } }
	 * catch (IOException e) { // throw new }
	 */

}
