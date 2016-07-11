package dbhandler;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import model.Order;
import model.Payment;

public class PaymentProcessor extends DbUtil {

	public PaymentProcessor() throws IllegalAccessException, ClassNotFoundException, InstantiationException, SQLException {
		super();
		System.out.println("Connection Opened , Auto Commited false");
	}
		
	
		public void executeQueries(Order order, Payment payment) {
			try {
				this.conn.setAutoCommit(false);
				String orderQuery = "INSERT INTO `cis5800project`.`orders`( `customer_id`, `order_date`, `order_total`,`order_item_num`) VALUES (?,?,?,?)";
								
						this.ps = this.conn.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);
						this.ps.setInt(1, order.getCustomerID());
						this.ps.setDate(2, order.getOrderDate());
						this.ps.setDouble(3, order.getTotal());
						this.ps.setInt(4,order.getOrderItem());
						System.out.println(order.toString());
						System.out.println(orderQuery);
						System.out.println("Generated Key" + ps.getGeneratedKeys());
							this.ps.executeUpdate();
							this.results = ps.getGeneratedKeys();
					int orderId = -1;
				String paymentQuery = "INSERT INTO `payment`(`firstname`, `lastname`, `billingAddress`, `creditCardNumber`, `expMM`, `expYY`,`payment_date`, `payment_method`,`payment_amount`, `order_id`) VALUES (?,?,?,?,?,?,?,?,?,?)";
								if(results.next()){
									orderId =  results.getInt(1);
								}
								System.out.println(orderId + " this is the orderId");
						this.ps = this.conn.prepareStatement(paymentQuery);
						this.ps.setString(1, payment.getFirstname());
						this.ps.setString(2,payment.getLastname());
						this.ps.setString(3,payment.getBillingAddress());
						this.ps.setString(4,payment.getCreditCardNumber());
						this.ps.setString(5,payment.getExpDateMM());
						this.ps.setString(6,payment.getExpDateYY());
						this.ps.setDate(7, payment.getPaymentDate());
						this.ps.setString(8,"Credit Card");
						this.ps.setDouble(9, payment.getPaymentAmmount());
						this.ps.setInt(10,orderId);
						
						System.out.println(payment.toString());
						System.out.println(paymentQuery);
				
						this.ps.executeUpdate();

						this.conn.commit();			
						
					/*	
						String getSubscription = "SELECT * from orders, subscription where customer_id = ? and order_id = ? and `orders`.customer_id = `customer`.customer_id";
						
						try {
							this.ps = this.conn.prepareStatement(getSubscription);
							this.ps.setInt(order.getCustomerID(), 1);
							this.ps.setInt(orderId,2);
							
							this.results = ps.executeQuery();
							
							while(results.next()){
								
							Order order2 = new Order();
								order2.set
							}
							return order2;*/
						
				
				System.out.println("Commited");
			} catch (SQLException e) {
				e.printStackTrace();
				rollback();
			}finally{
			System.out.println("Batch Updated");
			super.closeConnection();
			}	
		}
		
		
	
	public void rollback(){
		try {
			this.conn.rollback();
			System.out.println("Connection Rolled Back");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
