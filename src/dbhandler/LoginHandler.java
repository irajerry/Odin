package dbhandler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import model.Customer;


public class LoginHandler extends DbUtil{
	
	
	public LoginHandler() throws IllegalAccessException, ClassNotFoundException, InstantiationException, SQLException {
		super();		
		this.conn.setAutoCommit(false);
	}
	
	//String hash for password. 
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }		
	
    
    
	//query to log customer in. 
	public void customerLogin( String username, String password){
		String query = "SELECT * FROM customer WHERE username=? and password=?";
		try{
			ps = this.conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			this.results =  ps.executeQuery();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	//query to store user information into bean.

	public Customer getUserInfo(){
		Customer customer = new Customer();
		try{
			while(this.results.next()){
			System.out.println("Getting Results for customer #"  + results.getInt("customer_id"));
			customer.setCustomerID(this.results.getInt("customer_id"));
			customer.setUsername(this.results.getString("username"));
			customer.setAddress(this.results.getString("address"));
			customer.setFirstname(this.results.getString("firstName"));
			customer.setLastname(this.results.getString("lastName"));
			customer.setEmailAddress(this.results.getString("email"));
			customer.setCompany(this.results.getString("customer_company"));
			customer.setPhoneNumber(this.results.getString("phoneNumber"));
		
			// set other fields
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("Returning Results");
		return customer;
		}

		
	// new user creation function
		
	public void createUser(Customer customer) throws SQLException{
		//String query ="INSERT INTO customer(username, password,email) values ( ?,?,?)";
		
		String query  = "INSERT INTO `customer`(`username`, `password`, `email`,`lastName`,"
				+ " `firstName`, `address`, `phoneNumber`, `customer_company`) VALUES (?,?,?,?,?,?,?,?)";
		try{
			ps = this.conn.prepareStatement(query);
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getEmailAddress());
			ps.setString(4, customer.getLastname());
			ps.setString(5, customer.getFirstname());
			ps.setString(6, customer.getAddress());
			ps.setString(7, customer.getPhoneNumber());
			ps.setString(8, customer.getCompany());
			ps.executeUpdate();
			this.conn.commit();	
			System.out.println("user created");
		}catch (SQLException e){
			e.printStackTrace();
			this.conn.rollback();
		}finally{
			
			ps.close();
		}
	}
	
	public void updateCustomer(Customer customer) throws SQLException{
		//String query ="INSERT INTO customer(username, password,email) values ( ?,?,?)";
		
		String query  = "UPDATE `customer` SET`lastName`=?,`firstName`=?,`address`=?,`phoneNumber`=?,`email`=?,`customer_company`=? WHERE `customer_id` = ?;";
		try{
			ps = this.conn.prepareStatement(query);
			ps.setString(1, customer.getLastname());
			ps.setString(2, customer.getFirstname());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getPhoneNumber());
			ps.setString(5, customer.getEmailAddress());
			ps.setString(6, customer.getCompany());
			ps.setInt(7, customer.getCustomerID());
			ps.executeUpdate();
			this.conn.commit();	
			System.out.println("user updated : " + customer.toString());
		}catch (SQLException e){
			e.printStackTrace();
			this.conn.rollback();
		}finally{
			
			
			ps.close();
		}
	}
	
	
	public Customer editProfile(int userID){
		String query = "Select * from customer where customer_id = ?";
		Customer customer = new Customer();
		
		try {
			ps = this.conn.prepareStatement(query);
			ps.setInt(1, userID);
			this.results = ps.executeQuery();
			
			while(results.next()){
					customer.setUsername(results.getString("username"));
					customer.setFirstname(results.getString("firstName"));
					customer.setLastname(results.getString("lastName"));
					customer.setEmailAddress(results.getString("email"));
					customer.setAddress(results.getString("address"));
					customer.setPhoneNumber(results.getString("phoneNumber"));
					customer.setCompany(results.getString("customer_company"));
		
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
				
		return customer;
	}
	
	// Admin Login in information 
	
	
	public void adminLogin( String username, String password){
		String query = "SELECT * FROM admin WHERE userName=? and password=?";
		try{
			ps = this.conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			this.results =  ps.executeQuery();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public Admin getAdminInfo(){
		Admin admin = new Admin();
		try{
			while(this.results.next()){
			System.out.println("Getting Results");
			admin.setAdminId(this.results.getInt("admin_id"));
			admin.setUsername(this.results.getString("userName"));
			admin.setFirstName(this.results.getString("firstName"));
			admin.setLastName(this.results.getString("lastName"));
			admin.setEmailAddress(this.results.getString("emailAddress"));
			admin.setPosition(this.results.getString("admin_position"));
		
			// set other fields
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("Returning Results");
		return admin;
		}
	
	
	
	
	public void createAdmin(Admin admin) throws SQLException{
		//String query ="INSERT INTO customer(username, password,email) values ( ?,?,?)";
		
		String query  = "INSERT INTO `admin`( `userName`, `password`, `emailAddress`,`lastName`, `firstName`, `admin_position`, `role`) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try{
			ps = this.conn.prepareStatement(query);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getEmailAddress());
			ps.setString(4, admin.getLastName());
			ps.setString(5, admin.getFirstName());
			ps.setString(6, admin.getPosition());
			ps.setString(7, admin.getPosition());
			ps.setString(8, admin.getRole());
			ps.executeUpdate();
			this.conn.commit();	
			System.out.println("admin created");
		}catch (SQLException e){
			e.printStackTrace();
			this.conn.rollback();
		}finally{
			
			conn.close();
			ps.close();
		}
	}
	
//close function 
	public void closeConnection() {
		try {
			conn.close();
			ps.close();
			conn.close();
			results.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}