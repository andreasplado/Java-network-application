package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.SetupDao;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SetupDao setupDao = new SetupDao();
		String doit = request.getParameter("do");
		if (doit != null) {
			if (doit.equals("insert_data")) {
				setupDao.insertDefaultData();
			} else if (doit.equals("clear_data")) {
				new Dao().deleteAllUnits();
			}
		}
		response.sendRedirect("Search");
	}

}
