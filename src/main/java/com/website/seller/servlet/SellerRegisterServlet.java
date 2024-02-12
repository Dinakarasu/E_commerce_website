package com.website.seller.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.website.seller.repository.SellerregisterRepository;

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
			SellerregisterRepository repo= new SellerregisterRepository();
			boolean f= repo.insertIntoSellreg( firstname, lastname,email, contact,password);
			if(f) {
				response.sendRedirect("sellerregister.jsp");
				//System.out.println("register");

				session.setAttribute("successMsg", "Registration successfully...");
			}else {
				response.sendRedirect("sellerregister.jsp");
				session.setAttribute("failedMsg", "Something wrong on server...");
				//System.out.println("failed");
			 }
			 }else {
					response.sendRedirect("sellerregister.jsp");
				 session.setAttribute("failedMsg", "please check Agree & terms condition !!!");	
					//System.out.println("please check Agree & terms condition !!! ");
			 }
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}


