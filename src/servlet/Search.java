package servlet;

import java.io.IOException;
import java.util.List;

import javabean.Unit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");

		String doit = request.getParameter("do");
		if (doit != null && doit.equals("delete")) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				Dao dao = new Dao();
				dao.deleteUnitById(id);
			} catch (NumberFormatException nfe) {

			}
		}
		setListData(request);
		request.getRequestDispatcher("WEB-INF/jsp/search.jsp").forward(request, response);
	}

	private void setListData(HttpServletRequest request) {
		Dao dao = new Dao();
		String searchString = request.getParameter("searchString");
		List<Unit> unitList = dao.findAllUnits(searchString);
		request.setAttribute("unitList", unitList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setListData(request);
		request.getRequestDispatcher("WEB-INF/jsp/search.jsp").forward(request, response);
	}

}
