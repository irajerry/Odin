package model;

import java.sql.Date;
import java.util.ArrayList;

public class Customer {
	private int customerID;
	private String lastname;
	private String firstname;
	private String address;
	private String customerType;
	private String username;
	private String emailAddress;
	private String company;
	private String phoneNumber;
	private String password;
	private final String role = "CUSTOMER";
	
	public Customer(){
		
	}
	public Customer(String username2, String password2, String email) {
		this.username=username2;
		this.password=password2;
		this.emailAddress=email;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public Customer(String lastname, String firstname, String address, String username,
			String emailAddress, String company, String phoneNumber, String password) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.customerType = "Personal";
		this.username = username;
		this.emailAddress = emailAddress;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	 class shoppingCart{
		private ArrayList<Product> items;
		private Date dateAdded;
	
		public ArrayList<Product> getItems() {
			return items;
		}
		public void setItems(Product product) {
			ArrayList<Product> items = new ArrayList<>();
			this.items = items	;
		}
		public Date getDateAdded() {
			return dateAdded;
		}
		public void setDateAdded(Date dateAdded) {
			this.dateAdded = dateAdded;
		}
		
		
		
	}


	public String getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", lastname=" + lastname + ", firstname=" + firstname
				+ ", address=" + address + ", customerType=" + customerType + ", username=" + username
				+ ", emailAddress=" + emailAddress + ", company=" + company + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", role=" + role + "]";
	}

}
