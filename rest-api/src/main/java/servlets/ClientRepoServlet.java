package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Client;
import Models.Users;
import requests.KeycloakRequests;

/**
 * Servlet implementation class ClientRepoServlet
 */
@WebServlet("/clientRepository")
public class ClientRepoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientRepoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client>list=KeycloakRequests.getClients();
		System.out.println("LIST: "+list);
    	HttpSession session=request.getSession();
    	session.setAttribute("clientList",list);
    	session.setAttribute("clientBtn",true);
    	
    	response.sendRedirect("main.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client>list=KeycloakRequests.getClients();
		System.out.println("LIST: "+list);
    	HttpSession session=request.getSession();
    	session.setAttribute("clientList",list);
    	session.setAttribute("clientBtn",true);
    	
    	response.sendRedirect("main.jsp");
	}

}
