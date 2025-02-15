package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BuyOrderDao;
import dao.DbConnection;
import model.BuyOrder;

public class BuyOrderDaoImpl implements BuyOrderDao{

	public static void main(String[] args) {
//		BuyOrder bo = new BuyOrder();
//		bo.setMemberName("張寶");
//		bo.setMemberAccount("hhhh");
//		bo.setMemberPassword("8888");
//		bo.setShopName("水星店");
//		bo.setMenu000Name("豬肉炒麵");
//		bo.setMenu001Name("牛肉炒麵");
//		bo.setMenu002Name("海鮮炒麵");
//		bo.setMenu000Price(100);
//		bo.setMenu000Count(5);
//		bo.setMenu001Price(110);
//		bo.setMenu001Count(2);
//		bo.setMenu002Price(120);
//		bo.setMenu002Count(3);
//		bo.setBuySum(bo.getMenu000Price()*bo.getMenu000Count() +
//				     bo.getMenu001Price()*bo.getMenu001Count() +
//				     bo.getMenu002Price()*bo.getMenu002Count()
//				    );
//		bo.setBuyDate("2024/02/11");
//		bo.setBuyTime("13:24:11");
//		bo.setBuyState(BuyState.strPickUp);
//		new BuyOrderDaoImpl().addBuyOrder(bo);
		
		
		
//		List<BuyOrder> l = new BuyOrderDaoImpl().queryAll();
//		for(BuyOrder bo:l)
//		{
//			System.out.println(bo.getId());
//			System.out.println(bo.getMemberName());
//			System.out.println(bo.getMemberAccount());
//			System.out.println(bo.getMemberPassword());
//			System.out.println(bo.getShopName());
//			System.out.println(bo.getMenu000Name());
//			System.out.println(bo.getMenu001Name());
//			System.out.println(bo.getMenu002Name());
//			System.out.println(bo.getMenu000Price());
//			System.out.println(bo.getMenu000Count());
//			System.out.println(bo.getMenu001Price());
//			System.out.println(bo.getMenu001Count());
//			System.out.println(bo.getMenu002Price());
//			System.out.println(bo.getMenu002Count());
//			System.out.println(bo.getBuySum());
//			System.out.println(bo.getBuyDate());
//			System.out.println(bo.getBuyTime());
//			System.out.println(bo.getBuyState());
//			System.out.println("=================");
//		}
		
		
		
		
//		List<BuyOrder> l = new BuyOrderDaoImpl().queryAllByShopName("水星店");
//		System.out.println(l.size());
//		for(BuyOrder bo:l)
//		{
//			
//			System.out.println(bo.getId());
//			System.out.println(bo.getMemberName());
//			System.out.println(bo.getMemberAccount());
//			System.out.println(bo.getMemberPassword());
//			System.out.println(bo.getShopName());
//			System.out.println(bo.getMenu000Name());
//			System.out.println(bo.getMenu001Name());
//			System.out.println(bo.getMenu002Name());
//			System.out.println(bo.getMenu000Price());
//			System.out.println(bo.getMenu000Count());
//			System.out.println(bo.getMenu001Price());
//			System.out.println(bo.getMenu001Count());
//			System.out.println(bo.getMenu002Price());
//			System.out.println(bo.getMenu002Count());
//			System.out.println(bo.getBuySum());
//			System.out.println(bo.getBuyDate());
//			System.out.println(bo.getBuyTime());
//			System.out.println(bo.getBuyState());
//			System.out.println("=================");
//		}
		
		
		
//		new BuyOrderDaoImpl().updateBuyOrderShopById(BuyState.strPreparing, 9);
		
//		new BuyOrderDaoImpl().deleteBuyOrderById(8);
		
//		List<BuyOrder> l = new BuyOrderDaoImpl().queryAllByShopNameAndAccount("水星店", "1111");
//		if (l.size() > 0)
//		{
//			for (BuyOrder bo: l)
//			{
//				System.out.println(bo.getMemberName() + " " + bo.getMemberAccount() + " " + bo.getShopName() + " " + bo.getBuyDate() + " " + bo.getBuyTime());
//			}
//		}
//		else
//		{
//			System.out.println("沒有符合條件的訂單");
//		}
		
//		List<BuyOrder> l = new BuyOrderDaoImpl().queryAllByAccount("1111");
//		if (l.size() > 0)
//		{
//			for (BuyOrder bo: l)
//			{
//				System.out.println(bo.getMemberName() + " " + bo.getMemberAccount() + " " + bo.getShopName() + " " + bo.getBuyDate() + " " + bo.getBuyTime());
//			}
//		}
//		else
//		{
//			System.out.println("沒有符合條件的訂單");
//		}
	}

