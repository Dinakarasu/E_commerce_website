package com.website.buyer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.website.jdbc.JdbcConnection;
import com.website.pojo.Cart;
import com.website.pojo.ProductDetails;

public class ProductRepository {
	private Connection con;
	private String query;
	private PreparedStatement ps;
	private ResultSet result;
	
	public ProductRepository(Connection con) {
		super();
		this.con = con;
	}
	public List<ProductDetails> getAllProducts() throws SQLException, ClassNotFoundException{
		List<ProductDetails> products= new ArrayList<>();
		con= JdbcConnection.dbGetconnection();
		query= "select * from products";
		ps= con.prepareStatement(query);
		System.out.println("product repository");
		
		result =ps.executeQuery(query);
		
		while(result.next()) {
			ProductDetails product= new ProductDetails();
			product.setId(result.getInt("id"));
			product.setName(result.getString("productName"));
			product.setPrice(result.getDouble("price"));
			product.setDescription(result.getString("description"));
			product.setRating(result.getInt("rating"));
			product.setImage(result.getString("image"));
			product.setCategory(result.getString("category"));
			
			products.add(product);	
		}	
		return products;
	}

public List<Cart> getCartProducts(ArrayList<Cart> cartList){
	List<Cart> product = new ArrayList<>();
	try {
		if(cartList.size()>0) {
			for(Cart item : cartList) {
				query = "select * from products where id=?";
				ps = this.con.prepareStatement(query);
				ps.setInt(1, item.getId());
                result = ps.executeQuery();
                while (result.next()) {
                    Cart row = new Cart();
                    row.setId(result.getInt("id"));
                    row.setName(result.getString("productName"));
                    row.setImage(result.getString("image"));
                    row.setCategory(result.getString("category"));
                    row.setPrice(result.getDouble("price")*item.getQuantity());
                    row.setQuantity(item.getQuantity());
                    product.add(row);
			}
		}
	}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return product;
}
public double getTotalCartPrice(ArrayList<Cart> cartList) {
    double sum = 0;
    try {
        if (cartList.size() > 0) {
            for (Cart item : cartList) {
                query = "select price from products where id=?";
                ps = this.con.prepareStatement(query);
                ps.setInt(1, item.getId());
                result = ps.executeQuery();
                while (result.next()) {
                    sum+=result.getDouble("price")*item.getQuantity();
                }

            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("get total"+e.getMessage());
    }
    return sum;
}
public ProductDetails getSingleProduct(int id) {
	ProductDetails row=null;
	 
	 try {
		 query = "Select * from products where id=?";
		 ps = this.con.prepareStatement(query);
		 ps.setInt(1, id);
		 result=ps.executeQuery();
		 
		 while(result.next()) {
			 row =new ProductDetails();
			 row.setId(result.getInt("id"));
			 row.setName(result.getString("productName"));
			 row.setCategory(result.getString("category"));
			 row.setPrice(result.getDouble("price"));
			 row.setImage(result.getString("image")); 
		 } 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return row;
}
}