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

<%
int num1=Integer.parseInt(request.getParameter("number1"));
int num2=Integer.parseInt(request.getParameter("number2"));
%>
<h1>Sum of <%=num1%> and <%=num2 %>=<%=num1+num2 %></h1>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>