<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Login page</h1>

	<sf:form modelAttribute="account" action="/twitter/login" method="POST">
		<div>
			<sf:input path="username" type="text"/>
		</div>
		<div>
			<sf:input path="password" type="password"/>
		</div>
		<div>
			<input type="submit" value="Login"/>
		</div>
	</sf:form>
	
</body>
</html>