package com.website.seller.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.website.jdbc.JdbcConnection;
public class SellerAddProductRepository{
	public boolean insertIntoaddpro( String productname,
			String image,String price,String description ,String category,String address,String status,int add_userid,String add_date) {
		boolean p=false;
		try {
			Connection con= JdbcConnection.dbGetconnection();
			String insertQuery= "insert into products (productname, image, price, description , category, address,status,add_userid,add_date) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			ps.setString(1, productname);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, description);
			ps.setString(5, category);
			ps.setString(6, address);
			ps.setString(7, status);
			ps.setInt(8, add_userid);
			ps.setString(9, add_date);
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
