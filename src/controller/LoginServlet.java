package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.fmt.RequestEncodingTag;

import dbhandler.DashboardStats;
import dbhandler.LoginHandler;
import model.Admin;
import model.Customer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet  {
		private static final long serialVersionUID = 1L;
		
		
	public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
			int userID = Integer.parseInt(request.getParameter("userID"));
			
			try {
				LoginHandler editProfile = new LoginHandler();
				Customer customer = editProfile.editProfile(userID);
				
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("/editProfile.jsp").forward(request, response);
				
				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
			
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get parameters from request.
		String action = request.getParameter("action");
		
		/*String username = request.getParameter("username");
		String password = LoginHandler.getMD5(request.getParameter("password"))*/;
		LoginHandler login = null;
		
		switch(action.toUpperCase()){
		
		
		case "CUSTOMERLOGIN":
		//Login Handler
			System.out.println("inside of customer");
			
			
		try {
			// execute the query and pass in the two parameters
			login = new LoginHandler();	
			login.customerLogin(request.getParameter("username"),LoginHandler.getMD5(request.getParameter("password")));
			// new user bean set equal to the data pull from the query.
			Customer customer = login.getUserInfo();
			// create a session and pass the information into the session so it is available in the jsp 
			HttpSession session = request.getSession(true);
			session.setAttribute("user",customer); // available in jsp as $user
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response); //dispatch request to the dashboard.
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			login.closeConnection();
		}
		
		break;
		case "UPDATE":
			
		
				
				try {
					Customer cus = new Customer();
					cus.setAddress(request.getParameter("address"));
					cus.setCompany(request.getParameter("company"));
					cus.setEmailAddress(request.getParameter("myEmail"));
					cus.setLastname(request.getParameter("myLastName"));
					cus.setFirstname(request.getParameter("myFirstName"));
					cus.setPhoneNumber(request.getParameter("phone"));
					cus.setCustomerID(Integer.parseInt(request.getParameter("custID")));
					login = new LoginHandler();
					login.updateCustomer(cus);
					Customer newCustomer = login.editProfile(cus.getCustomerID());
					HttpSession session = request.getSession(true);
					session.setAttribute("user", newCustomer);
					request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
				} catch (SQLException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		
			break;
		
		case "ADMINLOGIN":
			System.out.println("inside of admin");
			
			try {
				// execute the query and pass in the two parameters
				login = new LoginHandler();	
				login.adminLogin(request.getParameter("username"),LoginHandler.getMD5(request.getParameter("password")));
				// new user bean set equal to the data pull from the query.
				Admin admin = login.getAdminInfo();
				
				// create a session and pass the information into the session so it is available in the jsp 
				HttpSession session = request.getSession(true);
				session.setAttribute("user",admin); // available in jsp as $user
				
				request.getRequestDispatcher("/admin.jsp").forward(request, response); //dispatch request to the dashboard.
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				login.closeConnection();
			}
			break;
		
		
	}
		
		
		
	}
	
	
	
	
	}

