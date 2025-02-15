package dao;

import java.util.List;

import model.Employee;
import model.Member;

public interface MemberDao {
	//Create
	public void addMember(Member e);
	
	
	//Read
	public List<Member> queryAll();
	public List<Member> queryAllByAccount(String account);
	
	
	
	//Update
	public void updateMemberById(Member e, Integer id);
	
	
	//Delete
	public void deleteMemberById(Integer id);
}
