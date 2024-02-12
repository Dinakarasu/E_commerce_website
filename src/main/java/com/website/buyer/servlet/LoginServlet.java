package com.website.buyer.servlet;

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
import com.website.pojo.User;
import com.website.buyer.repository.LoginRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()){
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();

		LoginRepository repo= new LoginRepository(JdbcConnection.dbGetconnection());
		User user = repo.userLogin(email, password);
		if(user!=null) {
			request.getSession().setAttribute("auth", user);
			System.out.println(" user logged in ");
            response.sendRedirect("index.jsp");
		}else {
			System.out.println("failed");
            response.sendRedirect("login.jsp");
			session.setAttribute("failedMsg", "invalid !!! please enter the valid email and password!!!!");
			//out.print("invalid !!! please enter the valid email / contact / password!!!!");
		}
		}
		catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		}
}