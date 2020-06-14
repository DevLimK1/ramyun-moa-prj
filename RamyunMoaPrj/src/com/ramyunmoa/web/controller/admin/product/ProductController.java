package com.ramyunmoa.web.controller.admin.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.service.ProdService;
import com.ramyunmoa.web.view.product.AdminProdView;

@WebServlet("/admin/product/main")
public class ProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProdService service = new ProdService();

		try {

			int count1 = service.getListCount("농심", "", "");
			req.setAttribute("count1", count1);
			int count2 = service.getListCount("삼양", "", "");
			req.setAttribute("count2", count2);
			int count3 = service.getListCount("오뚜기", "", "");
			req.setAttribute("count3", count3);
			int count4 = service.getListCount("팔도", "", "");
			req.setAttribute("count4", count4);
			int count5 = service.getListCount("GS25", "", "");
			req.setAttribute("count5", count5);
			int count6 = service.getListCount("CU", "", "");
			req.setAttribute("count6", count6);
			int count7 = service.getListCount("세븐일레븐", "", "");
			req.setAttribute("count7", count7);
			int count8 = service.getListCount("", "", "");
			req.setAttribute("count8", count8);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TilesContainer container = TilesAccess.getContainer(req.getSession().getServletContext());
		container.render("admin.product.main", req, resp);

	}

}
