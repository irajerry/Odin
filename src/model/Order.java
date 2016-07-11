package model;

import java.sql.Date;

public class Order {
	
			
	private int orderId;
	private int customerID;
	private Date orderDate;
	private double total;
	private int orderItem;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomer(int customerID){
		this.customerID = customerID;
	}
	public void setCustomer(Customer customer) {
		this.customerID = customer.getCustomerID();
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getOrderItem() {
		return orderItem;
	}/*
	public void setOrderItem(ArrayList<Product> orderItem) {
		this.orderItem = orderItem;
	}
	*/
	public Order(Customer customer, Date orderDate, double total, int orderItem) {
		super();
		this.customerID = customer.getCustomerID();
		this.orderDate = orderDate;
		this.total = total;
		this.orderItem = orderItem;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerID=" + customerID + ", orderDate=" + orderDate + ", total="
				+ total + ", orderItem=" + orderItem + "]";
	}
	public void setOrderItem(int orderItem) {
		this.orderItem = orderItem;
	}
	
	
	
}
