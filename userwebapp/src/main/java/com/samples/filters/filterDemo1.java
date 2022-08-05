package com.samples.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class filterDemo1
 */
@WebFilter("/readuserServlet")
public class filterDemo1 extends HttpFilter implements Filter {
       
    
    public filterDemo1() {
        super();
        
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Demo Filter 1");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("Before calling Servlet");
		chain.doFilter(request, response);
		out.println("after calling servlet");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
