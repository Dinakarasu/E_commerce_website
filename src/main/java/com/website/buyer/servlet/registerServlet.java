package com.website.buyer.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.website.buyer.repository.registerRepository;
/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public registerServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("complete the process of register");
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String password=request.getParameter("password");
		String check=request.getParameter("check");
		System.out.println(email);
		
		HttpSession session=request.getSession();
		
		 if(check!=null) {
		registerRepository repo= new registerRepository();
		boolean f= repo.insertIntoreg( firstname, lastname,email, contact,password);
		response.setContentType("text/html;charset=UTF-8");
		if(f) {
			response.sendRedirect("register.jsp");
			//System.out.println("register");

			session.setAttribute("successMsg", "Registration successfully...");
		}else {
			response.sendRedirect("register.jsp");
			session.setAttribute("failedMsg", "Something wrong on server...");
			//System.out.println("failed");
		 }
		 }else {
				response.sendRedirect("register.jsp");
			 session.setAttribute("failedMsg", "please check Agree & terms condition !!!");	
				//System.out.println("please check Agree & terms condition !!! ");
		 }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


