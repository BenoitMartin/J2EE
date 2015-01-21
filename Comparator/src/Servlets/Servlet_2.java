package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ProductServices;

public class Servlet_2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8762411686154369680L;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

		try {
			ProductServices p = new ProductServices();
			 String parametre = request.getParameter( "test" );
			String s = p.getProductbyID(Integer.parseInt(parametre)).getName();
			
			request.setAttribute("test", s );
			this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
