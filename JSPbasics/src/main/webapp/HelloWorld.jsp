<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h1>Hello World!!</h1>
The Current time on Server: <%=new java.util.Date() %>
<br/>
Converting a String to Upper Case: <%=new String("Hello World").toUpperCase()%>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>