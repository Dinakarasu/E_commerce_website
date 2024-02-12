package com.website.seller.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.website.jdbc.JdbcConnection;
public class SellerregisterRepository{
	public boolean insertIntoSellreg( String firstname,
			String lastname,String email,String contact,String password) {
		boolean f=false;
		try {
			Connection con= JdbcConnection.dbGetconnection();
			String insertQuery= "insert into Sellerusers (firstname, lastname, email, contact, password, name) values (?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			String name= firstname+" "+lastname;
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, contact);
			ps.setString(5, password);
			ps.setString(6, name);
			int result =ps.executeUpdate();
			if (result ==1) {
				f=true;	
				}
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return f;
	}
}
