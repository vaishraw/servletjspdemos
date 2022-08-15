
<%@page import="com.samples.domain.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Cost</th>
			
		</tr>
		<tr>
		<td>${param.productid}</td>
		<td>${param.productname}</td>
		<td>${param.productcost}</td>
		</tr>
</table>	 
</body>
</html>