package com.samples.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.samples.domain.Class;
import com.samples.service.ClassService;

@WebServlet("/classes")
public class ClasseViewandAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassService classService;

	public void init() throws ServletException {
		super.init();
		this.classService = new ClassService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Class> classes = this.classService.getClasses();
		request.setAttribute("Classes", classes);

		RequestDispatcher rd = request.getRequestDispatcher("/viewclasses.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String time=request.getParameter("time");
		Class class1=new Class(time);
		this.classService.addClass(class1);
		List<Class> classes = this.classService.getClasses();
		request.setAttribute("Classes", classes);

		RequestDispatcher rd = request.getRequestDispatcher("/viewclasses.jsp");
		rd.forward(request, response);

		//doGet(request, response);
	}

}
