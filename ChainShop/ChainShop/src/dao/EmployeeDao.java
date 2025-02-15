package dao;

import java.util.List;

import model.BuyOrder;
import model.Employee;

public interface EmployeeDao {
	//Create
	public void addEmployee(Employee e);
	
	
	//Read
	public List<Employee> queryAll();
	public List<Employee> queryAllByAccount(String account);
	public List<Employee> queryAllByShopName(String shopName);
	
	
	
	//Update
	public void updateEmployeeById(Employee e, Integer id);
	
	
	//Delete
	public void deleteEmployeeById(Integer id);
}
