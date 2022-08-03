package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/readuserServlet")
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	@Override
		public void init() throws ServletException {
		try {
			System.out.println("Inside Read user servlet init() method DB connection created");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(Statement	statement = connection.createStatement();){
				
				ResultSet results = statement.executeQuery("select * from user");
				PrintWriter out=response.getWriter();
				out.println("<table>");
				out.println("<tr>");
				out.println("<th>First Name</th>");
				out.println("<th>Last Name</th>");
				out.println("<th>Email</th>");
				out.println("</tr>");
				while (results.next()) {
					out.println("<tr>");
					out.println("<td>" + results.getString(1) + "</td>");
					out.println("<td>" + results.getString(2) + "</td>");
					out.println("<td>" + results.getString(3) + "</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<p><a href=\"userhome.html\">Home</a></p>");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
	}
    @Override
    public void destroy() {
    	try {
    		System.out.println("Inside Read user Servlet destroy() method connection destroyed");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
