package by.htp.shop.dao.provider;

public class ClientProvider {
	private static final ClientProvider instance = new ClientProvider();

	public static ClientProvider getInstance() {
		return instance;
	}

}