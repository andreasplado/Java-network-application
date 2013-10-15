package servlet;

import java.io.IOException;

import javabean.Unit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Unit unit = new Unit();
		unit.setName(request.getParameter("name"));
		unit.setCode(request.getParameter("code"));
		Dao dao = new Dao();
		dao.insertionOfUnit(unit);
		response.sendRedirect("Search");
	}

}
