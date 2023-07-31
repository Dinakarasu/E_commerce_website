package com.website.seller.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.website.jdbc.JdbcConnection;

public class SellerLoginRepository {	
	public boolean checkValidUser(String email, String password) {
		try {
			String dbPassword=null;
			Connection con= JdbcConnection.dbGetconnection();
			String query= "SELECT * FROM sellerreg where email=? or contact=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, email);
			ResultSet result =ps.executeQuery();
			while(result.next()) {
				dbPassword= result.getString("password");
			}
			return dbPassword !=null && password.equals(dbPassword);		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
}
