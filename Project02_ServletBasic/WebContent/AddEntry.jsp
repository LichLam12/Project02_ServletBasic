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
	<form action="AddEntry" method="post" style="border: 1px solid;padding: 10px 10px 60px;width: 20%;">
		<h2>ADD ENTRY</h2>
	
		name:<input name="name" type="text" style="margin:5px 0px 5px 30px;"/><br/>
		message:<input name="message" type="text" style="margin:5px 0px 5px 11px;"/><br/>
		
		
		<input type="submit" value="Add"  style="float:right;margin:15px 50px 10px 0px;">
		<a href="GuestBook">
		<input type="button" value="Back" style="float:right;margin:15px 20px 10px 0px;">
		</a>
	</form>
</body>
</html>