<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link type="text/css" rel="stylesheet" media="all" href="css/chat.css" />
<link type="text/css" rel="stylesheet" media="all" href="css/screen.css" />
<title>Login</title>
<script type="text/javascript" src="scripts/jquery-1.3.1.min.js"></script>
<script type="text/javascript" src="scripts/jquery.form.js"></script>
<script type="text/javascript" src="scripts/jquery.elastic.js"></script>
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="scripts/chat.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
<c:set var="setVariable" value="${username}" scope="session" />
<div id="">
<div id="at-container">
<div id="at-headerlogo">
<h2>Question and Answer Site</h2>
</div>
<div id="at-header">
<div id="at-headermenu">
	<ul id="nav">
		<li><a href="welcome.htm?username=<core:out value="${username}" />">Home</a></li>
        <li><a href="postquestion.htm?username=<core:out value="${username}" />">PostQuestion</a></li>
        <li><a href="message.htm?username=<core:out value="${username}" />">Message</a></li>
        <li><a href="profile.htm?username=<core:out value="${username}" />">My Profile</a></li>
        <li><a href="chat.htm?username=<core:out value="${username}" />">Chat</a>
        <li><a href="logout.htm">Logout</a></li>
	</ul>
</div>
</div>
<div id="at-content">
    <div class="sectionheader">
       <div class="sectionheader-left">
       		Welcome to Question and Answer Site
       	</div>
       </div>
       
        
        <p>
         Use the menu items available on top to access the features.
         </p>
         <div id="onlineusers">Online User
         </div>
         <a href="javascript:void(0)" onClick="javascript:chatWith('gauravhardiya')">Chat With gauravhardiya</a>
      </div>
      <br />
      <br />
      <br />
      <br />
       <div id="at-footer">
  			<strong>Copyright &copy; 2010
			<a class="footerLink" href="http://localhost:8080/" style="text-decoration:none; font-weight:bold">QnA Site</a>
			  All Rights Reserved. | USER: ${username} </strong>
    	</div>
</div>
</div>
</body>
</html>