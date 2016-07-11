package Helpers;

import java.util.ArrayList;

import model.Product;

public class OdinHelpers {

	public OdinHelpers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public  static double setTotal(ArrayList<Product> orderItem){
		double sum = 0;
		for(Product prod : orderItem){
				sum = sum + prod.getPrice() ;
			}
		
		return sum;
	}
	
	public static int getOrderItem(ArrayList<Product> orderItem){
		int prodID = 0;
		for(Product prod : orderItem){
			prodID = prod.getProductID();		
		}
		
		return prodID;
	}
	
}
