package service;

import java.util.List;

import model.BuyOrder;

public interface BuyOrderService {
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
