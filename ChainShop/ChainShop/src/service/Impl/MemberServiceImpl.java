package service.Impl;

import java.util.List;

import dao.Impl.MemberDaoImpl;
import model.Employee;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{

	private static MemberDaoImpl mdi = new MemberDaoImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void addMember(Member m) {
		// TODO Auto-generated method stub
		mdi.addMember(m);
		
		
	}

	@Override
	public List<Member> queryAll() {
		// TODO Auto-generated method stub
		List<Member> l = mdi.queryAll();
		return l;
	}

	@Override
	public List<Member> queryAllByAccount(String account) {
		// TODO Auto-generated method stub
		List<Member> l = mdi.queryAllByAccount(account);
		return l;
	}

	@Override
	public void updateMemberById(Member e, Integer id) {
		// TODO Auto-generated method stub
		mdi.updateMemberById(e, id);
		
	}

	@Override
	public void deleteMemberById(Integer id) {
		// TODO Auto-generated method stub
		mdi.deleteMemberById(id);
	}

}
