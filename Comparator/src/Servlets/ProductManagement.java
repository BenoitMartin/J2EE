package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ProductServices;

/**
 * Servlet implementation class ProductManagement
 */
@WebServlet("/ProductManagement")
public class ProductManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		If there is no variable session for admin, we create it and put it to false		
		if (request.getSession().getAttribute("admin") == null) {
			request.getSession().setAttribute("admin",false);
		}
		ProductServices pS = new ProductServices();
//		We send the list of products to the JSP page		
		request.setAttribute("listProduct", pS.getAllProduct());
//		We goes to the JSP page with the attributes 		
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/ProductList.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		If there is no variable session for admin, we create it and put it to false
		if (request.getSession().getAttribute("admin") == null) {
			request.getSession().setAttribute("admin",false);
		}
		
		ProductServices pS = new ProductServices();
//		We send the list of products to the JSP page
		request.setAttribute("listProduct", pS.getAllProduct());
//		We goes to the JSP page with the attributes
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/ProductList.jsp")
				.forward(request, response);
	}

}
