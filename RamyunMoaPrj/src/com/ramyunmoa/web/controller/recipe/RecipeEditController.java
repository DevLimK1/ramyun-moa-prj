package com.ramyunmoa.web.controller.recipe;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.ramyunmoa.web.entity.recipe.Recipe;
import com.ramyunmoa.web.service.RecipeService;
import com.ramyunmoa.web.view.recipe.RecipeDetailView;
import com.ramyunmoa.web.view.review.MfcProductView;

@WebServlet("/recipe/edit")
public class RecipeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.사용자입력
		int id = Integer.parseInt(request.getParameter("id"));

		// 2.데이터베이스에서 쿼리
		RecipeService service = new RecipeService();
		RecipeDetailView rdv = null;
		List<MfcProductView> mpv = new ArrayList<MfcProductView>();
		List<Recipe> list = new ArrayList();
		/* List<Grade> grade = new ArrayList<Grade>(); */
		try {
			rdv = service.getRecipeDetailView(id);
			mpv=service.getMfcProductViewList();
			/* grade = service.getGrade(); */
//			list = service.getReviewList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(rdv.getStarGrade());

		// 3.View에게 전달
		request.setAttribute("r", rdv);
		request.setAttribute("mpv", mpv);
		/* request.setAttribute("grade", grade); */
//		request.setAttribute("list", list);

//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/edit.jsp");
//		dispatcher.forward(request, response);
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("board.recipe.edit", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String mfcProduct = request.getParameter("mfc-product");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		/* int gradeId=Integer.parseInt(request.getParameter("grade")); */
		int mvpId=0; 
		
		Recipe recipe=new Recipe();
		
		

		RecipeService service = new RecipeService();
		try {
			mvpId=service.getMfcProductViewId(mfcProduct); //상품 아이디 가지고오기
			
			recipe.setId(id);
			recipe.setTitle(title);
			recipe.setContent(content);
			/* review.setGradeId(gradeId); */
			recipe.setProductId(mvpId);
			
			service.updateRecipe(recipe);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("detail?id=" + id);

	}

}
