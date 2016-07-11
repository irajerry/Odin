package model;

public enum CustomerType {
 
	PERSONAL("Personal"),PROFESSIONAL("Professional"),ENTERPRISE("Enterprise");
	
	
	private String nameAsString;
	
	private CustomerType(String nameAsString){
		this.nameAsString=nameAsString;
	}
	
	public String toString(){
		return this.nameAsString;
	}
	
}
