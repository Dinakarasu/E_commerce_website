package com.website.buyer.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.website.pojo.Selleruser;
import com.website.pojo.User;

public class LoginRepository {	
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public LoginRepository(Connection con) {
		this.con = con;
	}
	


	public User userLogin(String email, String password) {
		User user = null;
        try {
            query = "select * from users where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print("login "+e.getMessage());
        }
        return user;
    }
	public User Forgetpassword(String email) {
		User forget =null;
        try {
            query = "select * from users where email=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
            	forget = new User();
            	forget.setId(rs.getInt("id"));
            	forget.setName(rs.getString("name"));
            	forget.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print("password reset"+e.getMessage());
        }
		return forget;
		
	}

}
