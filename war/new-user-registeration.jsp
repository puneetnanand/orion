<%@ include file="include.jsp" %>

<html>
  <head><title>Hello :: Spring Application</title></head>
  <body>
    <h1>Hello - Spring Application</h1>
    
    <form name="input" action="<%= UrlRoutingHelper.getRouteTo("new-user-registeration") %>?action=submitForm" method="post">
		Email Id: <input type="text" name="email" />
		<br/>
		Password: <input type="password" name="password"/>
		<br/>
		Profession: <input type="text" name="profession" />
		<br/>
		Skillset:
		<br/>
		Please enter comma separated words or phrases example: "singing opera, cooking, playing violin".
		It would be great if you are specific and elaborate about your skills.
		<br/>
		<textarea>
		</textarea>
		<br/>
		<input type="submit" value="Submit" />
	</form> 
    
  </body>
</html>