package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ProductServices;

@WebServlet(name = "ProductDelete", urlPatterns = { "/ProductDelete" })
public class ProductDelete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		Get the checkboxes which were checked. 
		String tab[] = request.getParameterValues("option");
		int lists[] = new int[tab.length];

//		Parse them into int to delete them
		for (int i = 0; i < tab.length; i++) {
			lists[i] = (Integer.parseInt(tab[i]));
		}
//		Call the Product Service to delete a group of product
		ProductServices pS = new ProductServices();
		pS.DeleteProducts(lists);
		
//		Redirect to the Product Management Servlet
			response.sendRedirect("/Comparator/ProductManagement");

	}
}
