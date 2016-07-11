package model;

public enum PaymentMethod {

	BANKACCOUNT("Bank Account"), CREDITCARD("Credit Card"), BITCOIN("Bitcoin"), PAYPAL("Paypal");
	
	private String nameAsString;
	
	private PaymentMethod(String nameAsString){
		this.nameAsString=nameAsString;
	}
	
	public String toString(){
		return this.nameAsString;
	}
}

