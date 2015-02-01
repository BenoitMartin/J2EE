package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.RetailerServices;

/**
 * Servlet implementation class RetailerDelete
 */
@WebServlet("/RetailerDelete")
public class RetailerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetailerDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		Get the checkboxes which were checked. 
		String tab[] = request.getParameterValues("option");
		int lists[] = new int[tab.length];

//		Parse them into int to delete them
		for (int i = 0; i < tab.length; i++) {
			lists[i] = (Integer.parseInt(tab[i]));
		}
//		Call the Retailer Service to delete a group of product
		RetailerServices rS = new RetailerServices();
		rS.DeleteRetailer(lists);

//		Redirect to the Retailer Management Servlet
		response.sendRedirect("/Comparator/RetailerManagement");

	}

}
