
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="com.samples.domain.Teacher" %>
<%@page import="com.samples.domain.Subject" %>
<%@page import="com.samples.domain.Class" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Class Report</h1>
<h1>Choose a Class for Report Page</h1>
<%
Configuration con = new Configuration();
con.configure("hibernate.cfg.xml");
SessionFactory sf  = con.buildSessionFactory();
Session hibernateSession = sf.openSession();
	
	List<Class> classes = hibernateSession.createQuery("from Class").list();
%>

<form action="ClassReport.jsp" method="post">
<table>
<tr>
<th>Class ID </th>

</tr>

<tr>
<td>
<select name="class">
<%
	for (Class clas : classes){
	out.print("<option>" + clas.getId());
	out.print("</option>");
	}
%>
</select>
</td>
</tr>
</table>
	<input type="submit" value="Submit">
	</form>
	
<br/>
	<a href="LearnersAcademy.html">Home</a>

</body>
</html>