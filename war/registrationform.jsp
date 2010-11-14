<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
<!--
body{
	min-width:1004px;
	overflow:-moz-scrollbars-horizontal;
	text-align:center;
	margin:0px;
	padding:0px;
	font-family:Arial, Helvetica, sans-serif;
	font-size:77%;
	}
#at-container {
	width:expression( ( (document.compatMode && document.compatMode=='CSS1Compat') ? document.documentElement.clientWidth : document.body.clientWidth) < 1004 ? "1004px" : "auto" );
	min-width: 1004px;
	}
	#at-headermenu{
	border-bottom:1px solid #233543;
	background-position: left -348px;
	background-color:#24677b;
	}

#at-header{
	background-position: left -240px;
	background-color:#1b2b38;
	background-repeat: repeat-x;
	text-align:left;
	clear:both;
	}
#at-headermenu[id]{
	overflow:hidden;
	}
*html #at-headermenu{
	height:1%;
	}
#at-headermenu{
	border-top:1px solid #70b9ca;
	border-bottom:1px solid #02617f;
	clear:both;
	background-position: left -348px;
	background-color:#24677b;
	}
#at-headermenu ul li{

	background-position: left -894px;
	background-color:#348A9E;
	}
#at-headermenu ul{
	margin:0px 0px 0px 20px;
	padding:0px;
	}
*html #at-headermenu ul li{
	height:1%;
	}
#at-headermenu ul li{
	list-style:none;
	float:left;
	}
#at-headermenu ul li a{
	display:-moz-inline-block;
	display:-moz-inline-box;
	display:inline-block;
	text-decoration:none;
	padding:5px 10px;
	color:#FFF;
	font-weight:bold;
	}
#at-headermenu ul li a:hover{
	background-color:#FFFFFF;
	color:#02617f;
	}
#at-headermenu ul li.active{
	background:#FFFFFF;
	border-right:1px solid #02617f;
	border-left:1px solid #02617f;
	}
#at-headermenu ul li.active a{
	color:#02617f;
	}
#at-headerlogo{
	color:#FFF;
	background-color:#233543;
	}
	div.sectionheader {
	border-bottom:1px solid #000;
	margin:5px 0px;
	padding-bottom:3px;
	}
	div.sectionheader-left{
	font-weight:bold;
}
	#at-content {
	border-bottom:1px solid #cccccc;
	border-right:1px solid #cccccc;
	border-left:1px solid #cccccc;
	}
	#at-footer {
	background-color:#24677b;
	color:#FFF;
	font-size:12px;
-->
</style>
<title>Registration</title>
</head>
<body>
<script type="text/javascript" language="JavaScript">
var counter = 1;
var limit = 5;
function addInput(divName){
     if (counter == limit)  {
          alert("You have reached the limit of adding " + counter + " inputs");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "Skill " + (counter + 1) + " <td><input type='text' name='skills'></td><td>Exp:</td><td><input type='text' name='exp'></td>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}
</script>
<div id="at-container">
<div id="at-headerlogo">
<h2>Question and Answer Site</h2>
</div>
<div id="at-header">
<div id="at-headermenu">
	<h2 align="center">Registration</h2>
</div>
</div>
<div id="at-content">
<form method="post" action="registration.htm">
	<table>
		<tr>
			<td>User Name:</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="text" name="password" /></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="firstname" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lastname" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>Skills:</td>
			<td><input type="text" name="skills" /></td>
			<td>Exp:</td>
			<td><input type="text" name="exp" /></td>
			<td><input type="button" value="Add another skill" onClick="addInput('dynamicInput');"></td>
			<th><div id="dynamicInput"></div></th>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form>
</div>
<div id="at-footer">
  			<strong>Copyright &copy; 2010
			<a class="footerLink" href="http://localhost:8080/" style="text-decoration:none; font-weight:bold">QnA Site</a>
			  All Rights Reserved. | USER: ${username} </strong>
    	</div>
</div>
</body>
</html>