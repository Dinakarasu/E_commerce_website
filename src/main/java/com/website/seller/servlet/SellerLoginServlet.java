package com.website.seller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.website.jdbc.JdbcConnection;
import com.website.pojo.Selleruser;
import com.website.seller.repository.SellerLoginRepository;


@WebServlet("/sellerlogin")
public class SellerLoginServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do Get seller Login Method called");
		req.getRequestDispatcher("sellerlogin.jsp").forward(req, response);
	}	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		try{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession session=req.getSession();

		SellerLoginRepository repo= new SellerLoginRepository(JdbcConnection.dbGetconnection());
		Selleruser selleruser = repo.selleruserLogin(email, password);
		if(selleruser!=null) {
			req.getSession().setAttribute("auth1", selleruser);
			System.out.println(" selleruser logged in ");
			response.sendRedirect("sellerhome.jsp");
		}else {
			System.out.println("failed");
			response.sendRedirect("sellerlogin.jsp");
			session.setAttribute("failedMsg", "invalid !!! please enter the valid email and password!!!!");
		}
		}
		catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		}
}