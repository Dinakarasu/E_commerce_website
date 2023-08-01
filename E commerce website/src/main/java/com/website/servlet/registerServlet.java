package com.website.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.website.repository.registerRepository;
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
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String password=request.getParameter("password");
		System.out.println(email);
		registerRepository repo= new registerRepository();
		boolean isInserted= repo.insertIntoreg( firstname, lastname,email, contact,password);
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()){
		if(isInserted)
			response.sendRedirect("login");
		else
			response.sendRedirect("error");
		out.print("Error please try again to register !!!");
		}
	}
}


