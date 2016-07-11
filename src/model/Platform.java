package model;

public enum Platform {
	WINDOWS("Windows"), MAC("Mac"), LINUX("Linux"), IPHONE("Iphone"), ANDROID("Android"), WINDOWSPHONE("Windows Phone");
	
	private String nameAsString;
	
	private Platform(String nameAsString){
		this.nameAsString=nameAsString;
	}
	
	public String toString(){
		return this.nameAsString;
	}


}
