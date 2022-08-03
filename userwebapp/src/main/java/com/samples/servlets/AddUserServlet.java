package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/adduserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	@Override
		public void init() throws ServletException {
		try {
			System.out.println("Inside Add user servlet init() method DB connection created");
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
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		
		try(Statement	statement = connection.createStatement();){
				String query="insert into user values ('"+firstname+"','"+lastname+"','"+email+"','"+password+"')";
				System.out.println("Query Being Executed: "+query);
				int rowsInserted = statement.executeUpdate(query);
				System.out.println("Number of rows Inserted: "+rowsInserted);
				PrintWriter pw=response.getWriter();
				pw.write("User Successfully Added");
				pw.println("<p><a href=\"userhome.html\">Home</a></p>");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
	}
    @Override
    public void destroy() {
    	try {
    		System.out.println("Inside Add user Servlet destroy() method connection destroyed");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