	//Create
	public void addBuyOrder(BuyOrder bo)
	{
		Connection conn = DbConnection.getDb();
		String SQL = "insert into buy_order (member_name, member_account, member_password, shop_name, menu_000_name, menu_001_name, menu_002_name, menu_000_price, menu_000_count, " +
		"menu_001_price, menu_001_count, menu_002_price, menu_002_count, buy_sum, buy_date, buy_time, buy_state) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, bo.getMemberName());
			ps.setString(2, bo.getMemberAccount());
			ps.setString(3, bo.getMemberPassword());
			ps.setString(4,  bo.getShopName());
			ps.setString(5,  bo.getMenu000Name());
			ps.setString(6,  bo.getMenu001Name());
			ps.setString(7,  bo.getMenu002Name());
			ps.setInt(8,  bo.getMenu000Price());
			ps.setInt(9, bo.getMenu000Count());
			ps.setInt(10, bo.getMenu001Price());
			ps.setInt(11, bo.getMenu001Count());
			ps.setInt(12, bo.getMenu002Price());
			ps.setInt(13, bo.getMenu002Count());
			ps.setInt(14, bo.getBuySum());
			ps.setString(15, bo.getBuyDate());
			ps.setString(16, bo.getBuyTime());
			ps.setString(17, bo.getBuyState());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Read
	public List<BuyOrder> queryAll()
	{
		Connection conn = DbConnection.getDb();
		String SQL = "select * from buy_order";
		List<BuyOrder> l = new ArrayList<>(); 
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				BuyOrder bo = new BuyOrder();
				bo.setId(rs.getInt("Id"));
				bo.setMemberName(rs.getString("member_name"));
				bo.setMemberAccount(rs.getString("member_account"));
				bo.setMemberPassword(rs.getString("member_password"));
				bo.setShopName(rs.getString("shop_name"));
				bo.setMenu000Name(rs.getString("menu_000_name"));
				bo.setMenu001Name(rs.getString("menu_001_name"));
				bo.setMenu002Name(rs.getString("menu_002_name"));
				bo.setMenu000Price(rs.getInt("menu_000_price"));
				bo.setMenu000Count(rs.getInt("menu_000_count"));
				bo.setMenu001Price(rs.getInt("menu_001_price"));
				bo.setMenu001Count(rs.getInt("menu_001_count"));
				bo.setMenu002Price(rs.getInt("menu_002_price"));
				bo.setMenu002Count(rs.getInt("menu_002_count"));
				bo.setBuySum(rs.getInt("buy_sum"));
				bo.setBuyDate(rs.getString("buy_date"));
				bo.setBuyTime(rs.getString("buy_time"));
				bo.setBuyState(rs.getString("buy_state"));
				l.add(bo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	public List<BuyOrder> queryAllByShopName(String shopName)
	{
		Connection conn = DbConnection.getDb();
		             
		String SQL = "select * from buy_order where shop_name = ?";
		List<BuyOrder> l = new ArrayList<BuyOrder>();
		try {
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, shopName);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				BuyOrder bo = new BuyOrder();
				bo.setId(rs.getInt("id"));
				bo.setMemberName(rs.getString("member_name"));
				bo.setMemberAccount(rs.getString("member_account"));
				bo.setMemberPassword(rs.getString("member_password"));
				bo.setShopName(rs.getString("shop_name"));
				bo.setMenu000Name(rs.getString("menu_000_name"));
				bo.setMenu001Name(rs.getString("menu_001_name"));
				bo.setMenu002Name(rs.getString("menu_002_name"));
				bo.setMenu000Price(rs.getInt("menu_000_price"));
				bo.setMenu000Count(rs.getInt("menu_000_count"));
				bo.setMenu001Price(rs.getInt("menu_001_price"));
				bo.setMenu001Count(rs.getInt("menu_001_count"));
				bo.setMenu002Price(rs.getInt("menu_002_price"));
				bo.setMenu002Count(rs.getInt("menu_002_count"));
				bo.setBuySum(rs.getInt("buy_sum"));
				bo.setBuyDate(rs.getString("buy_date"));
				bo.setBuyTime(rs.getString("buy_time"));
				bo.setBuyState(rs.getString("buy_state"));
				l.add(bo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	
	
	
	
	//Update
	public void updateBuyOrderShopById(String state, Integer id)
	{
		Connection conn = DbConnection.getDb();
		String SQL = "update buy_order set buy_state = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, state);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Delete
	public void deleteBuyOrderById(Integer id)
	{
		Connection conn = DbConnection.getDb();
		String SQL = "delete from buy_order where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<BuyOrder> queryAllByAccount(String memberAccount) {
		Connection conn = DbConnection.getDb();
        
		String SQL = "select * from buy_order where member_account = ?";
		List<BuyOrder> l = new ArrayList<BuyOrder>();
		try {
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, memberAccount);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				BuyOrder bo = new BuyOrder();
				bo.setId(rs.getInt("id"));
				bo.setMemberName(rs.getString("member_name"));
				bo.setMemberAccount(rs.getString("member_account"));
				bo.setMemberPassword(rs.getString("member_password"));
				bo.setShopName(rs.getString("shop_name"));
				bo.setMenu000Name(rs.getString("menu_000_name"));
				bo.setMenu001Name(rs.getString("menu_001_name"));
				bo.setMenu002Name(rs.getString("menu_002_name"));
				bo.setMenu000Price(rs.getInt("menu_000_price"));
				bo.setMenu000Count(rs.getInt("menu_000_count"));
				bo.setMenu001Price(rs.getInt("menu_001_price"));
				bo.setMenu001Count(rs.getInt("menu_001_count"));
				bo.setMenu002Price(rs.getInt("menu_002_price"));
				bo.setMenu002Count(rs.getInt("menu_002_count"));
				bo.setBuySum(rs.getInt("buy_sum"));
				bo.setBuyDate(rs.getString("buy_date"));
				bo.setBuyTime(rs.getString("buy_time"));
				bo.setBuyState(rs.getString("buy_state"));
				l.add(bo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<BuyOrder> queryAllByShopNameAndAccount(String shopName, String memberAccount) {
		
		Connection conn = DbConnection.getDb();
		             
		String SQL = "select * from buy_order where shop_name = ? and member_account = ?";
		List<BuyOrder> l = new ArrayList<BuyOrder>();
		try {
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, shopName);
			ps.setString(2, memberAccount);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				BuyOrder bo = new BuyOrder();
				bo.setId(rs.getInt("id"));
				bo.setMemberName(rs.getString("member_name"));
				bo.setMemberAccount(rs.getString("member_account"));
				bo.setMemberPassword(rs.getString("member_password"));
				bo.setShopName(rs.getString("shop_name"));
				bo.setMenu000Name(rs.getString("menu_000_name"));
				bo.setMenu001Name(rs.getString("menu_001_name"));
				bo.setMenu002Name(rs.getString("menu_002_name"));
				bo.setMenu000Price(rs.getInt("menu_000_price"));
				bo.setMenu000Count(rs.getInt("menu_000_count"));
				bo.setMenu001Price(rs.getInt("menu_001_price"));
				bo.setMenu001Count(rs.getInt("menu_001_count"));
				bo.setMenu002Price(rs.getInt("menu_002_price"));
				bo.setMenu002Count(rs.getInt("menu_002_count"));
				bo.setBuySum(rs.getInt("buy_sum"));
				bo.setBuyDate(rs.getString("buy_date"));
				bo.setBuyTime(rs.getString("buy_time"));
				bo.setBuyState(rs.getString("buy_state"));
				l.add(bo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
		
	}
}
