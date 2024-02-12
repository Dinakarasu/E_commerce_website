package com.website.buyer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.website.pojo.*;
import com.website.jdbc.JdbcConnection;
import com.website.buyer.repository.*;

@WebServlet("/check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckOutServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatter1 = new SimpleDateFormat(" | hh:mm a");
			Date date = new Date();
			
//			retrive all cart products
        	ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
//          User authentication
            User auth = (User) request.getSession().getAttribute("auth");
//          Check auth and cart list
            if(cart_list!=null && auth!=null) {
            	Order order = new Order();
            	for( Cart c : cart_list) {
            		//prepare order object
            		order.setId(c.getId());
            		order.setuId(auth.getId());
            		order.setQuantity(c.getQuantity());
            		order.setDate(formatter.format(date)+" "+formatter1.format(date));
            		//instantiate the repo class
            		OrderRepo ord = new OrderRepo(JdbcConnection.dbGetconnection());
            		//calling insert method
            		boolean result = ord.insertOrder(order);
            		
            		if(!result)break;
            	}
            	cart_list.clear();
            	response.sendRedirect("orders.jsp");
            	
            }else {
            	if(auth==null)response.sendRedirect("login.jsp");
            	response.sendRedirect("cart.jsp");
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
