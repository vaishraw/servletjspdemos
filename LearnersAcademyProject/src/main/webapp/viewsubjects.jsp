<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Subject List</h1>
	<table>
		<tr>
			<th>Subject Id</th>
			<th>Subject Name</th>
			<th>Subject Code</th>
			
			<th>Class ID</th>
		</tr>
		<c:forEach var="subject" items="${Subjects}" >
			<tr>
				<td>${subject.id}</td>
				<td>${subject.name}</td>
				<td>${subject.shortcut}</td>
				<td>${subject.class1.id}</td>

			</tr>

		</c:forEach>
	</table>
<br/>
	<a href="LearnersAcademy.html">Home</a>

</body>
</html>