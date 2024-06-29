package model;

import java.io.Serializable;

public class Member implements Serializable {
	private Integer Id;
	private String name;
	private String account;
	private String password;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String name, String account, String password) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
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
	
	
}
