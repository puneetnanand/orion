<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question And Answer Website</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="foot_bg">
<div id="main">
<!-- header begins -->
<div id="header">

	<div id="logo">
<h2>Question And Answer Site</h2>      </div>

   <div id="buttons">
      <li><a href="welcome.htm?username=<core:out value="${username}" />">Home</a></li>
        <li><a href="postquestion.htm?username=<core:out value="${username}" />">PostQuestion</a></li>
        <li><a href="message.htm?username=<core:out value="${username}" />">Message</a></li>
        <li><a href="profile.htm?username=<core:out value="${username}" />">My Profile</a></li>
        <li><a href="chat.htm?username=<core:out value="${username}" />">Chat</a>
        <li><a href="logout.htm">Logout</a></li>
    </div>
</div> 
<!-- header ends -->
        <!-- content begins --><br />
        <br/>
       			<div id="content">
                <br />
                <div align="center">
                <form:form action="loginform.htm"  commandName="loginForm">
				<table  background="images/bg.jpg" align="center">
				<tr>
					<td>User Name:<FONT color="red"><form:errors
						path="userName" /></FONT></td>
				</tr>
				<tr>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password:<FONT color="red"><form:errors
					path="password" /></FONT></td>
				</tr>
				<tr>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
				</table>
				</form:form>
                        
                          </div>
                <div style="clear: both"></div>
        		</div>
    <!-- content ends --> 
<!-- footer begins -->
            <div id="footer">
           
</div>
        <!-- footer ends -->
</div>

</div>
</body>
</html>
