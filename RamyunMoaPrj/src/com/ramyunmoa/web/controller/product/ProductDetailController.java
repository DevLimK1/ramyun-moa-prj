package com.ramyunmoa.web.controller.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ramyunmoa.web.service.ProdService;
import com.ramyunmoa.web.view.product.NutritionView;

@WebServlet("/product/detail")
public class ProductDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8"); 
		
		String id_ = req.getParameter("id");
		int id = 0;
		if (id_ != null && !id_.equals("")) {
			id = Integer.parseInt(id_);
		}
		
		ProdService service = new ProdService();
		NutritionView nutrition = null;
		NutritionView nutriStd = null;
		
		try {

			nutrition = service.getNutrition(id);
			nutriStd = service.getNutriStd();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Gson gson = new Gson();
		String json = gson.toJson(nutrition);
		
		resp.getWriter().write(json);
		
	}
}
