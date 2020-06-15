package com.ramyunmoa.web.controller.admin.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ramyunmoa.web.service.ProdService;
import com.ramyunmoa.web.view.product.AdminProdView;

@WebServlet("/admin/product/edit")
public class EditController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int mfrId = 0;
		String mfr = req.getParameter("mfr");
		switch (mfr) {
		case "농심":
			mfrId = 1;
			break;
		case "삼양":
			mfrId = 2;
			break;
		case "오뚜기":
			mfrId = 3;
			break;
		case "팔도":
			mfrId = 4;
			break;
		case "PB/GS25":
			mfrId = 5;
			break;
		case "PB/CU":
			mfrId = 6;
			break;
		case "PB/세븐일레븐":
			mfrId = 7;
			break;
		}

		String p = "";
		String p_ = req.getParameter("p");
		if (p_ != null && !p_.equals("")) {
			p = p_;
		}
		String s = "";
		String s_ = req.getParameter("s");
		if (s_ != null && !s_.equals("")) {
			s = s_;
		}

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int capacity = Integer.parseInt(req.getParameter("capacity"));
		int kcal = Integer.parseInt(req.getParameter("kcal"));
		int natrium = Integer.parseInt(req.getParameter("natrium"));
		int carbohydrate = Integer.parseInt(req.getParameter("carbohydrate"));
		int sugars = Integer.parseInt(req.getParameter("sugars"));
		int fat = Integer.parseInt(req.getParameter("fat"));
		int transfat = Integer.parseInt(req.getParameter("transfat"));
		int saturatedFat = Integer.parseInt(req.getParameter("saturatedFat"));
		int cholesterol = Integer.parseInt(req.getParameter("cholesterol"));
		int protein = Integer.parseInt(req.getParameter("protein"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		int year = Integer.parseInt(req.getParameter("year"));
		int quarter = Integer.parseInt(req.getParameter("quarter"));
		String img = req.getParameter("img");

		AdminProdView product = new AdminProdView(id, name, capacity, kcal, natrium, carbohydrate, sugars, fat,
				transfat, saturatedFat, cholesterol, protein, mfr, mfrId, amount, year, quarter, img);

		ProdService service = new ProdService();

		try {

			service.updateData1(product);
			service.updateData2(product);
			service.updateData3(product);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("update?m=" + mfr + "&p=" + p + "&s=" + s);

	}

}
