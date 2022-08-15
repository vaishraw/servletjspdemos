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

@WebServlet("/subjectsAssign")
public class subjectassignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SubjectService subjectservice;
	public void init() throws ServletException {
		super.init();
		this.subjectservice = new SubjectService();
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("subjectid"));
		int cid = Integer.parseInt(request.getParameter("classid"));
		this.subjectservice.assignsubject(sid,cid);
		List<Subject> subjects = this.subjectservice.getSubjects();
		request.setAttribute("Subjects", subjects);

		RequestDispatcher rd = request.getRequestDispatcher("/viewsubjects.jsp");
		rd.forward(request, response);
	}

}
