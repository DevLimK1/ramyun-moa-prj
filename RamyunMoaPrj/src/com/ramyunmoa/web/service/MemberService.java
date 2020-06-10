package com.ramyunmoa.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ramyunmoa.web.entity.member.Member;

public class MemberService {

	// ȸ������ ���
	public Member getMember(int id) throws ClassNotFoundException, SQLException {

		Member member = null;

		String sql = "SELECT * FROM Member WHERE ID=?";

		// String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		// Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			member = new Member(rs.getInt("ID"), rs.getString("UID"), rs.getString("EMAIL"), rs.getString("PWD"),
					rs.getString("NICKNAME"), rs.getString("GENDER"), rs.getString("REGDATE"));
		}

		rs.close();
		st.close();
		con.close();

		return member;
	}

	// ȸ������Ʈ
	public List<Member> getMemberList() throws SQLException, ClassNotFoundException {

		List<Member> list = new ArrayList<>();
		int index = 0;

		String sql = "SELECT * FROM Member ORDER BY regdate DESC";// WHERE NUM BETWEEN 1 AND 10";

		// String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		// Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		// st.setString(1, id);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Member member = new Member(rs.getInt("ID"), rs.getString("UID"), rs.getString("EMAIL"), rs.getString("PWD"),
					rs.getString("NICKNAME"), rs.getString("GENDER"), rs.getString("REGDATE"));
			list.add(member);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	// ���̵� �ߺ� Ȯ��
	public boolean checkUid(String uid) throws ClassNotFoundException, SQLException {
		System.out.print("�ߺ�Ȯ��");

		Connection con = null;
		PreparedStatement st = null;
		String sql = null;
		boolean flag = false;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			con = DriverManager.getConnection(url, "rmteam", "rm0322");
			sql = "select uid from Member where uid=?";
			st = con.prepareStatement(sql);
			st.setString(1, uid);
			flag = st.executeQuery().next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// �̸��� �ߺ� Ȯ��
	public boolean checkEmail(String email) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement st = null;

		String sql = null;
		boolean flag = false;
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			con = DriverManager.getConnection(url, "rmteam", "rm0322");
			sql = "select email from Member where email=?";
			st = con.prepareStatement(sql);
			st.setString(1, email);
			flag = st.executeQuery().next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// �г��� �ߺ� Ȯ��
	public boolean checkNick(String nickname) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement st = null;
		String sql = null;
		boolean flag = false;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			con = DriverManager.getConnection(url, "rmteam", "rm0322");
			sql = "select nickname from Member where nickname=?";
			st = con.prepareStatement(sql);
			st.setString(1, nickname);
			flag = st.executeQuery().next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// ȸ������
	public int insertMember(Member member) throws ClassNotFoundException, SQLException {
		int result = 0;
		String sql = "INSERT INTO Member(uid,pwd,email,nickname,gender,grade) values(?,?,?,?,?,?)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, member.getUid());
		st.setString(2, member.getPwd());
		st.setString(3, member.getEmail());
		st.setString(4, member.getNickname());
		st.setString(5, member.getGender());
		st.setString(6, "����ȸ��");

		result = st.executeUpdate();
		System.out.println(result);
		return result;

	}

	// ���������� ��й�ȣ Ȯ��
	public boolean checkPwd(String pwd) throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement st = null;
		String sql = null;
		boolean flag = false;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			con = DriverManager.getConnection(url, "rmteam", "rm0322");
			sql = "select pwd from Member where pwd=?";
			st = con.prepareStatement(sql);
			st.setString(1, pwd);
			flag = st.executeQuery().next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	  public int deleteMember(Integer id) throws ClassNotFoundException,
	  SQLException{// ȸ��Ż��
	  
	  int result=0; String sql = "DELETE FROM Member WHERE id=?"; String url =
	  "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	  
	  Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
	  DriverManager.getConnection(url, "rmteam", "rm0322"); PreparedStatement st =
	  con.prepareStatement(sql); st.setInt(1, id);
	  
	  
	  st.close(); con.close(); result=st.executeUpdate();
	  
	  return result;
	  }
	 

	/*
	 * public boolean deleteMember(String pwd) throws ClassNotFoundException,
	 * SQLException { Connection con = null; PreparedStatement st = null; String sql
	 * = null; boolean flag = false;
	 * 
	 * String url =
	 * "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * try { con = DriverManager.getConnection(url, "rmteam", "rm0322"); sql =
	 * "Delete from Member where pwd=?"; st = con.prepareStatement(sql);
	 * st.setString(1, pwd); flag = st.executeQuery().next();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } return flag; }
	 */

	// �α���
//	public String loginCheck(String uid, String pwd)  throws ClassNotFoundException, SQLException{
//		
//		uid = null;
//		PreparedStatement st = null;
//		ResultSet rs = st.executeQuery();
//		String sql = "SELECT uid FROM Member WHERE uid=? and pwd=?";
//		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");		
//
//	    try {
//	      if(rs.next()) {
//	        uid = rs.getString("uid");
//	        
//	      }
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	    } finally {
//	      try {
//	        if(rs != null)
//	          rs.close();
//	      } catch (Exception e2) {
//	        e2.printStackTrace();
//	      }
//	    }
//			
//	    return uid;
//	}

//	public boolean loginCheck2(String uid) throws ClassNotFoundException, SQLException {
//		
//		boolean flag = false;
//		
//		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//		Class.forName("com.mysql.cj.jdbc.Driver");
//
//		try {
//			Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
//			String sql = "SELECT uid FROM Member WHERE uid=? AND pwd=?";
//			PreparedStatement st = con.prepareStatement(sql);
//			st.setString(1, uid);
//			flag = st.executeQuery().next();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}

	public boolean loginCheck(String uid, String pwd) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement st = null;
		String sql = null;
		boolean flag = false;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			con = DriverManager.getConnection(url, "rmteam", "rm0322");
			sql = "SELECT uid FROM Member WHERE uid=? AND pwd=?";
			st = con.prepareStatement(sql);
			st.setString(1, uid);
			st.setString(2, pwd);
			flag = st.executeQuery().next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}