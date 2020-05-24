package com.ramyunmoa.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ramyunmoa.web.entity.Review;



public class ReviewService {
	
	
	//전체조회
	public List<Review> getReviewList() throws ClassNotFoundException, SQLException{
		
		List<Review> list =new ArrayList<Review>();
		
		String sql= "SELECT * FROM ReviewBoardTest";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Review review  = new Review(rs.getInt("id"),
					rs.getString("item"),rs.getString("star"),rs.getString("regdate"),
					rs.getString("writerName"),rs.getString("title"),rs.getInt("comment")
					);
			list.add(review);
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		return list;
	} 
	
	//조회
	public Review getReview(int id) throws ClassNotFoundException, SQLException {
		Review review=new Review();
		
		String sql= "SELECT * FROM ReviewBoardTest WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			id=rs.getInt("id");
			String item=rs.getString("item");
			String title=rs.getString("title");
			String star=rs.getString("star");
			int starGrade=rs.getInt("starGrade");
			String regdate=rs.getString("regdate");
			String writerName=rs.getString("writerName");
			int hit = rs.getInt("hit");
			String content=rs.getString("content");
			String gradeTitle=rs.getString("gradeTitle");
			int comment=rs.getInt("comment");
			int likes=rs.getInt("likes");
			
			review=new Review(
					id,item,title,star,starGrade,
					regdate,writerName,hit,content,gradeTitle,comment,likes
					);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return review;
	}
	
	
	//삽입
	public int insertReview(Review review) throws ClassNotFoundException, SQLException {
		int result=0;
		
		String sql = "INSERT INTO ReviewBoardTest(item,star,title,writerName,content,starGrade,gradeTitle) VALUES(?,?,?,?,?,?,?)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setString(1, review.getItem());
		st.setString(2, review.getStar());
		st.setString(3, review.getTitle());
		st.setString(4, review.getWriterName());
		st.setString(5, review.getContent());
		st.setInt(6, review.getStarGrade());
		st.setString(7, review.getGradeTitle());
		
		st.executeUpdate();
		
//		rs.close();
		st.close();
		con.close();
		
		
		return result;
	} 
	
	//수정
	public int updateReview(Review review) throws ClassNotFoundException, SQLException {
		int result=0;
		
		String sql = "UPDATE ReviewBoardTest SET title=?,content=?,item=?,star=?,gradeTitle=?,starGrade=? WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setString(1, review.getTitle());
		st.setString(2, review.getContent());
		st.setString(3, review.getItem());
		st.setString(4, review.getStar());
		st.setString(5, review.getGradeTitle());
		st.setInt(6, review.getStarGrade());
		st.setInt(7, review.getId());
		
		result=st.executeUpdate();
		
//		rs.close();
		st.close();
		con.close();
		
		
		return result;
	} 
	
	//삭제
	public int deleteReview(int id) throws ClassNotFoundException, SQLException {
		
		int result=0;
		
		String sql = "DELETE FROM ReviewBoardTest WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setInt(1, id);
		
		result=st.executeUpdate();
		
//		rs.close();
		st.close();
		con.close();
		
		
		return result;
	} 
	
	
}
