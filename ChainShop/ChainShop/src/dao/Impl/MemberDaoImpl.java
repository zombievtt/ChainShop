package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Employee;
import model.Member;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
//		Member m = new Member();
//		m.setName("魯肅");
//		m.setAccount("aaaa");
//		m.setPassword("1234");
//		new MemberDaoImpl().addMemberDao(m);
		
//		List<Member> l = new MemberDaoImpl().queryAll();
//		for (Member m:l)
//		{
//			System.out.println(m.getId());
//			System.out.println(m.getName());
//			System.out.println(m.getAccount());
//			System.out.println(m.getPassword());
//			System.out.println("==============");
//		}
		
//		List<Member> l = new MemberDaoImpl().queryAllByAccount("aaaa");
//		for (Member m:l)
//		{
//			System.out.println(m.getId());
//			System.out.println(m.getName());
//			System.out.println(m.getAccount());
//			System.out.println(m.getPassword());
//			System.out.println("==============");
//		}
		
//		Member m = new Member();
//		m.setName("張昭");
//		m.setAccount("1111");
//		m.setPassword("2222");
//		new MemberDaoImpl().updateMemberById(m, 1);
		
		
//		new MemberDaoImpl().deleteMemberById(2);
		

	}

	public void addMember(Member m)
	{
		Connection conn = DbConnection.getDb();
		String SQL = "insert into member(name, account, password) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getAccount());
			ps.setString(3, m.getPassword());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	//Read
	public List<Member> queryAll()
	{
		List<Member> l = new ArrayList<Member>();
		
		Connection conn = DbConnection.getDb();
		String SQL = "select * from member";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	public List<Member> queryAllByAccount(String account)
	{
		List<Member> l = new ArrayList<Member>();
		Connection conn = DbConnection.getDb();
		String SQL = "select * from member where account = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
	
	
	//Update
	public void updateMemberById(Member m, Integer id)
	{
		Connection conn = DbConnection.getDb();
		String SQL = "update member set name=?, account=?, password=? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getAccount());
			ps.setString(3, m.getPassword());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	//Delete
	public void deleteMemberById(Integer id)
	{
		Connection conn = DbConnection.getDb();
		String SQL = "delete from member where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
