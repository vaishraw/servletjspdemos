<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List, tagDemo.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
     List<Student> Data=new ArrayList<>();
     Data.add(new Student("Harry","Kumar"));
     Data.add(new Student("Samuel","S"));
     Data.add(new Student("Vijay","Sharma"));
     Data.add(new Student("Maxine","Wiley"));
pageContext.setAttribute("myStudents", Data);
%>
<c:forEach var="student" items="${myStudents}">
${student.firstName} ${student.lastName}
<br/>
</c:forEach>

</body>
</html>