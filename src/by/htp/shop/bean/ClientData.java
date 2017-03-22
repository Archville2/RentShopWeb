package by.htp.shop.bean;

public class ClientData {
	private final int id;
	private final String name;
	private final String surname;
	private final String email;
	private final String phone;
	private final String login;
	private final String password;
	private final String status;

	private ClientData(ClientDataBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.surname = builder.surname;
		this.email = builder.email;
		this.phone = builder.phone;
		this.login = builder.login;
		this.password = builder.password;
		this.status = builder.status;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getStatus() {
		return status;
	}

	public static class ClientDataBuilder {
		private int id;
		private final String name;
		private final String surname;
		private final String phone;
		private final String email;
		private final String login;
		private final String password;
		private final String status;

		public ClientDataBuilder(String name, String surname, String email, String phone, String login, String password,
				String status) {
			this.name = name;
			this.surname = surname;
			this.email = email;
			this.phone = phone;
			this.login = login;
			this.password = password;
			this.status = status;
		}

		public ClientDataBuilder id(int id) {
			this.id = id;
			return this;
		}

		public ClientData build() {
			return new ClientData(this);
		}

	}

}
