package com.website.seller.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.website.jdbc.JdbcConnection;
import com.website.pojo.Selleruser;

public class SellerLoginRepository {	
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public SellerLoginRepository(Connection con) {
		this.con = con;
	}
	


	public Selleruser selleruserLogin(String email, String password) {
		Selleruser selleruser = null;
        try {
            query = "select * from sellerusers where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	selleruser = new Selleruser();
            	selleruser.setId(rs.getInt("id"));
            	selleruser.setName(rs.getString("name"));
            	selleruser.setEmail(rs.getString("email"));
            	selleruser.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.print("login "+e.getMessage());
        }
        return selleruser;
    }
	public Selleruser selleruserForgetpassword(String email) {
		Selleruser sellerforget =null;
        try {
            query = "select * from sellerusers where email=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
            	sellerforget = new Selleruser();
            	sellerforget.setId(rs.getInt("id"));
            	sellerforget.setName(rs.getString("name"));
            	sellerforget.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print("password reset"+e.getMessage());
        }
		return sellerforget;
		
	}
}
