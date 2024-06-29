package service.Impl;

import java.util.List;

import dao.EmployeeDao;
import dao.Impl.EmployeeDaoImpl;
import model.Employee;

public class EmployeeServiceImpl implements EmployeeDao {

	private static EmployeeDaoImpl edi = new EmployeeDaoImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
		edi.addEmployee(e);
		
	}

	@Override
	public List<Employee> queryAll() {
		// TODO Auto-generated method stub
		List<Employee> l = edi.queryAll();
		return l;
	}

	@Override
	public List<Employee> queryAllByShopName(String shopName) {
		// TODO Auto-generated method stub
		List<Employee> l = edi.queryAllByShopName(shopName);
		return l;
	}

	@Override
	public void updateEmployeeById(Employee e, Integer id) {
		// TODO Auto-generated method stub
		edi.updateEmployeeById(e, id);
		
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		edi.deleteEmployeeById(id);
		
	}

	@Override
	public List<Employee> queryAllByAccount(String account) {
		List<Employee> l = edi.queryAllByAccount(account);
		return l;
	}

}
