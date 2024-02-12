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
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class NoCacheFilter extends HttpFilter implements Filter {

    public NoCacheFilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse res= (HttpServletResponse) response;
		
		res.setHeader("Cache-Control", "no-cache, no-store"); // HTTP 1.0
        
		res.setHeader("Pragma", "no-cache"); // HTTP 2.0
       
		res.setDateHeader("Expires", 0);
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
