package dbhandler;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class GetCustomers extends DbUtil{
	
	public GetCustomers() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Customer> getCustomers() throws SQLException{
		ArrayList<Customer> customers = new ArrayList<>();
		String query = "SELECT * FROM customer";
		
		try{
			ps = this.conn.prepareStatement(query);
			this.results = ps.executeQuery();
			
			while(results.next()){
				Customer customer = new Customer();
				customer.setCustomerID(results.getInt("customer_id"));
				customer.setFirstname(results.getString("firstName"));
				customer.setLastname(results.getString("lastName"));
				customer.setAddress(results.getString("address"));
				customer.setEmailAddress(results.getString("email"));
				customer.setPassword(results.getString("phoneNumber"));
				customer.setCompany(results.getString("customer_company"));
				customers.add(customer);
			
			}
		
			
		}finally{
			results.close();
			ps.close();
			conn.close();
			
		}
		
		
		
		
		
		return customers;
	}
	
	public Customer getCustomer(int id) throws SQLException{
		
		String query = "SELECT * FROM customer where customer_id = ?";
		Customer customer = new Customer();
		try{
			ps = this.conn.prepareStatement(query);
			ps.setInt(1,id);
			this.results = ps.executeQuery();
			
			if(results.next()){
				
				customer.setCustomerID(results.getInt("customer_id"));
				customer.setFirstname(results.getString("firstName"));
				customer.setLastname(results.getString("lastName"));
				customer.setAddress(results.getString("address"));
				customer.setEmailAddress(results.getString("email"));
				customer.setPassword(results.getString("phoneNumber"));
				customer.setCompany(results.getString("customer_company"));
			}
		
			
		}finally{
			results.close();
			ps.close();
			conn.close();
			
		}
		
		
		
		
		
		return customer;
	}
	
}
