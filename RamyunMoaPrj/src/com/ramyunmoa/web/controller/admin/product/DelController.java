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

@WebServlet("/admin/product/del")
public class DelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProdService service = new ProdService();

		String mfr = "";
		int page = 1;
		String searchName = "";
		String cup = "";

		String mfr_ = req.getParameter("m");
		if (mfr_ != null && !mfr_.equals("")) {
			mfr = mfr_;
		}

		String page_ = req.getParameter("p");
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		String searchName_ = req.getParameter("s");
		if (searchName_ != null && !searchName_.equals("")) {
			searchName = searchName_;
		}

		String cup_ = req.getParameter("c");
		if (cup_ != null && !cup_.equals("")) {
			cup = cup_;
		}

		List<AdminProdView> list = null;
		int count = 0;

		try {

			list = service.getAdminList(mfr, searchName, cup, page);
			req.setAttribute("list", list);
			count = service.getListCount(mfr, searchName, cup);
			req.setAttribute("count", count);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TilesContainer container = TilesAccess.getContainer(req.getSession().getServletContext());
		container.render("admin.product.del", req, resp);

	}

}
