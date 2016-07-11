package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Helpers.OdinHelpers;
import dbhandler.PaymentProcessor;
import dbhandler.ProductSearch;
import model.Customer;
import model.Order;
import model.Payment;
import model.Product;

/**
 * Servlet implementation class ProcessPayment
 */
@WebServlet("/ProcessPayment")
public class ProcessPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String billingStreet=request.getParameter("billingAddressStreet");
		String billingCity=request.getParameter("billingAddressCity");
		String billingZip=request.getParameter("billingZip");
		String creditCardNumber =request.getParameter("creditcardnum");
		String month =request.getParameter("expirationDate");
		String year = request.getParameter("expirationYear");
		int prodID = Integer.parseInt((String)request.getParameter("product"));
		
		ProductSearch prodSearch = null;
				try {
					prodSearch = new ProductSearch();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
		prodSearch.executeQuery(prodID);
		ArrayList<Product> pl = (ArrayList<Product>) prodSearch.getProductList();
		System.out.println(prodID + "added");
		HttpSession session = request.getSession();
		Customer customer = new Customer();
		customer = (Customer) session.getAttribute("user");
		Calendar calendar =  Calendar.getInstance();
		Date date = new Date(calendar.getTime().getTime());
		Order order = new Order(customer, date ,OdinHelpers.setTotal(pl),(int)session.getAttribute("item"));
		Payment payment = new Payment(date,"Credit Card",OdinHelpers.setTotal(pl),firstName,lastName,billingStreet + "\n" + billingCity+ ","
				+ " "+ billingZip, creditCardNumber, month, year);
		
		PaymentProcessor pp = null;
		try {			
			pp = new PaymentProcessor();
			pp.executeQueries(order,payment);
		} catch (Exception e){
			e.printStackTrace();
			
		}finally{
			pp.closeConnection();
			System.out.println("Connection Closed");
		}
		
		
	request.getRequestDispatcher("/orderHistory.jsp").forward(request,response);
	}
}
