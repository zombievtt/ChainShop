package dao;

import java.util.List;

import model.BranchShop;
import model.BuyOrder;

public interface BuyOrderDao {
	//Create
	public void addBuyOrder(BuyOrder bo);
	
	
	//Read
	public List<BuyOrder> queryAll();
	public List<BuyOrder> queryAllByShopName(String shopName);
	public List<BuyOrder> queryAllByAccount(String memberAccount);
	public List<BuyOrder> queryAllByShopNameAndAccount(String shopName, String memberAccount);
	
	
	
	//Update
	public void updateBuyOrderShopById(String state, Integer id);
	
	
	//Delete
	public void deleteBuyOrderById(Integer id);
}
