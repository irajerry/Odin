package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhandler.OrderHistoryHandler;
import model.Subscription;

/**
 * Servlet implementation class SubcriptionsServlet
 */
@WebServlet("/ViewSubcriptions")
public class ViewSubscriptions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSubscriptions() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderHistoryHandler oh;
		String action = request.getParameter("action");
		
		switch (action.toUpperCase()){
			
		
		
		case "ACTIVE":
		try {
			oh = new OrderHistoryHandler();
			oh.getSubs(Integer.parseInt(request.getParameter("customer_id")));
			List<Subscription> subs = oh.subs();
			request.setAttribute("subs", subs);
			request.getRequestDispatcher("/subscriptions.jsp").forward(request, response);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		break;
		
		
		case "INACTIVE":
			try {
				oh = new OrderHistoryHandler();
				oh.getInactiveSubs(Integer.parseInt(request.getParameter("customer_id")));
				List<Subscription> subs = oh.inactiveSubs();
				request.setAttribute("subs", subs);
				request.getRequestDispatcher("/in-subscriptions.jsp").forward(request, response);
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
