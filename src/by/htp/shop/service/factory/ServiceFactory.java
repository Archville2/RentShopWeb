package by.htp.shop.service.factory;

import by.htp.shop.service.impl.FormCartItemsService;
import by.htp.shop.service.impl.FormFolderListService;
import by.htp.shop.service.impl.FormItemListService;
import by.htp.shop.service.impl.LoginClientService;
import by.htp.shop.service.impl.RegClientService;
import by.htp.shop.service.impl.SelectPageService;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final RegClientService regClientService = new RegClientService();
	private final LoginClientService loginClientService = new LoginClientService();
	private final SelectPageService selectPageService = new SelectPageService();
	private final FormFolderListService formFolderListService = new FormFolderListService();
	private final FormItemListService formItemListService = new FormItemListService();
	private final FormCartItemsService formCartItemsService = new FormCartItemsService();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public RegClientService getRegClientService() {
		return regClientService;
	}

	public LoginClientService getLoginClientService() {
		return loginClientService;
	}

	public SelectPageService getSelectPageService() {
		return selectPageService;
	}

	public FormFolderListService getFormFolderListService() {
		return formFolderListService;
	}

	public FormItemListService getFormItemListService() {
		return formItemListService;
	}
	
	public FormCartItemsService getFormCartItemsService () {
		return formCartItemsService;
	}

}
