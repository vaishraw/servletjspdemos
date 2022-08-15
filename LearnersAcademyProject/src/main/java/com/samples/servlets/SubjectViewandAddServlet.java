package com.samples.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samples.domain.Subject;

import com.samples.service.SubjectService;


@WebServlet("/subjects")
public class SubjectViewandAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SubjectService subjectservice;
	public void init() throws ServletException {
		super.init();
		this.subjectservice = new SubjectService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Subject> subjects = this.subjectservice.getSubjects();
		request.setAttribute("Subjects", subjects);

		RequestDispatcher rd = request.getRequestDispatcher("/viewsubjects.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		String shortcut=request.getParameter("shortcut");
		Subject subject=new Subject(name, shortcut, null);
		this.subjectservice.addSubject(subject);
		List<Subject> subjects = this.subjectservice.getSubjects();
		request.setAttribute("Subjects", subjects);

		RequestDispatcher rd = request.getRequestDispatcher("/viewsubjects.jsp");
		rd.forward(request, response);

	}

}
