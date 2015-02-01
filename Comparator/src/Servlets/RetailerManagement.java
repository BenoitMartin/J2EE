package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.RetailerServices;

@WebServlet(name = "RetailerManagement", urlPatterns = { "/RetailerManagement" })
public class RetailerManagement extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		If there is no variable session for admin, we create it and put it to false
		if (request.getSession().getAttribute("admin") == null) {
			request.getSession().setAttribute("admin", false);
		}

		RetailerServices rS = new RetailerServices();

		try {

			request.setAttribute("listRetailer", rS.getAllRetailer());
			this.getServletContext()
					.getRequestDispatcher("/WEB-INF/RetailerList.jsp")
					.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		If there is no variable session for admin, we create it and put it to false
		if (request.getSession().getAttribute("admin") == null) {
			request.getSession().setAttribute("admin", false);
		}

		RetailerServices rS = new RetailerServices();

		try {

			request.setAttribute("listRetailer", rS.getAllRetailer());
			// request.setAttribute("admin", isAdmin);
			this.getServletContext()
					.getRequestDispatcher("/WEB-INF/RetailerList.jsp")
					.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
