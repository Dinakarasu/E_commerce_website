package com.website.seller.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.website.jdbc.JdbcConnection;
public class SellerProductRepository{
	public boolean insertIntopro( String productname,
			String image,double price,String description ,String category,String address) {
		boolean p=false;
		try {
			Connection con= JdbcConnection.dbGetconnection();
			String insertQuery= "insert into products (productname, image, description, price , category, address) values (?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			ps.setString(1, productname);
			ps.setString(2, image);
			ps.setDouble(3, price);
			ps.setString(4, description);
			ps.setString(5, category);
			ps.setString(6, address);
			int result =ps.executeUpdate();
			System.out.print("seller repo"+result);
			if (result ==1) {
				p=true;	
				}
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return p;
	}
}
