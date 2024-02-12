package com.website.seller.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.website.jdbc.JdbcConnection;
import com.website.pojo.*;
import com.website.seller.repository.SellerProductRepository;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/sellerproduct")
public class SellerproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SellerproductServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("complete the process of seller all products");
		request.getRequestDispatcher("allproduct.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String productname=request.getParameter("productname");
			String image=request.getParameter("image");
			double price=Double.parseDouble(request.getParameter("price"));
			String category=request.getParameter("category");
			String description=request.getParameter("description");
			String address=request.getParameter("address");

			HttpSession session=request.getSession();		
			System.out.println("all product!!!");
			
		    SellerProductRepository repo= new SellerProductRepository();
			boolean p = repo.insertIntopro(productname, image,price,description, category, address);
			//response.setContentType("text/html;charset=UTF-8");
			System.out.println("seller product!!!");
			if(p) {
				response.sendRedirect("addproduct.jsp");
				session.setAttribute("successMsg", "Add successfully...");			
			System.out.println("seller add product!!!");
			}else {
				response.sendRedirect("addproduct.jsp");	
				session.setAttribute("failedMsg", "Something wrong on server...");
				System.out.println("seller not add product!!!");
		//	out.print("Error please try again to register !!!");
		}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}


