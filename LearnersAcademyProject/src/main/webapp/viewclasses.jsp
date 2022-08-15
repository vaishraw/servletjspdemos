<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Classes</title>
</head>
<body>
<h1 align="center">Class List</h1>
<table>
		<tr>
			<th>Class Id</th>
			<th>Class Time</th>
			</tr>
			<c:forEach var="c" items="${Classes}">
			<tr>
				<td>${c.id}</td>
				<td>${c.time}</td>
				
			</tr>
			
		</c:forEach>
</table>
<br/>
	<a href="LearnersAcademy.html">Home</a>
</body>
</html>