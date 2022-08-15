package com.samples.servlets;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.PrintWriter;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samples.domain.Product;

//import com.samples.domain.Product;
//import com.samples.model.Student;


@WebServlet("/productinfoservlet")
public class productInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Product product;
    public productInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int productid=(int) session.getAttribute("ProductID");
		String productname=(String) session.getAttribute("ProductName");
		int productcost=(int) session.getAttribute("productCost");
	    product=new Product(productid, productname, productcost);
		RequestDispatcher rd = request.getRequestDispatcher("/product-info.jsp");
		rd.forward(request, response);
		//response.setContentType("text/html");
		/*PrintWriter out = response.getWriter();
		out.println("<h1>Product ID is: " + productid+"<br/>");
		out.println("<h1>Product Name is: " + productname+"<br/>");
		out.println("<h1>Product Cost is: " + productcost+"<br/>");*/

		
		
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productid=Integer.parseInt(request.getParameter("productid"));
		String productname=request.getParameter("productname");
		int productcost=Integer.parseInt(request.getParameter("productcost"));
		
		//Product product=new Product(productid, productname, productcost);
		HttpSession session=request.getSession();
		
		session.setAttribute("ProductID",productid );
		session.setAttribute("ProductName",productname );
		session.setAttribute("productCost",productcost);
		doGet(request,response);
		
	}

}
