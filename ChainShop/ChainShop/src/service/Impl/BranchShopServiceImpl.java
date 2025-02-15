package service.Impl;

import java.util.List;

import dao.Impl.BranchShopDaoImpl;
import model.BranchShop;
import service.BranchShopService;

public class BranchShopServiceImpl implements BranchShopService {

	private static BranchShopDaoImpl bsdi = new BranchShopDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBranchShop(BranchShop bs) {
		// TODO Auto-generated method stub
		bsdi.addBranchShop(bs);
		
	}

	@Override
	public List<BranchShop> queryAll() {
		List<BranchShop> l = bsdi.queryAll();
		return l;
	}

	@Override
	public List<BranchShop> queryAllByShopName(String shopName) {
		// TODO Auto-generated method stub
		List<BranchShop> l = bsdi.queryAllByShopName(shopName);
		return l;
	}

	@Override
	public void updateBranchShopById(BranchShop bs, Integer id) {
		// TODO Auto-generated method stub
		bsdi.updateBranchShopById(bs, id);
		
	}

	@Override
	public void deleteBranchShopById(Integer id) {
		// TODO Auto-generated method stub
		bsdi.deleteBranchShopById(id);
		
	}
}
