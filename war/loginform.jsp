<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3>Login</h3>

<form action="loginform.htm" method="post"  >
	<table>
		<tr>
			<td>User Name:</td>
		</tr>
		<tr>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Password:</td>
		</tr>
		<tr>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form>
<h3><a href="registrationform.htm">New User</a></h3>
</body>
</html>