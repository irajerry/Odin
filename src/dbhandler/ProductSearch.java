package dbhandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductSearch extends DbUtil {

	public ProductSearch() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
		super();
		
	}
	
	//query to return all products
	public void executeQuery(String type){
		//Return All Products
		String query ="Select * from product where product_type = ?";
		try{
			ps = this.conn.prepareStatement(query);
			ps.setString(1,type.toUpperCase());
			this.results = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void executeQueryToEdit(){
		//Return All Products
		String query ="Select * from product";
		try{
			ps = this.conn.prepareStatement(query);
			this.results = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateProduct(Product product){
		String query = "UPDATE `product` SET `product_name`= ? ,`product_price`=?,`product_type`=?"
				+ ",`product_platform`=?,`product_coverage`=?,`product_description`=? WHERE `product_id` = ?";
		try {
			this.ps = conn.prepareStatement(query);
			ps.setString(1,product.getProductName());
			ps.setDouble(2,product.getPrice());
			ps.setString(3,product.getType());
			ps.setString(4,product.getPlatform());
			ps.setString(5,product.getCoverage());
			ps.setString(6, product.getProductDesc());
			ps.setInt(7,product.getProductID());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
		}
		
	}
	//returns all of the products result set.
	public List<Product> returnAllProducts(){
		List<Product> products = new ArrayList<>();
		try {
			while(this.results.next()){
				Product product = new Product();
				product.setProductName(this.results.getString("product_name"));
				product.setPrice(this.results.getDouble("product_price"));
				product.setProductID(this.results.getInt("product_id"));
				product.setType(this.results.getString("product_type"));
				product.setPlatform(this.results.getString("product_platform"));
				product.setCoverage(this.results.getString("product_coverage"));
				product.setProductDesc(this.results.getString("product_description"));
				products.add(product);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return products;
	}
	
	
	//query by product id
	
	public void executeQuery(int productID){
		String query = "Select * from product where product_id=?";
		try{
			ps = this.conn.prepareStatement(query);
				ps.setInt(1,productID);
				this.results =  ps.executeQuery();
			}catch (SQLException e){
			e.printStackTrace();
		}
	}
// return a list of products 
	public List<Product> getProductList(){
		List<Product> productList = new ArrayList<>();
		try{			
			while(this.results.next()){
				System.out.println("Getting Results");
				Product product = new Product();
				product.setProductName(this.results.getString("product_name"));
				product.setPrice(this.results.getDouble("product_price"));
				product.setProductID(this.results.getInt("product_id"));
				product.setType(this.results.getString("product_type"));
				product.setPlatform(this.results.getString("product_platform"));
				product.setCoverage(this.results.getString("product_coverage"));
				product.setProductDesc(this.results.getString("product_description"));
				productList.add(product);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("Returning Results");
		return productList;
		
	}
	
	public void addProduct(Product product) throws SQLException{
		String query = "INSERT INTO `product`(`product_name`, `product_price`, `product_type`, `product_platform`, `product_coverage`, `product_description`) VALUES (?,?,?,?,?,?) ";
		try{
			this.ps =conn.prepareStatement(query);
			ps.setString(1, product.getProductName());
			ps.setDouble(2,product.getPrice());
			ps.setString(3, product.getType());
			ps.setString(4, product.getPlatform());
			ps.setString(5, product.getCoverage());
			ps.setString(6, product.getProductDesc());
			ps.executeUpdate();
			
		}finally{
			closeConnection();
		}
	}
	
	public Product getEditableProduct(){
			Product product = new Product();
		try{
			if(this.results.next()){
				product.setProductName(this.results.getString("product_name"));
				product.setPrice(this.results.getDouble("product_price"));
				product.setProductID(this.results.getInt("product_id"));
				product.setType(this.results.getString("product_type"));
				product.setPlatform(this.results.getString("product_platform"));
				product.setCoverage(this.results.getString("product_coverage"));
				product.setProductDesc(this.results.getString("product_description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
		}
		return product;
	}
	
// close connections
	public void closeConnection() {
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
