<%@page import="java.util.Set"%>
<%@page import="com.samples.domain.Teacher"%>
<%@page import="com.samples.domain.Subject"%>
<%@page import="com.samples.domain.Class"%>
<%@page import="com.samples.domain.Student"%>

<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String clas = request.getParameter("class");
	%>
	<h1>
		Class Report for
		<%=clas%></h1>
	<%
	Configuration con = new Configuration();
	con.configure("hibernate.cfg.xml");
	SessionFactory sf = con.buildSessionFactory();
	Session hibernateSession = sf.openSession();
	List<Class> classes = hibernateSession.createQuery("from Class c1 where c1.id=" + clas).list();
	Class clasForReport = classes.get(0);
	%>

	<table>
		<tr>
			<th>Teacher Name</th>
			<th>Subject Name</th>
		</tr>
		<%
		for (Teacher teacher : clasForReport.getTeachers()) {
			out.print("<tr>");
			out.print("<td>" + teacher.getFirstname() + " " + teacher.getLastname() + "</td>");
			out.print("<td>" + getSubjectName(teacher) + "</td>");
			out.print("</tr>");
		}
		%>
	
	<%!public String getSubjectName(Teacher teacher) {

		Subject subject = teacher.getSubject();

		String sname;

		if (teacher != null) {
			sname = subject.getName();

			return (sname);
		} else {
			return "no subject assigned";
		}
	}%>
	

		<tr>
			<th>Listed Students</th>
		</tr>
		<%
		for (Student student : clasForReport.getStudents()) {
			out.print("<tr>");
			out.print("<td>" + student.getFirstname() + " " + student.getLastname() + "</td>");
			out.print("</tr>");
		}
		%>
	</table>
<br/>
	<a href="LearnersAcademy.html">Home</a>
</body>
</html>