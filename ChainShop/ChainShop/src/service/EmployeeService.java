package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	//Create
		public void addEmployee(Employee e);
		
		
		//Read
		public List<Employee> queryAll();
		public List<Employee> queryAllByAccount(String Account);
		public List<Employee> queryAllByShopName(String shopName);
		
		
		
		//Update
		public void updateEmployeeById(Employee e, Integer id);
		
		
		//Delete
		public void deleteEmployeeById(Integer id);
}
