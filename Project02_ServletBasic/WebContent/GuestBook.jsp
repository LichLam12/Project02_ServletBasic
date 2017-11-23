<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Guest Book</title>
</head>
<body>
	<h2>Guest Book</h2>
	
	<table border='1'>
		<tr>
			<th>Key</th>
			<th>Name</th>
			<th>Message</th>
			<td></td>
			<td></td>
		</tr>
		<c:forEach var="list" items="${guestbook }" >
		<tr>
			<td>${list.id }</td>
			<td>${list.name }</td>
			<td>${list.message }</td>
			<td><a href="Display_Add_EditEntry?temp=${list.id }">Edit</td>
			<td><a href="DeleteEntry?temp=${list.id }">Delete</td>
		</tr>
		</c:forEach>
	</table>
	<p><a href='Display_Add_EditEntry'>Leave a comment (with session)</a></p>
</body>
</html>