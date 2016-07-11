package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhandler.GetCustomers;
import model.Customer;

/**
 * Servlet implementation class CustomerReports
 */
@WebServlet("/CustomerReports")
public class CustomerReports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReports() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		GetCustomers gc = null;
		switch(action.toUpperCase()){
		
		case "ID" : 
			try {
				int custID  = Integer.parseInt(request.getParameter("customer_id"));
				gc = new GetCustomers();
				Customer customer =  gc.getCustomer(custID);
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("/customer-report.jsp").forward(request, response);
			} catch (SQLException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
			
		case "ALL":
				try{
					gc = new GetCustomers();
					ArrayList<Customer> customers = gc.getCustomers();
					request.setAttribute("customers", customers);
					request.getRequestDispatcher("/customer-results.jsp").forward(request,response);
				} catch (SQLException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
				}
				
			break;
			
		case "":	
			try{
				gc = new GetCustomers();
				ArrayList<Customer> customers = gc.getCustomers();
				request.setAttribute("customers", customers);
				request.getRequestDispatcher("/customer-results.jsp").forward(request,response);
			} catch (SQLException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
		
			
			break;
			
		
		
		
		
		
		
		}
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
