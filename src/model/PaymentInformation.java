package model;

public class PaymentInformation {
	private String firstname;
	private String lastname;
	private String billingAddress;
	private String creditCardNumber;
	private String expDateMM;
	private String expDateYY;
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
	
	public PaymentInformation(){
		
		
	}
	
	public PaymentInformation(String firstname, String lastname, String billingAddress, 
			String creditCardNumber, String expMM, String expYY){
		this.firstname = firstname;
		this.lastname=lastname;
		this.billingAddress = billingAddress;
		this.creditCardNumber = creditCardNumber;
		this.expDateMM = expMM;
		this.expDateYY= expYY;
}
	public String toString(){
		return "firstname: "+ firstname + " lastname: " + lastname + " \n billingAddress: " 
	+ billingAddress + " \n creditcardnumber: " +creditCardNumber + " exp date : "+ expDateMM + ", "+ expDateYY ;
		
	}
}
