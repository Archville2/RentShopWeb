package by.htp.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.exception.ControllerException;

public final class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CommandProvider provider = new CommandProvider();
	private final static Logger logger = Logger.getLogger(Controller.class);
	private final static String COMMAND="command";
	
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String commandName = request.getParameter(COMMAND);

		try {
			Command command = provider.getCommand(commandName);
			command.execute(request, response);
		} catch (ControllerException e) {
			logger.error("controller message.",e);
		}

	}
}
