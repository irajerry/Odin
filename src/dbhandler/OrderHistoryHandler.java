package dbhandler;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.Subscription;

public class OrderHistoryHandler extends DbUtil{

	public OrderHistoryHandler() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	
	public void getOrderHistory(int userID){
			
		String query = "SELECT customer.customer_id, orders.order_id, orders.order_date,orders.order_total,"
				+ " orders.order_item_num FROM  "
				+ "customer, orders WHERE customer.customer_id = ?"
				+ "  AND customer.customer_id = orders.customer_id";
		try {
			this.ps = this.conn.prepareStatement(query);
			this.ps.setInt(1,userID);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Order getOrderById(int orderID){
		Order order = new Order();
		String query = "SELECT * FROM orders WHERE orders.order_id = ?";
		try {
			this.ps = this.conn.prepareStatement(query);
			this.ps.setInt(1,orderID);
			this.results = ps.executeQuery();
			
			if(this.results.next()){
				order.setOrderId(this.results.getInt("order_id"));
				order.setOrderDate(this.results.getDate("order_date"));
				order.setCustomer(this.results.getInt("customer_id"));
				order.setOrderItem(this.results.getInt("order_item_num"));
				order.setTotal(this.results.getDouble("order_total"));
				System.out.println(order.toString());
		} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	// Result Set query for orders
	
	public List<Order> getOrders(){
		List<Order> orders = new ArrayList<>();
		String query = "SELECT * from ORDERS";
		
		try {
			this.ps = conn.prepareStatement(query);
			this.results = ps.executeQuery();
			
			while(this.results.next()){
				Order order = new Order();
				order.setOrderId(this.results.getInt("order_id"));
				order.setOrderDate(this.results.getDate("order_date"));
				order.setCustomer(this.results.getInt("customer_id"));
				order.setOrderItem(this.results.getInt("order_item_num"));
				order.setTotal(this.results.getDouble("order_total"));
				System.out.println(order.toString());
				orders.add(order);
			}}catch (SQLException e){
				e.printStackTrace();
			}finally{
			
		}
		return orders;
		
	
	}
	
	public List<Order> getOrdersResults(){
		List<Order> orders = new ArrayList<>();
		
		try {
			
			while(this.results.next()){
				Order order = new Order();
				order.setOrderId(this.results.getInt("order_id"));
				order.setOrderDate(this.results.getDate("order_date"));
				order.setCustomer(this.results.getInt("customer_id"));
				order.setOrderItem(this.results.getInt("order_item_num"));
				order.setTotal(this.results.getDouble("order_total"));
				System.out.println(order.toString());
				orders.add(order);
			}}catch (SQLException e){
				e.printStackTrace();
			}finally{
			
		}
		return orders;
		
	
	}
	
	
	// Make a query for deleting subscriptions 
	public void deleteSub(int id){
		
		
		String query = "DELETE FROM `subscriptions` WHERE ?";
		
		try {
			this.ps = this.conn.prepareStatement(query);
			this.ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	// Make query for viewing subscriptions
	
	public void getSubs (int id){
		
		String query = "SELECT * FROM `subscriptions` WHERE  customer_ID = ?";
				
				try{
	
					this.ps = this.conn.prepareStatement(query);
					this.ps.setInt(1, id);
					this.results = ps.executeQuery();
				}catch(SQLException e){
					e.getStackTrace();
					}
}
	
	public List<Subscription> subs(){
		List<Subscription> subcriptions = new ArrayList<>();
		try {
			while(this.results.next()){
					Subscription sub = new Subscription();
					sub.setCustomerid(this.results.getInt("customer_id"));
					sub.setOrderid(this.results.getInt("order_num"));
					sub.setStartDate(this.results.getDate("start_date"));
					sub.setExpireDate(this.results.getDate("end_date"));
					sub.setItemNumber(this.results.getInt("item_number"));
					sub.setId(this.results.getInt("id"));
					subcriptions.add(sub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subcriptions;
	
	}
	
public void getInactiveSubs (int id){
		
		String query = "SELECT * FROM `inactivesubscriptions` WHERE  customer_ID = ?";
				
				try{
	
					this.ps = this.conn.prepareStatement(query);
					this.ps.setInt(1, id);
					this.results = ps.executeQuery();
				}catch(SQLException e){
					e.getStackTrace();
					}
}
	
	public List<Subscription> inactiveSubs(){
		List<Subscription> subcriptions = new ArrayList<>();
		try {
			while(this.results.next()){
					Subscription sub = new Subscription();
					sub.setCustomerid(this.results.getInt("customer_id"));
					sub.setOrderid(this.results.getInt("order_num"));
					sub.setStartDate(this.results.getDate("start_date"));
					sub.setExpireDate(this.results.getDate("end_date"));
					sub.setItemNumber(this.results.getInt("item_number"));
					sub.setId(this.results.getInt("id"));
					subcriptions.add(sub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subcriptions;
	
	}
	
	public ArrayList<Order> orders() throws SQLException{
		ArrayList<Order> orderList = new ArrayList<>();
		String query ="SELECT * FROM ORDERS";
		try{
			this.ps = conn.prepareStatement(query);
			this.results = ps.executeQuery();
			
			while(results.next()){
				Order order = new Order();
				order.setCustomer(results.getInt("customer_id"));
				order.setOrderId(results.getInt("order_id"));
				order.setOrderDate(results.getDate("order_date"));
				order.setTotal(results.getDouble("order_total"));
				order.setOrderItem(results.getInt("order_item_num"));
				orderList.add(order);
			}
			
		}finally{
			results.close();
			ps.close();
			conn.close();
		}
		
		return orderList;
		
		
		
	}
	
	/*public Order order(){
		Order order = new Order();
		
		try {
			
			if(this.results.next()){
				order.setOrderId(this.results.getInt("order_id"));
				order.setOrderDate(this.results.getDate("order_date"));
				order.setCustomer(this.results.getInt("customer_id"));
				order.setOrderItem(this.results.getInt("order_item_num"));
				order.setTotal(this.results.getDouble("order_total"));
				System.out.println(order.toString());
			}}catch (SQLException e){
				e.printStackTrace();
			}finally{
			
		}
		return order;
		
	
	}*/
	
	
}
