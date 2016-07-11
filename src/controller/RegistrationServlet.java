package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhandler.LoginHandler;
import model.Customer;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//new login handler
			LoginHandler login = new LoginHandler();
			// parameters to pass into the create user function.
			String username = request.getParameter("username");
			String password = LoginHandler.getMD5(request.getParameter("password"));
			String email = request.getParameter("email");
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			int zip = Integer.parseInt(request.getParameter("zip"));
			String phone = request.getParameter("phone");
			
			
			System.out.println(password);
			Customer customer = new Customer(lastName,firstName, address + ", "+ city +","+ state + " "+ zip ,
					username, email ,"",phone,password);	
			login.createUser(customer);
			request.setAttribute("message", "NEW USER CREATED");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		} catch (IllegalAccessException | ClassNotFoundException | InstantiationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
