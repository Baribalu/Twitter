<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Logout page</h1>

	<div>Welcome ${account.username}</div>

	<sf:form modelAttribute="account" action="/twitter/login" method="POST">
		<div>
			<input type="submit" value="Logout"/>
		</div>
	</sf:form>
	
</body>
</html>