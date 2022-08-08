package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productdetailsservlet")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			ServletContext context = config.getServletContext();
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dburl"),
					context.getInitParameter("dbuser"), context.getInitParameter("dbpassword"));
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		int productid = Integer.parseInt(req.getParameter("productid"));

		try (PreparedStatement statement = connection.prepareStatement("select * from product where productid=?")) {
			statement.setInt(1, productid);
			
			ResultSet resultset = statement.executeQuery();
			PrintWriter out = res.getWriter();
			if (!resultset.isBeforeFirst()) {
				out.println("<h2>Invalid ProductID</h2>");
			} else {
				
				out.println("<table>");
				out.println("<tr>");
				out.println("<th>ProductID</th>");
				out.println("<th>ProductName</th>");
				out.println("<th>ProductCost</th>");
				out.println("</tr>");
				while (resultset.next()) {
					out.println("<tr>");
					out.println("<th>" + resultset.getString(1) + "</th>");
					out.println("<th>" + resultset.getString(2) + "</th>");
					out.println("<th>" + resultset.getString(3) + "</th>");
					out.println("</tr>");
				}
				out.println("</table>");
			}
			out.println("<p><a href=\"homepage.html\">Return to Home-Page</a></p>");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		try {
			System.out.println("Inside Product Details destroy() method.DB connection destroyed");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
