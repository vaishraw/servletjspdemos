package com.samples.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.samples.domain.Student;

import com.samples.service.StudentService;


@WebServlet("/students")
public class StudentViewandAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService studentservice;
	public void init() throws ServletException {
		super.init();
		this.studentservice = new StudentService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = this.studentservice.getStudents();
		request.setAttribute("Students", students);

		RequestDispatcher rd = request.getRequestDispatcher("/viewstudents.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		int age=Integer.parseInt(request.getParameter("age"));
		Student student=new Student(firstname, lastname, age,email, null);
		this.studentservice.addStudent(student);
		List<Student> students = this.studentservice.getStudents();
		request.setAttribute("Students", students);

		RequestDispatcher rd = request.getRequestDispatcher("/viewstudents.jsp");
		rd.forward(request, response);
		
		//doGet(request, response);
	}

}
