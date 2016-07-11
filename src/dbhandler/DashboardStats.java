package dbhandler;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class DashboardStats extends DbUtil {
	Statement stmn = null;
	public DashboardStats() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public double GetTotalSales() throws SQLException{
		String query = "SELECT SUM(order_total) as 'TOTAL_SALES' from orders";
		double total = 0 ;
		try {
		
		stmn = conn.createStatement();
		stmn.executeQuery(query);
		results = stmn.getResultSet();
		while(results.next()){
			total = Double.parseDouble(results.getString("TOTAL_SALES"));
		}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			results.close();
			stmn.close();
		}
		return total;
	}
	
	public HashMap<String, Object> dateAndTotal() throws SQLException{
		HashMap<String,Object> map = new HashMap<>();
		double dayTotal = 0;
		Date date = new Date(0);
		String query = "SELECT COUNT(order_id) as 'ORDERS' , order_date from orders GROUP by order_date";
		try{
			stmn = conn.createStatement();
			stmn.executeQuery(query);
			results = stmn.getResultSet();
			while(results.next()){
			dayTotal = results.getInt("ORDERS");
			date = results.getDate("order_date");
			date.toString();
			/*DateFormat df = new SimpleDateFormat("YYYY/MM/DD");
			String stringDate = df.format(date);*/
			map.put("Date", date.toString());
			map.put("Total", dayTotal);
			}
			
		}finally{
			results.close();
			stmn.close();
			}
		
		
		return map;
		
		
	}
	public ArrayList<java.util.Date> getDates() throws SQLException{

		ArrayList<java.util.Date> dateList = new ArrayList<>();
		
		
		String query = "SELECT COUNT(order_id) as 'ORDERS' , order_date from orders GROUP by order_date";
		try{
			stmn = conn.createStatement();
			stmn.executeQuery(query);
			results = stmn.getResultSet();
			while(results.next()){
			Date date = results.getDate("order_date");
			java.util.Date date2 = new Date(date.getTime());
			dateList.add(date2);
			}
			
		}finally{
			results.close();
			stmn.close();
			}
		
		
		return dateList;
				
	}
	
	public ArrayList<Double> getTotals() throws SQLException{

		ArrayList<Double> totalList = new ArrayList<>();
		
		String query = "SELECT SUM(order_total) as 'ORDERS' , order_date from orders GROUP by order_date";
		double total = 0;
		try{
			stmn = conn.createStatement();
			stmn.executeQuery(query);
			results = stmn.getResultSet();
			while(results.next()){
			total = results.getDouble("ORDERS");
				totalList.add(total);
			}
			
		}finally{
			results.close();
			stmn.close();
			}
		
		
		return totalList;
				
	}
	
	public int getOrderTotal() throws SQLException{
		int orderTotal = 0;
		String query = "SELECT COUNT(order_id) as 'ORDERS' from orders";
		try{
			stmn = conn.createStatement();
			stmn.executeQuery(query);
			results = stmn.getResultSet();
			while(results.next()){
			orderTotal = results.getInt("ORDERS");
			}
		}finally{
			results.close();
			stmn.close();
			}
		return orderTotal;
		
	}
	
	
	public int getTotalCustomers() throws SQLException{
		int customerTotal = 0;
		String query = "SELECT COUNT(customer_id) as 'CUSTOMERS' from customer";
		try{
			stmn = conn.createStatement();
			stmn.executeQuery(query);
			results = stmn.getResultSet();
			while(results.next()){
			customerTotal = results.getInt("CUSTOMERS");
			}
		}finally{
			results.close();
			stmn.close();
			
			
		}
		return customerTotal;
		
	}
	
	
	public int getTotalSubscriptions() throws SQLException{
		int subscriptionTotal = 0;
		String query = "SELECT COUNT(id) 'TOTAL_SUBSCRIPTIONS' from subscriptions";
		try{
			stmn = conn.createStatement();
			stmn.executeQuery(query);
			results = stmn.getResultSet();
			while(results.next()){
			subscriptionTotal = results.getInt("TOTAL_SUBSCRIPTIONS");
			}
		}finally{
			results.close();
			stmn.close();
			
			
		}
		return subscriptionTotal;
		
	}
	
	
	public int getTotalInactive() throws SQLException{
		int inactiveTotal = 0;
		String query = "SELECT COUNT(id) as 'TOTAL_SUBSCRIPTIONS' from inactivesubscriptions";
		try{
			stmn = conn.createStatement();
			stmn.executeQuery(query);
			results = stmn.getResultSet();
			while(results.next()){
			inactiveTotal = results.getInt("TOTAL_SUBSCRIPTIONS");
			}
		}finally{
			results.close();
			stmn.close();
			
			
		}
		return inactiveTotal;
		
	}
	
	
	public HashMap<String,Object> getDashboard() throws SQLException{
		HashMap<String, Object> map = null;
		 int numberOfCustomers;
		 int numberOfOrders;
		 double totalSales;
		 int numberOfActiveSubscriptions;
		 int numberOfInacciveSubscriptions;
		 ArrayList<Double> doubleList;
		 ArrayList<java.util.Date> dateList;
		
				numberOfCustomers = getTotalCustomers();
				numberOfOrders = getOrderTotal();
				totalSales = GetTotalSales();
				numberOfActiveSubscriptions = getTotalSubscriptions();
				numberOfInacciveSubscriptions = getTotalInactive();		
				dateList = getDates();
				doubleList= getTotals();
				System.out.println("data loaded");
				map = new HashMap<>();
				map.put("customers", numberOfCustomers);
				map.put("sales", totalSales);
				map.put("orders",numberOfOrders);
				map.put("active",numberOfActiveSubscriptions);
				map.put("inactive", numberOfInacciveSubscriptions);
				map.put("dates",dateList);
				map.put("totals", doubleList);
				
		
		
		return map;
			
		
			
		}
		
	}
	

