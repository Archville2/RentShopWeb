package by.htp.shop.controller;

import java.util.Map;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.command.CommandName;
import by.htp.shop.controller.command.impl.ChangeLanguage;
import by.htp.shop.controller.command.impl.CheckSession;
import by.htp.shop.controller.command.impl.GoTo;
import by.htp.shop.controller.command.impl.LogOutClient;
import by.htp.shop.controller.command.impl.LoginClient;
import by.htp.shop.controller.command.impl.RegNewClient;
import by.htp.shop.controller.command.impl.ShowMainPage;
import by.htp.shop.controller.command.impl.ShowRegPage;
import by.htp.shop.controller.exception.ControllerException;

import java.util.HashMap;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.REG_NEW_CLIENT, new RegNewClient());
		repository.put(CommandName.CHANGE_LANGUAGE, new ChangeLanguage());
		repository.put(CommandName.LOGIN_CLIENT, new LoginClient());
		repository.put(CommandName.LOGOUT_CLIENT, new LogOutClient());
		repository.put(CommandName.SHOW_REG_PAGE, new ShowRegPage());
		repository.put(CommandName.SHOW_MAIN_PAGE, new ShowMainPage());
		repository.put(CommandName.GO_TO, new GoTo());
		repository.put(CommandName.CHECK_SESSION, new CheckSession());
	}

	Command getCommand(String name) throws ControllerException {
		try {
			CommandName commandName = CommandName.valueOf(name.toUpperCase());
			return repository.get(commandName);
		} catch (Exception e) {
			throw new ControllerException("incorrect command", e);
		}

	}
}