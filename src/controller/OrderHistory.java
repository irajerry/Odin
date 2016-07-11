package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhandler.OrderHistoryHandler;
import model.Customer;
import model.Order;

/**
 * Servlet implementation class OrderHistory
 */
@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {

       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch(action.toUpperCase()){
		case "ALL":
			OrderHistoryHandler orderHistoryAdmin =null;
			
			try{
				orderHistoryAdmin = new OrderHistoryHandler();
				List<Order> oh = orderHistoryAdmin.getOrders();
				request.setAttribute("order", oh);
				request.getRequestDispatcher("/orderHistory2.jsp").forward(request, response);				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
			break;
		case "ID":
			OrderHistoryHandler orderHistoryAdmin2 = null;
			int orderID = Integer.parseInt(request.getParameter("order_number"));
			try{
				orderHistoryAdmin2 = new OrderHistoryHandler();
				Order oh = orderHistoryAdmin2.getOrderById(orderID);
				request.setAttribute("order", oh);
				request.getRequestDispatcher("/orderHistory3.jsp").forward(request, response);				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
			break;
		case "CUSTOMER":
			int userId = Integer.parseInt( request.getParameter("userID"));
			OrderHistoryHandler orderHistory;
		try {
			
			orderHistory = new OrderHistoryHandler();
			orderHistory.getOrderHistory(userId);
			List<Order> orders = orderHistory.getOrdersResults();
			Customer user = (Customer) request.getAttribute("user");
			request.setAttribute("user", user);
			request.setAttribute("order", orders);
			request.getRequestDispatcher("/orderHistory.jsp").forward(request,response);
			
		} catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
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
