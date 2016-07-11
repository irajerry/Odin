package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhandler.ProductSearch;
import model.Product;
/**
 * Servlet implementation for class ProductItem
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch(action.toUpperCase()){
				
		case "ITEM":
				int prodID = Integer.parseInt(request.getParameter("productID"));
				ProductSearch product = null; // new instance of product search dbhandler which extends dbUtils
		
			try {
				product = new ProductSearch();
				product.executeQuery(prodID); //executing query and selecting product based of productID
				List<Product> productList = product.getProductList(); //returning a list of product items storing them in arraylist of product items
				request.setAttribute("product",productList); // setting the product list as a request attribute to be available in jsp as ${product}
				request.getRequestDispatcher("/productItem.jsp").forward(request, response);// sending request to productItem.jsp
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	
			}finally{
			product.closeConnection();	
			System.out.println("Closing Connection");
		}
			
		break;
		
		case "CATEGORY":
				ProductSearch product1 = null;
				String type = request.getParameter("type");
			try{
				product1 = new ProductSearch();
				product1.executeQuery(type);// executing query for all products
				List<Product> products = product1.returnAllProducts(); // returning a list of all products in database
				request.setAttribute("products", products);//setting products as request attribute ${products} in jsp
				request.getRequestDispatcher("/products.jsp").forward(request,response); // sending request to products.jsp
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				product1.closeConnection();
			}
			
			break;
			
			
			
		case "ADDPRODUCT":
			try {
				ProductSearch ps = new ProductSearch();
				String productName = request.getParameter("productName");
				String productDescription = request.getParameter("description");
				String productType = request.getParameter("productType");
				double price = Double.parseDouble(request.getParameter("price"));
				String productCoverage = request.getParameter("coverage");
				String productPlatform = request.getParameter("platform");
				Product newProduct = new Product();
					newProduct.setCoverage(productCoverage);
					newProduct.setPrice(price);
					newProduct.setPlatform(productPlatform);
					newProduct.setProductDesc(productDescription);
					newProduct.setProductName(productName);
					newProduct.setType(productType);
				ps.addProduct(newProduct);
				request.getRequestDispatcher("/admin.jsp").forward(request, response);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
					
			break;
			
		case "GETALL":
			try {
				ProductSearch ps4 = new ProductSearch();
				ps4.executeQueryToEdit();
				List<Product>editableProducts = ps4.getProductList();
				request.setAttribute("products", editableProducts);
				request.getRequestDispatcher("/editableProducts.jsp").forward(request, response);
				
				
				
			} catch (IllegalAccessException | ClassNotFoundException | InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			break;
		case "EDIT":
			
			 
			ProductSearch product11 = null; // new instance of product search dbhandler which extends dbUtils
	
		try {
			product11 = new ProductSearch();
			product11.executeQuery(Integer.parseInt(request.getParameter("productID"))); //executing query and selecting product based of productID
			Product product111 = product11.getEditableProduct(); //returning a list of product items storing them in arraylist of product items
			request.setAttribute("product",product111); // setting the product list as a request attribute to be available in jsp as ${product}
			request.getRequestDispatcher("/editProduct.jsp").forward(request, response);// sending request to productItem.jsp
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally{
		product11.closeConnection();	
		System.out.println("Closing Connection");
	}
		
		break;
			
		
		
		
		
			
		case "EDITPRODUCT":
			
			try {
				ProductSearch ps3 = new ProductSearch();
				String productName = request.getParameter("productName");
				String productDescription = request.getParameter("description");
				String productType = request.getParameter("productType");
				double price = Double.parseDouble(request.getParameter("price"));
				String productCoverage = request.getParameter("coverage");
				String productPlatform = request.getParameter("platform");
				Product editProduct = new Product();
					editProduct.setCoverage(productCoverage);
					editProduct.setPrice(price);
					editProduct.setPlatform(productPlatform);
					editProduct.setProductDesc(productDescription);
					editProduct.setProductName(productName);
					editProduct.setType(productType);
					editProduct.setProductID(Integer.parseInt(request.getParameter("productID")));
					System.out.print(editProduct.toString());
					
				ps3.updateProduct(editProduct);
				//response.sendRedirect("/admin.jsp");
				//request.getRequestDispatcher("/editableProducts.jsp").forward(request, response);
				request.getRequestDispatcher("/admin.jsp").forward(request, response);

				
			} catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		
		} 
			
		}
	
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
