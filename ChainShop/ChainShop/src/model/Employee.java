package model;

import java.io.Serializable;

public class Employee implements Serializable{
	private Integer Id;
	private String name;
	private String account;
	private String password;
	private String shopName;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, String account, String password, String shopName) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.shopName = shopName;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
