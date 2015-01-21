package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.User;
import Services.UserServices;

public class Servlet_1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
//		String message = "Transmission de variables : OK !";
		UserServices uS = new UserServices();
		try {
//			String s = uS.checkUserPassword("bob", "bob").getLogin();
			User u = uS.checkUserPassword("bob", "bob");
			String s = u.getLogin();
			request.setAttribute("test", s );
			this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
