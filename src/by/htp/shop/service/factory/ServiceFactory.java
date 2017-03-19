package by.htp.shop.service.factory;

import by.htp.shop.service.impl.FormClientDataService;
import by.htp.shop.service.impl.LoginClientService;
import by.htp.shop.service.impl.RegClientService;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final RegClientService regClientService = new RegClientService();
	private final LoginClientService loginClientService = new LoginClientService();
	private final FormClientDataService formClientDataService = new FormClientDataService();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public RegClientService getRegClientService() {
		return regClientService;
	}
	
	public LoginClientService getLoginClientService(){
		return loginClientService;
	}
	
	public FormClientDataService getFormClientDataService(){
		return formClientDataService;
	}

}
