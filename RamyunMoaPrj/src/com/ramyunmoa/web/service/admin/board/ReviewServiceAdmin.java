package com.ramyunmoa.web.service.admin.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ramyunmoa.web.entity.admin.board.BoardAdmin;

public class ReviewServiceAdmin {

	public List<BoardAdmin> getReviewNoticeList(String searchName, int page)
			throws SQLException, ClassNotFoundException {

		List<BoardAdmin> list = new ArrayList<BoardAdmin>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM ReviewBoardNoticeView WHERE title LIKE ? ORDER BY regdate DESC LIMIT ?, 10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, '%' + searchName + '%');
		ps.setInt(2, (page - 1) * 10);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			BoardAdmin board = new BoardAdmin(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
					rs.getInt("likes"), rs.getInt("hit"), rs.getDate("regdate"), rs.getInt("pub"),
					rs.getString("nickname"));

			list.add(board);
		}
		return list;
	}

	public int getReviewNoticeCount(String searchName) throws ClassNotFoundException, SQLException {

		int count = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT count(id) count FROM ReviewBoardNoticeView WHERE title LIKE ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, '%' + searchName + '%');
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			count = rs.getInt("count");

		}

		return count;
	}

	public List<BoardAdmin> getReviewReportList(String searchName, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getReviewReportCount(String searchName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<BoardAdmin> getReviewBoardList(String searchName, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getReviewBoardCount(String searchName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
