package model;

import java.io.Serializable;

public class BuyOrder implements Serializable{
	private Integer Id;
	private String memberName;
	private String memberAccount;
	private String memberPassword;
	private String shopName;
	private String menu000Name, menu001Name, menu002Name;
	private Integer menu000Price, menu001Price, menu002Price;
	private Integer menu000Count, menu001Count, menu002Count;
	private Integer buySum;
	private String buyDate;
	private String buyTime;
	private String buyState;
	public BuyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyOrder(String memberName, String memberAccount, String memberPassword, String shopName,
			String menu000Name, String menu001Name, String menu002Name, Integer menu000Price, Integer menu001Price,
			Integer menu002Price, Integer menu000Count, Integer menu001Count, Integer menu002Count, Integer buySum,
			String buyDate, String buyTime, String buyState) {
		super();
		this.memberName = memberName;
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
		this.shopName = shopName;
		this.menu000Name = menu000Name;
		this.menu001Name = menu001Name;
		this.menu002Name = menu002Name;
		this.menu000Price = menu000Price;
		this.menu001Price = menu001Price;
		this.menu002Price = menu002Price;
		this.menu000Count = menu000Count;
		this.menu001Count = menu001Count;
		this.menu002Count = menu002Count;
		this.buySum = buySum;
		this.buyDate = buyDate;
		this.buyTime = buyTime;
		this.buyState = buyState;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getMenu000Name() {
		return menu000Name;
	}
	public void setMenu000Name(String menu000Name) {
		this.menu000Name = menu000Name;
	}
	public String getMenu001Name() {
		return menu001Name;
	}
	public void setMenu001Name(String menu001Name) {
		this.menu001Name = menu001Name;
	}
	public String getMenu002Name() {
		return menu002Name;
	}
	public void setMenu002Name(String menu002Name) {
		this.menu002Name = menu002Name;
	}
	public Integer getMenu000Price() {
		return menu000Price;
	}
	public void setMenu000Price(Integer menu000Price) {
		this.menu000Price = menu000Price;
	}
	public Integer getMenu001Price() {
		return menu001Price;
	}
	public void setMenu001Price(Integer menu001Price) {
		this.menu001Price = menu001Price;
	}
	public Integer getMenu002Price() {
		return menu002Price;
	}
	public void setMenu002Price(Integer menu002Price) {
		this.menu002Price = menu002Price;
	}
	public Integer getMenu000Count() {
		return menu000Count;
	}
	public void setMenu000Count(Integer menu000Count) {
		this.menu000Count = menu000Count;
	}
	public Integer getMenu001Count() {
		return menu001Count;
	}
	public void setMenu001Count(Integer menu001Count) {
		this.menu001Count = menu001Count;
	}
	public Integer getMenu002Count() {
		return menu002Count;
	}
	public void setMenu002Count(Integer menu002Count) {
		this.menu002Count = menu002Count;
	}
	public Integer getBuySum() {
		return buySum;
	}
	public void setBuySum(Integer buySum) {
		this.buySum = buySum;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public String getBuyState() {
		return buyState;
	}
	public void setBuyState(String buyState) {
		this.buyState = buyState;
	}
	
	
}
