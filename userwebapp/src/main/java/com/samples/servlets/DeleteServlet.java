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
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	@Override
		public void init() throws ServletException {
		try {
			System.out.println("Inside Delete user servlet init() method DB connection created");
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
		String email=request.getParameter("email");

		try(Statement	statement = connection.createStatement();){
				String query="delete from user where email='"+email+"'";
				System.out.println("Query Being Executed: "+query);
				int rowsDeleted = statement.executeUpdate(query);
				System.out.println("Number of rows Inserted: "+rowsDeleted);
				PrintWriter pw=response.getWriter();
				pw.write("User Successfully Deleted");
				pw.println("<p><a href=\"userhome.html\">Home</a></p>");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
	}
    @Override
    public void destroy() {
    	try {
    		System.out.println("Inside Delete user Servlet destroy() method connection destroyed");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
