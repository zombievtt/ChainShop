package dao;

import java.util.List;

import model.BranchShop;

public interface BranchShopDao {
	
	//Create
	public void addBranchShop(BranchShop bs);
	
	
	//Read
	public List<BranchShop> queryAll();
	public List<BranchShop> queryAllByShopName(String shopName);
	//public List<BranchShop> queryAllByBuyState(String buyState);
	
	
	
	//Update
	public void updateBranchShopById(BranchShop bs, Integer Id);
	
	
	//Delete
	public void deleteBranchShopById(Integer id);

}
