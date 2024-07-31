package com.website.seller.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.website.pojo.*;
import com.website.buyer.repository.ProductRepository;
import com.website.jdbc.JdbcConnection;
public class SellerProductRepository{
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public SellerProductRepository() {}
	
	public SellerProductRepository(Connection con) {
		this.con =con;
	}
	
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
	public List<ProductDetails> getAllproduct(){
		List<ProductDetails> list = new ArrayList<>();
		ProductDetails b = null;
		try {
			query = "select * from products";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				b = new ProductDetails();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setDescription(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setCategory(rs.getString(5));
				b.setImage(rs.getString(6));
				b.setRating(rs.getInt(7));
				b.setAddress(rs.getString(8));
				b.setStatus(rs.getString(9));

				b.setDate(rs.getString(11));
				
				list.add(b);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ProductDetails getproductId(int id) {
		ProductDetails p = null;
		try {
			query = "select * from products where id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			while(rs.next()) {
				p=new ProductDetails();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setCategory(rs.getString(5));
				p.setImage(rs.getString(6));
				p.setRating(rs.getInt(7));
				p.setAddress(rs.getString(8));
				p.setStatus(rs.getString(9));

				p.setDate(rs.getString(11));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public boolean updateproduct(String productname, String price, String description, String address,
			String status, String add_date) {
		
		boolean f =false;
		try {
			Connection con= JdbcConnection.dbGetconnection();
			String updateQuery= "update products set productname=?, price=?, description=? , address=?,status=?,add_date=? where id=? ";
			PreparedStatement ps= con.prepareStatement(updateQuery);
			ps.setString(1, productname);
			ps.setString(2, price);
			ps.setString(3, description);
			ps.setString(4, address);
			ps.setString(5, status);
			ps.setString(6, add_date);
			int result =ps.executeUpdate();
			System.out.print("seller update repo"+result);
			if (result ==1) {
				f=true;	
				}			
			/*query = "update products set productname=?,price=?,status=?,description=?,address=?,date=? where id=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, pro.getName());
			pst.setString(2, pro.getPrice());
			pst.setString(3, pro.getStatus());
			pst.setString(4, pro.getDescription());
			pst.setString(5, pro.getAddress());
			pst.setString(6, pro.getDate());
			
			int i =pst.executeUpdate();
			if(i==1) {
				f=true;
			}	*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
