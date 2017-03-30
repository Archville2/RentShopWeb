package by.htp.shop.bean;

import java.util.ArrayList;
import java.util.List;

public class ClientData {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String login;
	private String password;
	private String status;
	private List<Integer> cart = new ArrayList<>();

	public ClientData(int id, String name, String surname, String email, String phone, String login, String password,
			String status) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.login = login;
		this.password = password;
		this.status = status;
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
	
	public int getCartValue(int position) {
		return cart.get(position);
	}

	public void setCartValue(int value) {
		Integer v = value;
		cart.add(v);
	}
	
	public List<Integer> getCart(){
		return cart;
	}
}
