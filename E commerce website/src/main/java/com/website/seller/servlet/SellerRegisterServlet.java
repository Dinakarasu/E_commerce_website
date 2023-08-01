package com.website.seller.servlet;
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
@WebServlet("/sellerregister")
public class SellerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SellerRegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("complete the process of seller register");
		request.getRequestDispatcher("sellerregister.jsp").forward(request, response);
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
			response.sendRedirect("sellerlogin");
		else
			response.sendRedirect("error");	
		out.print("Error please try again to register !!!");
	}
}
}


