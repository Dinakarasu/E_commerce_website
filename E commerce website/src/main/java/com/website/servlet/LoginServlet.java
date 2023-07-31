package com.website.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.website.repository.LoginRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Do Get Login Method called");
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("do post method call");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		HttpSession session =req.getSession();		
		LoginRepository repo= new LoginRepository();
		boolean isValidUser= repo.checkValidUser(email, password);
		System.out.println("valid");
		if(isValidUser) {
			session.setAttribute("email",email);
			res.sendRedirect("home");
		}else {
			System.out.println("failed");
		}	
	}
}