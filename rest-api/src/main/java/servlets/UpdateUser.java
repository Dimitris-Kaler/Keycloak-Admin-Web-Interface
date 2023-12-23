package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Users;
import requests.KeycloakRequests;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/updateUser/*")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getPathInfo().substring(1);
		System.out.println("The id is: "+id);
		Users user=KeycloakRequests.getUser(id);
		System.out.println("the User is "+user.toString());
		HttpSession session=request.getSession();
		
		session.setAttribute("user",user);
		
		response.sendRedirect("/rest-api/userInformation.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello From Post of update");
		String id=request.getParameter("id");
		String username=request.getParameter("Username");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		Users user=new Users(id,username,firstName,lastName,email);
		int responseCode=KeycloakRequests.updateUser(user);
		
		response.sendRedirect("/rest-api/userRepository");
	
		

	}

}
