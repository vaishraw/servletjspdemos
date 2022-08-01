package com.servlets.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h2>Welcome to Server</h2>");
		pw.println("</body>");
		pw.println("</html>");
		
	}

}
