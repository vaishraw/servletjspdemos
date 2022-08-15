package com.samples.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samples.domain.Teacher;

import com.samples.service.TeacherService;

@WebServlet("/teachers")
public class TeacherAddandViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService teacherservice;

	public void init() throws ServletException {
		super.init();
		this.teacherservice = new TeacherService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Teacher> teachers = this.teacherservice.getTeachers();
		request.setAttribute("Teachers", teachers);

		RequestDispatcher rd = request.getRequestDispatcher("/viewteachers.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		Teacher teacher = new Teacher(firstname, lastname, age,email, null, null);
		this.teacherservice.addteacher(teacher);
		List<Teacher> teachers = this.teacherservice.getTeachers();
		request.setAttribute("Teachers", teachers);

		RequestDispatcher rd = request.getRequestDispatcher("/viewteachers.jsp");
		rd.forward(request, response);

	}

}
