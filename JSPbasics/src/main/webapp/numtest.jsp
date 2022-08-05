<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="jspbasics.utils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
Adding 10 to number 20: <%=utils.add10ToNumber(20) %>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>