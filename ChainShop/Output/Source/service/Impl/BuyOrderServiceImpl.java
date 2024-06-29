package service.Impl;

import java.util.List;

import dao.Impl.BuyOrderDaoImpl;
import model.BuyOrder;
import service.BuyOrderService;

public class BuyOrderServiceImpl implements BuyOrderService {

	private static BuyOrderDaoImpl bodi = new BuyOrderDaoImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void addBuyOrder(BuyOrder bo) {
		// TODO Auto-generated method stub
		bodi.addBuyOrder(bo);
		
	}

	@Override
	public List<BuyOrder> queryAll() {
		// TODO Auto-generated method stub
		List<BuyOrder> l = bodi.queryAll();
		return l;
	}

	@Override
	public List<BuyOrder> queryAllByShopName(String shopName) {
		// TODO Auto-generated method stub
		List<BuyOrder> l = bodi.queryAllByShopName(shopName); 
		return l;
	}

	@Override
	public void updateBuyOrderShopById(String state, Integer id) {
		// TODO Auto-generated method stub
		bodi.updateBuyOrderShopById(state, id);
		
	}

	@Override
	public void deleteBuyOrderById(Integer id) {
		// TODO Auto-generated method stub
		bodi.deleteBuyOrderById(id);
		
	}

	@Override
	public List<BuyOrder> queryAllByAccount(String memberAccount) {
		// TODO Auto-generated method stub
		List<BuyOrder> l = bodi.queryAllByAccount(memberAccount);
		return l;
	}

	@Override
	public List<BuyOrder> queryAllByShopNameAndAccount(String shopName, String memberAccount) {
		List<BuyOrder> l = bodi.queryAllByShopNameAndAccount(shopName, memberAccount);
		return l;
	}

}
