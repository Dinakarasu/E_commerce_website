package com.website.seller.passwordreset.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateOtp
 */
@WebServlet("/sellerValidateOtp")
public class SellerValidateOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value=Integer.parseInt(request.getParameter("otp"));
		HttpSession session=request.getSession();
		int otp=(int)session.getAttribute("otp");
		
		RequestDispatcher dispatcher=null;
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out=response.getWriter()){
		if (value==otp) {
				request.setAttribute("email", request.getParameter("email"));
				request.setAttribute("status", "success");
			  dispatcher=request.getRequestDispatcher("sellerreset.jsp");
			dispatcher.forward(request, response);			
		}
		else{
			response.sendRedirect("sellerotp.jsp");
			session.setAttribute("failedMsg","Wrong otp try again!!! Click back button and refresh get new OTP");
		}
	}
	}
}
