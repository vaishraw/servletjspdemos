<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Teacher List</h1>
	<table>
		<tr>
			<th>Teacher Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Age</th>
			<th>Class ID</th>
			<th>Subject ID</th>
			<th>Subject Code</th>
		</tr>
		<c:forEach var="Teacher" items="${Teachers}">
			<tr>
				<td>${Teacher.id}</td>
				<td>${Teacher.firstname}</td>
				<td>${Teacher.lastname}</td>
				<td>${Teacher.email}</td>
				<td>${Teacher.age}</td>
				<td>${Teacher.class1.id}</td>
				<td>${Teacher.subject.id}</td>
				<td>${Teacher.subject.shortcut}</td>

			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="LearnersAcademy.html">Home</a>

</body>
</html>