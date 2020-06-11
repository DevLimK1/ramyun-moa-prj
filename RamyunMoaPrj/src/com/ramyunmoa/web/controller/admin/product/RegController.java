package com.ramyunmoa.web.controller.admin.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.service.ProductService;
import com.ramyunmoa.web.view.product.AdminProdView;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 100 * 1024 * 1024, maxRequestSize = 300 * 1024 * 1024)
@WebServlet("/admin/product/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TilesContainer container = TilesAccess.getContainer(req.getSession().getServletContext());
		container.render("admin.product.reg", req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mfr = req.getParameter("mfr");

		Part filePart = req.getPart("img");
		String fileName = filePart.getSubmittedFileName();
		InputStream fis = filePart.getInputStream();

		String realPath = null;
		String img = null;
		int mfrId = 0;

		switch (mfr) {
		case "농심":
			mfrId = 1;
			img = "images/prod-img/item-list/nongsim/" + fileName;
			realPath = req.getServletContext().getRealPath("/prod-img/item-list/nongsim");
			break;
		case "삼양":
			mfrId = 2;
			img = "images/prod-img/item-list/samyang/" + fileName;
			realPath = req.getServletContext().getRealPath("/prod-img/item-list/samyang");
			break;
		case "오뚜기":
			mfrId = 3;
			img = "images/prod-img/item-list/odduki/" + fileName;
			realPath = req.getServletContext().getRealPath("/prod-img/item-list/odduki");
			break;
		case "팔도":
			mfrId = 4;
			img = "images/prod-img/item-list/paldo/" + fileName;
			realPath = req.getServletContext().getRealPath("/prod-img/item-list/paldo");
			break;
		case "cu":
			mfrId = 5;
			img = "images/prod-img/item-list/pb/cu/" + fileName;
			realPath = req.getServletContext().getRealPath("/prod-img/item-list/pb/cu");
			break;
		case "gs25":
			mfrId = 6;
			img = "images/prod-img/item-list/pb/gs25/" + fileName;
			realPath = req.getServletContext().getRealPath("/prod-img/item-list/pb/gs25");
			break;
		case "세븐일레븐":
			mfrId = 7;
			img = "images/prod-img/item-list/pb/seveneleven/" + fileName;
			realPath = req.getServletContext().getRealPath("/prod-img/item-list/pb/seveneleven");
			break;
		}

		String filepath = realPath + File.separator + fileName;
		FileOutputStream fos = new FileOutputStream(filepath);
		byte[] buf = new byte[1024];
		int size;
		while ((size = fis.read(buf)) != -1) {
			fos.write(buf, 0, size);
		}

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

		ProductService service = new ProductService();

		AdminProdView data = new AdminProdView(name, capacity, kcal, mfrId, img, amount, year, quarter, natrium,
				carbohydrate, sugars, fat, transfat, saturatedFat, cholesterol, protein);

		try {
			service.insertData(data);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("list");

	}

}
