<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Student List</h1>
	<table>
		<tr>
			<th>Student Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Age</th>
			<th>Class ID</th>
		</tr>
		<c:forEach var="student" items="${Students}" >
			<tr>
				<td>${student.id}</td>
				<td>${student.firstname}</td>
				<td>${student.lastname}</td>
				<td>${student.email}</td>
				<td>${student.age}</td>
				<td>${student.class1.id}</td>
				

			</tr>

		</c:forEach>
	</table>
<br/>
	<a href="LearnersAcademy.html">Home</a>
</body>
</html>