package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.EmployeeDao;
import model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	public static void main(String[] args) {
		
//		Employee e = new Employee();
//		e.setName("張療");
//		e.setAccount("bbbb");
//		e.setPassword("2222");
//		e.setShopName("水星店");
//		new EmployeeDaoImpl().addEmployeeDao(e);
		
		
//		List<Employee> l = new EmployeeDaoImpl().queryAll();
//		for (Employee e:l)
//		{
//			System.out.println(e.getId());
//			System.out.println(e.getName());
//			System.out.println(e.getAccount());
//			System.out.println(e.getPassword());
//			System.out.println(e.getShopName());
//			System.out.println("==============");
//		}
		
//		List<Employee> l = new EmployeeDaoImpl().queryAllByShopName("水星店");
//		for (Employee e:l)
//		{
//			System.out.println(e.getId());
//			System.out.println(e.getName());
//			System.out.println(e.getAccount());
//			System.out.println(e.getPassword());
//			System.out.println(e.getShopName());
//			System.out.println("==============");
//		}
		
//		Employee e = new Employee();
//		e.setName("張繡");
//		e.setAccount("dddd");
//		e.setPassword("3333");
//		e.setShopName("水星店");
//		new EmployeeDaoImpl().updateEmployeeById(e, 3);
		
		
//		new EmployeeDaoImpl().deleteEmployeeById(3);
		
//		List<Employee> l = new EmployeeDaoImpl().queryAllByAccount("cccc");
//		if (l.size() <= 0)
//		{
//			System.out.println("此帳號員工不存在");
//		}
//		else
//		{
//			for (Employee e:l)
//			{
//				System.out.println(e.getId());
//				System.out.println(e.getName());
//				System.out.println(e.getAccount());
//				System.out.println(e.getPassword());
//				System.out.println(e.getShopName());
//				System.out.println("==============");
//			}
//		}
		

	}

	//Create
	public void addEmployee(Employee e)
	{
		Connection conn = DbConnection.getDb();
		String SQL = "insert into employee(name, account, password, shop_name) values(?, ?, ?, ?) ";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, e.getName());
			ps.setString(2, e.getAccount());
			ps.setString(3,  e.getPassword());
			ps.setString(4,  e.getShopName());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	//Read
	public List<Employee> queryAll()
	{
		Connection conn = DbConnection.getDb();
		String SQL = "select * from employee";
		List<Employee> l = new ArrayList<Employee>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setAccount(rs.getString("account"));
				e.setPassword(rs.getString("password"));
				e.setShopName(rs.getString("shop_name"));
				l.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public List<Employee> queryAllByShopName(String shopName)
	{
		Connection conn = DbConnection.getDb();
		List<Employee> l = new ArrayList<Employee>();
		String SQL = "select * from employee where shop_name = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, shopName);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setAccount(rs.getString("account"));
				e.setPassword(rs.getString("password"));
				e.setShopName(rs.getString("shop_name"));
				l.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	
	
	//Update
	public void updateEmployeeById(Employee e, Integer id)
	{
		Connection conn = DbConnection.getDb();
		String SQL = "update employee set name=?, account=?, password=?, shop_name=? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, e.getName());
			ps.setString(2, e.getAccount());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getShopName());
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	//Delete
	public void deleteEmployeeById(Integer id)
	{
		Connection conn = DbConnection.getDb();
		String SQL = "delete from employee where id = ?";
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
	public List<Employee> queryAllByAccount(String account) {
		Connection conn = DbConnection.getDb();
		List<Employee> l = new ArrayList<Employee>();
		String SQL = "select * from employee where account = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setAccount(rs.getString("account"));
				e.setPassword(rs.getString("password"));
				e.setShopName(rs.getString("shop_name"));
				l.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
}
