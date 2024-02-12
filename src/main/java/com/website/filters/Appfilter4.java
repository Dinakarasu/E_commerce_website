package com.website.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/pro"})
public class Appfilter4 extends HttpFilter implements Filter {
       
    public Appfilter4() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		
		HttpSession session= req.getSession();
		if(session.getAttribute("email")!=null) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("sellerlogin");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
