package com.ramyunmoa.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ramyunmoa.web.view.product.AdminProdView;
import com.ramyunmoa.web.view.product.NutritionView;
import com.ramyunmoa.web.view.product.ProductView;
import com.ramyunmoa.web.view.product.RankingView;

public class ProductService {

	public List<ProductView> getProdList(String mfr, String searchName, int page)
			throws SQLException, ClassNotFoundException {

		List<ProductView> list = new ArrayList<ProductView>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM ProductView WHERE mfr LIKE ? AND name LIKE ? ORDER BY name LIMIT ?, 25";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, '%' + mfr + '%');
		ps.setString(2, '%' + searchName + '%');
		ps.setInt(3, (page - 1) * 25);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ProductView product = new ProductView(rs.getInt("id"), rs.getString("name"), rs.getString("mfr"),
					rs.getString("img"));

			list.add(product);
		}
		return list;
	}

	public List<RankingView> getRanking(String mfr) throws SQLException, ClassNotFoundException {

		List<RankingView> rankingList = new ArrayList<RankingView>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM RankingView WHERE mfr LIKE ? ORDER BY amount DESC LIMIT 10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, '%' + mfr + '%');
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			RankingView rank = new RankingView(rs.getInt("id"), rs.getString("name"), rs.getInt("manufacturerId"),
					rs.getInt("amount"), rs.getInt("year"), rs.getInt("quarter"), rs.getString("logo"),
					rs.getString("img"));

			rankingList.add(rank);
		}
		return rankingList;
	}

	public int getListCount(String mfr, String searchName) throws ClassNotFoundException, SQLException {

		int count = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT COUNT(id) count FROM ProductView WHERE mfr LIKE ? AND name LIKE ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, '%' + mfr + '%');
		ps.setString(2, '%' + searchName + '%');
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			count = rs.getInt("count");
		}
		return count;
	}

	public NutritionView getNutrition(int id) throws SQLException, ClassNotFoundException {

		NutritionView nutrition = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM NutritionView WHERE id = ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			nutrition = new NutritionView(rs.getInt("id"), rs.getString("name"), rs.getString("img"), rs.getInt("kcal"),
					rs.getInt("capacity"), rs.getInt("natrium"), rs.getInt("carbohydrate"), rs.getInt("sugars"),
					rs.getInt("fat"), rs.getInt("transFat"), rs.getInt("saturatedFat"), rs.getInt("cholesterol"),
					rs.getInt("protein"));
		}
		return nutrition;
	}

	public List<AdminProdView> getAdminList(String mfr, String searchName, int page)
			throws SQLException, ClassNotFoundException {

		List<AdminProdView> adminProdList = new ArrayList<AdminProdView>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM AdminProdView WHERE mfr LIKE ? AND name LIKE ? ORDER BY id LIMIT ?, 5";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, '%' + mfr + '%');
		ps.setString(2, '%' + searchName + '%');
		ps.setInt(3, (page - 1) * 5);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			AdminProdView temp = new AdminProdView(rs.getInt("id"), rs.getString("name"), rs.getInt("capacity"),
					rs.getInt("kcal"), rs.getInt("natrium"), rs.getInt("carbohydrate"), rs.getInt("sugars"),
					rs.getInt("fat"), rs.getInt("transfat"), rs.getInt("saturatedFat"), rs.getInt("cholesterol"),
					rs.getInt("protein"), rs.getString("mfr"), rs.getInt("amount"), rs.getInt("year"),
					rs.getInt("quarter"), rs.getString("img"));
			adminProdList.add(temp);
		}
		return adminProdList;
	}

	public NutritionView getNutriStd() throws SQLException, ClassNotFoundException {

		NutritionView nutriStd = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM NutritionStd";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			nutriStd = new NutritionView(rs.getInt("natrium"), rs.getInt("carbohydrate"), rs.getInt("sugars"),
					rs.getInt("fat"), rs.getInt("transFat"), rs.getInt("saturatedFat"), rs.getInt("cholesterol"),
					rs.getInt("protein"));
		}
		return nutriStd;
	}

	public void insertData(AdminProdView data) throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");

		String sql1 = "INSERT INTO Product VALUES(?, ?, ?, ?, ?)";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ResultSet rs1 = ps1.executeQuery();
		ps1.setString(1, data.getName());
		ps1.setInt(2, data.getCapacity());
		ps1.setInt(3, data.getKcal());
		ps1.setInt(4, data.getMfrId());
		ps1.setString(5, data.getImg());

		String sql2 = "SELECT id FROM Product ORDER BY id DESC LIMIT 1;";
		Statement st2 = con.createStatement();
		ResultSet rs2 = st2.executeQuery(sql2);

		int productId = 0;
		if (rs2.next()) {
			productId = rs2.getInt("id");
		}

		String sql3 = "INSERT INTO Sales VALUES(?, ?, ?, ?)";
		PreparedStatement ps3 = con.prepareStatement(sql3);
		ps3.setInt(1, productId);
		ps3.setInt(2, data.getAmount());
		ps3.setInt(3, data.getYear());
		ps3.setInt(4, data.getQuarter());
		ps3.executeUpdate();

		String sql4 = "INSERT INTO Nutrition VALUES(?, ?, ?)";
		PreparedStatement ps4 = con.prepareStatement(sql4);
		ps4.setInt(1, productId);
		ps4.setString(2, "나트륨");
		ps4.setInt(3, data.getNatrium());
		ps4.executeUpdate();

		PreparedStatement ps5 = con.prepareStatement(sql4);
		ps4.setInt(1, productId);
		ps4.setString(2, "탄수화물");
		ps4.setInt(3, data.getCarbohydrate());
		ps5.executeUpdate();

		PreparedStatement ps6 = con.prepareStatement(sql4);
		ps4.setInt(1, productId);
		ps4.setString(2, "당류");
		ps4.setInt(3, data.getSugars());
		ps6.executeUpdate();

		PreparedStatement ps7 = con.prepareStatement(sql4);
		ps4.setInt(1, productId);
		ps4.setString(2, "지방");
		ps4.setInt(3, data.getFat());
		ps7.executeUpdate();

		PreparedStatement ps8 = con.prepareStatement(sql4);
		ps4.setInt(1, productId);
		ps4.setString(2, "트랜스지방");
		ps4.setInt(3, data.getTransfat());
		ps8.executeUpdate();

		PreparedStatement ps9 = con.prepareStatement(sql4);
		ps4.setInt(1, productId);
		ps4.setString(2, "포화지방");
		ps4.setInt(3, data.getSaturatedFat());
		ps9.executeUpdate();

		PreparedStatement ps10 = con.prepareStatement(sql4);
		ps4.setInt(1, productId);
		ps4.setString(2, "콜레스테롤");
		ps4.setInt(3, data.getCholesterol());
		ps10.executeUpdate();

		PreparedStatement ps11 = con.prepareStatement(sql4);
		ps4.setInt(1, productId);
		ps4.setString(2, "단백질");
		ps4.setInt(3, data.getProtein());
		ps11.executeUpdate();
		
		

	}

	public void deleteData(int id) throws SQLException, ClassNotFoundException {

	}

	public void updateData(int id) throws SQLException, ClassNotFoundException {

	}

}
