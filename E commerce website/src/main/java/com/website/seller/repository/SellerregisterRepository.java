package com.website.seller.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.website.jdbc.JdbcConnection;
public class SellerregisterRepository{
	public boolean insertIntoreg( String firstname,
			String lastname,String email,String contact,String password) {
		try {
			Connection con= JdbcConnection.dbGetconnection();
			String insertQuery= "insert into sellerreg values (?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, contact);
			ps.setString(5, password);
			int result =ps.executeUpdate();
			return result ==1;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return false;
	}
}
