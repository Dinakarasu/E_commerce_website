package com.website.buyer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/productview")
public class productview extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public productview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do Get productview Method called");
		request.getRequestDispatcher("productview.jsp").forward(request, response);
	}
}
