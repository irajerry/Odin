package model;

import java.sql.Date;

public class Payment {
	public Payment(Date paymentDate, String pm, double paymentAmmount) {
		super();
		this.paymentDate = paymentDate;
		this.pm = pm;
		this.paymentAmmount = paymentAmmount;
	}
	public Payment(){
		
	}
	private int paymentID;
	private Date paymentDate;
	private Order order;
	private String pm;
	private double paymentAmmount;
	private String firstname;
	private String lastname;
	private String billingAddress;
	
	public Payment(Date paymentDate, String pm, double paymentAmmount, String firstname, String lastname,
			String billingAddress, String creditCardNumber, String expDateMM, String expDateYY) {
		super();
		this.paymentDate = paymentDate;
		this.pm = pm;
		this.paymentAmmount = paymentAmmount;
		this.firstname = firstname;
		this.lastname = lastname;
		this.billingAddress = billingAddress;
		this.creditCardNumber = creditCardNumber;
		this.expDateMM = expDateMM;
		this.expDateYY = expDateYY;
	}
	private String creditCardNumber;
	private String expDateMM;
	private String expDateYY;
	
	
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public double getPaymentAmmount() {
		return paymentAmmount;
	}
	public void setPaymentAmmount(double paymentAmmount) {
		this.paymentAmmount = paymentAmmount;
	}
	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", paymentDate=" + paymentDate + ", order=" + order + ", pm=" + pm
				+ ", paymentAmmount=" + paymentAmmount + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", billingAddress=" + billingAddress + ", creditCardNumber=" + creditCardNumber + ", expDateMM="
				+ expDateMM + ", expDateYY=" + expDateYY + "]";
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getExpDateMM() {
		return expDateMM;
	}
	public void setExpDateMM(String expDateMM) {
		this.expDateMM = expDateMM;
	}
	public String getExpDateYY() {
		return expDateYY;
	}
	public void setExpDateYY(String expDateYY) {
		this.expDateYY = expDateYY;
	}
	
	
	
	
}
