package com.website.buyer.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.website.pojo.Cart;
import com.website.pojo.Order;
import com.website.pojo.User;
import com.website.buyer.repository.OrderRepo;
import com.website.jdbc.JdbcConnection;

@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderNowServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
            SimpleDateFormat formatter1 = new SimpleDateFormat(" | hh:mm a");

            Date date = new Date();

            User auth = (User) request.getSession().getAttribute("auth");

            if (auth != null) {
                String productId = request.getParameter("id");
                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
                if (productQuantity <= 0) {
                	productQuantity = 1;
                }
                Order orderModel = new Order();
                orderModel.setId(Integer.parseInt(productId));
                orderModel.setuId(auth.getId());
                orderModel.setQuantity(productQuantity);
                orderModel.setDate(formatter.format(date)+" "+formatter1.format(date));

                OrderRepo orderRepo = new OrderRepo(JdbcConnection.dbGetconnection());
                boolean result = orderRepo.insertOrder(orderModel);
                if (result) {
                	
                	ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
    				if (cart_list != null) {
    					for (Cart c : cart_list) {
    						if (c.getId() == Integer.parseInt(productId)) {
    							cart_list.remove(cart_list.indexOf(c));
    							break;
    						}
    					}
    				}
                    response.sendRedirect("orders.jsp");
                } else {
                    out.println("order failed");
                }
            } else {
                response.sendRedirect("login.jsp");
            }

        } catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
