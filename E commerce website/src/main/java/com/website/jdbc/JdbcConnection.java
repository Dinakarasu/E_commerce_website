package com.website.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JdbcConnection {
	public static Connection dbGetconnection() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/website";
		Connection Con=DriverManager.getConnection(url,"root" ,"172001");
		return Con;		
	}
}
