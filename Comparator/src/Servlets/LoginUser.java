package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.User;
import Services.UserServices;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet(name = "LoginUser", urlPatterns = { "/LoginUser" })
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserServices uS = new UserServices();
		try {
//			Try to check user and password, if it match, we get the user back
			User u = uS.checkUserPassword(request.getParameter("username"),
					request.getParameter("password"));
//			After we've checked the user, we now check if he is an administrator
			boolean isAdmin = uS.isAdmin(u.getId());
//			We settup the session admin variable to the value of the past method.
			request.getSession().setAttribute("admin", isAdmin);
			request.getSession().removeAttribute("connect");
//			Redirect to the Servlet of the calling page		
			response.sendRedirect("/Comparator/"
					+ request.getParameterValues("action")[0]);

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			if there is a error, we put it in a session variable, to deal with it in the other page
			// Not instancied yet.
			request.getSession().removeAttribute("connect");
			request.getSession().setAttribute("connect", e.getMessage());
			
			
			
//			If there is a an error, the user will not be admin, so we put the session variable to false to be sure.
			request.getSession().setAttribute("admin", false);
//			Redirect to the Servlet of the calling page	
			response.sendRedirect("/Comparator/"
					+ request.getParameterValues("action")[0]);
		}

	}

}
