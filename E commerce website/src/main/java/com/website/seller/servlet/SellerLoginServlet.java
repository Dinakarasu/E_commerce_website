package com.website.seller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.website.seller.repository.SellerLoginRepository;


@WebServlet("/sellerlogin")
public class SellerLoginServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Do Get seller Login Method called");
		req.getRequestDispatcher("sellerlogin.jsp").forward(req, res);
	}	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("do post method call in seller login");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		HttpSession session =req.getSession();		
		SellerLoginRepository repo= new SellerLoginRepository();
		boolean isValidUser= repo.checkValidUser(email, password);
		System.out.println("valid");
		System.out.println(email);
		System.out.println(password);
		if(isValidUser) {
			session.setAttribute("email",email);
			res.sendRedirect("home");
		}else {
			System.out.println("failed");
		}	
	}
}