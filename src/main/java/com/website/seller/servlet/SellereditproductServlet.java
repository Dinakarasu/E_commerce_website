package com.website.seller.servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.website.jdbc.JdbcConnection;
import com.website.pojo.*;
import com.website.seller.repository.SellerProductRepository;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/editproduct")
@MultipartConfig
public class SellereditproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SellereditproductServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("complete the process of seller add product");
		request.getRequestDispatcher("edit_product.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
            SimpleDateFormat formatter1 = new SimpleDateFormat(" | hh:mm a");

            Date date = new Date();
			HttpSession session=request.getSession();		


            Selleruser auth1 = (Selleruser) request.getSession().getAttribute("auth1");
            
	        //int id=Integer.parseInt(request.getParameter("id"));		
			if(auth1 != null) {
			String productname=request.getParameter("productname");
			String price=request.getParameter("price");
			String description=request.getParameter("description");
			String address=request.getParameter("address");
			String check=request.getParameter("check");
			String status = request.getParameter("status");
			
			String add_date = (formatter.format(date)+" "+formatter1.format(date));
			
			System.out.println("add product!!!");
			
			
			if(check!=null) {
				SellerProductRepository repo= new SellerProductRepository();
			boolean p = repo.updateproduct(productname,price,description, address,status,add_date);
			System.out.println("seller update!!!");
			
			if(p) {
				response.sendRedirect("allproduct.jsp");
				session.setAttribute("successMsg", "Updated successfully...");			
			System.out.println("seller update product!!!");
			}else {
				response.sendRedirect("edit_product.jsp");	
				session.setAttribute("failedMsg", "Something wrong on server...");
				System.out.println("seller not update product!!!");
		}
			}else {
			response.sendRedirect("edit_product.jsp");
		 session.setAttribute("failedMsg", "please checkbox !!!");	
			System.out.println("please select checkbox !!! ");
			}
			}else {
	        	response.sendRedirect("sellerlogin.jsp");
	       	 session.setAttribute("failedMsg", " Again login !!!");	
	        }
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error edit update!!");
			}
	}
}


