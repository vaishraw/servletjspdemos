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


@WebServlet("/teachersAssign")
public class teachersAssign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TeacherService teacherservice;

	public void init() throws ServletException {
		super.init();
		this.teacherservice = new TeacherService();
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tid = Integer.parseInt(request.getParameter("teacherid"));
		int cid = Integer.parseInt(request.getParameter("classid"));
		int sid = Integer.parseInt(request.getParameter("subjectid"));
		this.teacherservice.assignTeacher(tid,cid,sid);
		List<Teacher> teachers = this.teacherservice.getTeachers();
		request.setAttribute("Teachers", teachers);

		RequestDispatcher rd = request.getRequestDispatcher("/viewteachers.jsp");
		rd.forward(request, response);
		
		
	}

}
