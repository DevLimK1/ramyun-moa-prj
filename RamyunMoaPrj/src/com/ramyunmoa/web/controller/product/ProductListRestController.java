package com.ramyunmoa.web.controller.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ramyunmoa.web.service.ProdService;
import com.ramyunmoa.web.view.product.ProductView;

@WebServlet("/product/list-data")
public class ProductListRestController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		ProdService service = new ProdService();

		String mfr = "";
		int page = 1;
		String searchName = "";
		String cup = "";

		String mfr_ = req.getParameter("m");
		if (mfr_ != null && !mfr_.equals("") && !mfr_.equals("undefined")) {
			mfr = mfr_;
		}

		String page_ = req.getParameter("p");
		if (page_ != null && !page_.equals("") && !page_.equals("undefined")) {
			page = Integer.parseInt(page_);
		}

		String searchName_ = req.getParameter("s");
		if (searchName_ != null && !searchName_.equals("") && !searchName_.equals("undefined")) {
			searchName = searchName_;
		}

		String cup_ = req.getParameter("c");
		if (cup_ != null && !cup_.equals("") && !cup_.equals("undefined")) {
			cup = cup_;
		}

		List<ProductView> list = null;

		try {

			list = service.getProdList(mfr, searchName, cup, page);
			req.setAttribute("list", list);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String json = gson.toJson(list);
		resp.getWriter().write(json);

	}

}
