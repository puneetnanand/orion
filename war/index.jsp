<%@ include file="include.jsp" %>

<html>
<head>
</head>
<body>
	<h1>Welcome to Orion. Please choose among following options:</h1>
	<a href="<%= UrlRoutingHelper.getRouteTo("new-user-registeration") %>?action=showForm">Register as a new user.</a>
	<br />
	<a href="<%= UrlRoutingHelper.getRouteTo("login") %>">Login if you are an existing user.</a>
</body>
</html>