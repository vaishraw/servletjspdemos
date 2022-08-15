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

@WebServlet("/teacherUpdateandDelete")
public class TeacherUpdateandDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TeacherService teacherservice;

	public void init() throws ServletException {
		super.init();
		this.teacherservice = new TeacherService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		this.teacherservice.deleteTeacher(id);
		List<Teacher> teachers = this.teacherservice.getTeachers();
		request.setAttribute("Teachers", teachers);

		RequestDispatcher rd = request.getRequestDispatcher("/viewteachers.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		this.teacherservice.updateTeacher(id, email);
		List<Teacher> teachers = this.teacherservice.getTeachers();
		request.setAttribute("Teachers", teachers);

		RequestDispatcher rd = request.getRequestDispatcher("/viewteachers.jsp");
		rd.forward(request, response);

	}

}
